package scard;

import java.math.BigInteger;
import java.util.List;
import javax.smartcardio.*;
import javax.swing.JOptionPane;

public class theBus {

    Card card;
    CardChannel channel;
    CommandAPDU cmndAPDU;
    ResponseAPDU resAPDU;
    List<CardTerminal> terminals;
    private TerminalFactory factory;
    private CardTerminal terminal;

    public theBus() {
    }

    public boolean connectApplet() {
        try {
            // hiển thị danh sách các thiết bị đầu cuối có sẵn
            TerminalFactory factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            System.out.println("Terminals: " + terminals);
            // lấy terminal đầu tiên
            CardTerminal terminal = terminals.get(0);
            // thiết lập kết nối với thẻ
            card = terminal.connect("*");
            System.out.println("card: " + card);
            //  lấy ATR
            ATR atr = card.getATR();
            byte[] baAtr = atr.getBytes();
            System.out.print("ATR = 0x");
            for (int i = 0; i < baAtr.length; i++) {
                System.out.printf("%02X ", baAtr[i]);
            }
            channel = card.getBasicChannel();
            return true;
        } catch (CardException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void sendAPDUtoApplet(byte[] cmnds, byte[] data) {
        try {
            resAPDU = channel.transmit(new CommandAPDU(cmnds[0], cmnds[1], cmnds[2], cmnds[3], data));
        } catch (CardException e) {
            e.printStackTrace();
        }
    }

    public void sendAPDUtoApplet(byte[] cmnds) {
        try {
            resAPDU = channel.transmit(new CommandAPDU(cmnds[0], cmnds[1], cmnds[2], cmnds[3]));
        } catch (CardException e) {
            e.printStackTrace();
        }
    }

    public boolean disconnectApplet() {
        try {
            card.disconnect(false);
            return true;
        } catch (CardException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String byteToHex(byte data) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%02x", data));
        return result.toString();
    }

    public String shorttoHex(short data) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%02x", data));
        return result.toString();
    }

    public byte[] hexStringToByteArray(String s) {
        int len = s.length();
        System.out.println("len " + len);
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public BigInteger getModulusPubkey() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("*");
            channel = card.getBasicChannel();
            resAPDU = channel.transmit(new CommandAPDU((byte) 0xA0, (byte) 0x22, (byte) 0x01, (byte) 0x01));

            BigInteger res = new BigInteger(1, resAPDU.getData());
            System.out.println("responseM " + res);
            return res;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public BigInteger getExponentPubkey() {
        try {
            factory = TerminalFactory.getDefault();
            terminals = factory.terminals().list();
            terminal = terminals.get(0);
            card = terminal.connect("*");
            channel = card.getBasicChannel();
            resAPDU = channel.transmit(new CommandAPDU((byte) 0xA0, (byte) 0x22, (byte) 0x02, (byte) 0x01));

            BigInteger res = new BigInteger(1, resAPDU.getData());
            System.out.println("responseE " + res);
            return res;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
