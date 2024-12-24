package scard;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Naptien extends javax.swing.JFrame {
    private theBus thebus;
    BigInteger modulusPubkey,exponentPubkey ;
     
    public Naptien() {
        this.thebus = BusForm.thebus;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_sotien = new javax.swing.JTextField();
        btn_NapTien = new javax.swing.JButton();
        txt_pin = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel2.setText("Nhập số tiền:");

        jLabel3.setText("Nhập mã PIN:");

        btn_NapTien.setBackground(new java.awt.Color(204, 204, 204));
        btn_NapTien.setText("Nạp");
        btn_NapTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NapTienActionPerformed(evt);
            }
        });

        txt_pin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pinActionPerformed(evt);
            }
        });

        jLabel4.setText("VND");

        jLabel5.setText("000");

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nạp tiền");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 94, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_sotien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4))
                                    .addComponent(txt_pin, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btn_NapTien, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sotien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txt_pin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addComponent(btn_NapTien)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NapTienActionPerformed(java.awt.event.ActionEvent evt) {
        String pin = Arrays.toString(txt_pin.getPassword());
        String sotien = txt_sotien.getText();
        
        // Kiểm tra số tiền hợp lệ
        try {
            int money = Integer.parseInt(sotien);
            if (money <= 0) {
                JOptionPane.showMessageDialog(this, "Số tiền phải lớn hơn 0");
                return;
            }
            
            // Chuyển số tiền thành byte array
            byte[] moneyBytes;
            if(money <= 255) {
                moneyBytes = new byte[1];
                moneyBytes[0] = (byte)money;
            } else if(money <= 65535) {
                moneyBytes = new byte[2];
                moneyBytes[0] = (byte)(money >> 8);
                moneyBytes[1] = (byte)(money & 0xFF);
            } else {
                JOptionPane.showMessageDialog(this, "Số tiền quá lớn");
                return;
            }

            // Tạo chữ ký
            byte[] cmdcreateSig = {(byte) 0xA0, (byte) 0x16, (byte) 0x01, (byte) 0x00};
            String arraysend = pin.concat(sotien);
            thebus.sendAPDUtoApplet(cmdcreateSig, arraysend.getBytes());
            byte[] aa = thebus.resAPDU.getData();

            if (aa.length == 1 || thebus.resAPDU.getSW1() != 0x90) {
                JOptionPane.showMessageDialog(this, "Giao dịch không thành công. Mã PIN không đúng");
            } else {
                byte[] input = arraysend.getBytes();
                
                try {
                    boolean verifyCheck = Verify_Signature(input, aa);
                    
                    if (verifyCheck) {
                        // Gửi lệnh cập nhật số dư với số tiền đã được chuyển đổi đúng
                        byte[] cmdverify = {(byte) 0xA0, (byte) 0x16, (byte) 0x02, (byte) 0x00};
                        thebus.sendAPDUtoApplet(cmdverify, moneyBytes);
                        byte[] res = thebus.resAPDU.getData();
                        
                        if(res[0] == 0x00) {
                            JOptionPane.showMessageDialog(this, "Giao dịch không thành công. Đã có lỗi xảy ra");
                        } else if(res[0] == 0x01) {
                            // Lấy số dư sau khi nạp thành công
                            byte[] cmdGetSodu = {(byte) 0xA0, (byte) 0x21, (byte) 0x00, (byte) 0x00};
                            thebus.sendAPDUtoApplet(cmdGetSodu);
                            byte[] sodu = thebus.resAPDU.getData();
                            int soduValue = ((sodu[0] & 0xFF) << 8) | (sodu[1] & 0xFF);
                            
                            JOptionPane.showMessageDialog(this, "Giao dịch thành công.\nSố dư hiện tại: " + soduValue*1000 + " VND");
                            setVisible(false);
                        } else if(res[0] == 0x02) {
                            JOptionPane.showMessageDialog(this, "Giao dịch không thành công. Số dư vượt quá giới hạn");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Giao dịch không thành công. Xác thực lỗi");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Naptien.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Giao dịch không thành công. Có lỗi xảy ra");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ");
            return;
        }
    }

    //RSA
    public boolean Verify_Signature(byte[] input,byte[] signatureToVerify) throws Exception{
        if (signatureToVerify.length != 128) {
            throw new SignatureException("Chu ky khong hop le, do dai chu ky phai la 128 byte.");
        }
         byte[] getModulusPubkey = {(byte) 0xA0, (byte) 0x22, (byte) 0x01, (byte) 0x01};
          thebus.sendAPDUtoApplet(getModulusPubkey);
          BigInteger resModulusPubkey = new BigInteger(1, thebus.resAPDU.getData());
          byte[] getExponentPubkey = {(byte) 0xA0, (byte) 0x22, (byte) 0x02, (byte) 0x01};
          thebus.sendAPDUtoApplet(getExponentPubkey);
          BigInteger resExponentPubkey = new BigInteger(1, thebus.resAPDU.getData());
          
        modulusPubkey = resModulusPubkey;
        exponentPubkey = resExponentPubkey;
        System.out.println("pubkey: "+modulusPubkey + " / "+exponentPubkey );
       
        KeyFactory keyFactory = KeyFactory.getInstance("RSA"); //sd RSA de tao key
        RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(modulusPubkey, exponentPubkey); //chua cac thanh phan cua pubKey
        PublicKey key = (RSAPublicKey) keyFactory.generatePublic(pubKeySpec); //tap key
        
        Signature signature = Signature.getInstance("MD5withRSA"); //sd MD5 bam DL + RSA
        signature.initVerify(key); // sd pubKey
        signature.update(input); 
        return signature.verify(signatureToVerify); //xac minh
    }
    private void txt_pinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pinActionPerformed

   
    
    //private static char[] generateOTP(int length) {
   //  String numbers = "158AB90HJNO234Uab67cdCDefghjKLouMklmEFGnywYW";
    //  Random random = new Random();
//      char[] otp = new char[length];
//
//      for(int i = 0; i< length ; i++) {
//         otp[i] = numbers.charAt(random.nextInt(numbers.length()));
//      }
//      return otp;
//   }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_NapTien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_pin;
    private javax.swing.JTextField txt_sotien;
    // End of variables declaration//GEN-END:variables
}
