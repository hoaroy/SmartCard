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
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class thanhtoan extends javax.swing.JFrame {
    private theBus thebus;
    String otp;
    BigInteger modulusPubkey,exponentPubkey ;
    private BusForm parent;

    public void setParent(BusForm parent) {
        this.parent = parent;
    }

    public BusForm getParent() {
        return parent;
    }
    
    public thanhtoan() {
        this.thebus = BusForm.thebus;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_sotien = new javax.swing.JTextField();
        btn_ThanhToan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        txt_sotien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sotienActionPerformed(evt);
            }
        });

        btn_ThanhToan.setBackground(new java.awt.Color(204, 204, 204));
        btn_ThanhToan.setText("Thanh toán");
        btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanActionPerformed(evt);
            }
        });

        jLabel4.setText("VND");

        jLabel5.setText("000");

        jLabel2.setText("Nhập số tiền:");

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Thanh toán");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(txt_sotien, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_sotien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
        //String pin = Arrays.toString(txt_pin.getPassword());
        String sotien = txt_sotien.getText();
        
        // Kiểm tra số tiền hợp lệ
        try {
            int money = Integer.parseInt(sotien);
            if (money <= 0) {
                JOptionPane.showMessageDialog(this, "Số tiền phải lớn hơn 0");
                return;
            }
            // Định dạng lại số tiền
            NumberFormat formatter = new DecimalFormat("#,###");
            String formattedMoney = formatter.format(money);

            // Hiển thị số tiền đã định dạng
            txt_sotien.setText(formattedMoney);
            
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
            byte[] cmdcreateSig = {(byte) 0xA0, (byte) 0x17, (byte) 0x01, (byte) 0x00};
            //String arraysend = pin.concat(sotien);
            //System.out.println("Data to sign (arraysend): " + arraysend);
            //System.out.println("Data to sign (arraysend bytes): " + Arrays.toString(arraysend.getBytes()));
            thebus.sendAPDUtoApplet(cmdcreateSig, sotien.getBytes());
            
            byte[] aa = thebus.resAPDU.getData();
            if (aa.length == 1 || thebus.resAPDU.getSW1() != 0x90) {
                JOptionPane.showMessageDialog(this, "Giao dịch không thành công. Lỗi tạo chữ ký số.");
            } else {
                byte[] input = sotien.getBytes();
                
                try {
                    boolean verifyCheck = Verify_Signature(input, aa);
                    
                    if (verifyCheck) {
                        // Gửi lệnh cập nhật số dư với số tiền đã được chuyển đổi đúng
                        byte[] cmdverify = {(byte) 0xA0, (byte) 0x17, (byte) 0x02, (byte) 0x00};
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
                            
                            JOptionPane.showMessageDialog(this, "Giao dịch thành công.\nSố dư hiện tại: " + soduValue + ".000" + " VND");
                            setVisible(false);
                        } else if(res[0] == 0x02) {
                            JOptionPane.showMessageDialog(this, "Giao dịch không thành công. Số dư không đủ.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Giao dịch không thành công. Xác thực lỗi.");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Naptien.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Giao dịch không thành công. Có lỗi xảy ra");
                }
                
                //System.out.println("Signature length: " + aa.length);
                //System.out.println("Signature content: " + Arrays.toString(aa));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số tiền không hợp lệ");
            return;
        }
        
    }//GEN-LAST:event_btn_ThanhToanActionPerformed
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
       
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(modulusPubkey, exponentPubkey);
        PublicKey key = (RSAPublicKey) keyFactory.generatePublic(pubKeySpec);
        
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(key);
        signature.update(input);
        return signature.verify(signatureToVerify);
    }// private static char[] generateOTP(int length) {
//      String numbers = "1234567890ABCDEFGHJKLMNOUabcdefghjklmnouywYW";
//      Random random = new Random();
//      char[] otp = new char[length];
//
//      for(int i = 0; i< length ; i++) {
//         otp[i] = numbers.charAt(random.nextInt(numbers.length()));
//      }
//      return otp;
//   }
    private void txt_sotienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sotienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sotienActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(thanhtoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thanhtoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thanhtoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thanhtoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new thanhtoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_sotien;
    // End of variables declaration//GEN-END:variables

}

