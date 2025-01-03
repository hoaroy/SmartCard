package scard;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Formnhap extends javax.swing.JFrame {
    private info info;
    private BusForm busForm; // Tham chiếu đến BusForm

    private static int counter = 100023; // Bộ đếm bắt đầu từ 100023
    
    public Formnhap(BusForm busForm) {
        info = new info();
        this.busForm = busForm; // Gán tham chiếu
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_ns = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        btn_ok = new javax.swing.JButton();
        sd = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_pin = new javax.swing.JPasswordField();
        txt_checkpin = new javax.swing.JPasswordField();
        anh = new javax.swing.JLabel();
        Button_getava = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        txt_ns.setDateFormatString("dd/MM/yyyy");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Họ tên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Ngày sinh:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        btn_ok.setBackground(new java.awt.Color(204, 204, 204));
        btn_ok.setText("Lưu");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
                btn_senddataActionPerformed(evt);
            }
        });

        sd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sd.setText("Mã PIN:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nhập lại mã PIN:");

        txt_checkpin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_checkpinActionPerformed(evt);
            }
        });

        anh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Button_getava.setBackground(new java.awt.Color(204, 204, 204));
        Button_getava.setText("Chọn ảnh");
        Button_getava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_getavaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Thông tin thẻ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Button_getava, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(anh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(sd)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_checkpin, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pin, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ns, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(anh, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_getava))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ns, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel3)))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sd)
                                    .addComponent(txt_pin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_checkpin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btn_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
String pin = Arrays.toString(txt_pin.getPassword());
    String checkpin = Arrays.toString(txt_checkpin.getPassword());
    if( txt_hoten.getText().equals("") || txt_ns.getDate().equals("")|| txt_pin.getPassword().equals("")|| txt_checkpin.getPassword().equals("")){
        JOptionPane.showMessageDialog(this, "Tất cả các trường không được để trống!");
    } else if (pin.length() < 18 || pin.length() > 44) {
        JOptionPane.showMessageDialog(this, "độ dài PIN từ 6-32 ký tự.");
    } else if (!pin.equals(checkpin)) {
        JOptionPane.showMessageDialog(this, "Xác nhận mã pin sai");
    } else if (txt_ns.getDate().after(new java.util.Date())){
        JOptionPane.showMessageDialog(this, "Ngày sinh không thể là ngày trong tương lai!");
    }else {
        // Sinh mã số thẻ theo logic "CT" + số thứ tự
        String sothe = "CT" + counter;
        counter++; // Tăng bộ đếm
        
        String hoten = txt_hoten.getText();
        
        // Định dạng ngày sinh từ JDateChooser
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String ngaysinh = sdf.format(txt_ns.getDate());
        
        // Gán thông tin vào đối tượng info
        info.setSothe(sothe);
        info.setHoten(hoten);
        info.setNgaysinh(ngaysinh);
        info.setPin(pin);
        // Gán đối tượng info của BusForm
        busForm.info = this.info;

        // Gọi phương thức sendData từ BusForm
        busForm.sendData();
        JOptionPane.showMessageDialog(null, "Khởi tạo nội dung thẻ thành công.");
        
       
        // Xóa nội dung các trường
        txt_hoten.setText("");
        txt_ns.setDate(null);
        txt_pin.setText("");
        txt_checkpin.setText("");
        setVisible(false);
        
    }
    }//GEN-LAST:event_btn_okActionPerformed

    private void Button_getavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_getavaActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnValue = fc.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile(); //lay tep
            String path = file.getAbsolutePath(); //lay duong dan cua tep
            BufferedImage bimage;
            try{
                bimage = ImageIO.read(file); //doc tep
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bimage, "jpg", baos);
                byte[] img = baos.toByteArray(); // luu vao info
                //thay doi kich thuoc anh
                ImageIcon icon= new ImageIcon(bimage.getScaledInstance(anh.getWidth(), anh.getHeight(), Image.SCALE_SMOOTH));
                icon.getImage();
                anh.setIcon(icon);
                info.setAvatar(img);
                //System.out.println("ime:"+img);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_Button_getavaActionPerformed

    private void txt_checkpinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_checkpinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_checkpinActionPerformed

    private void btn_senddataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_senddataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_senddataActionPerformed
 

    
//    private void set_anh(){
//        JFileChooser jc = new JFileChooser();
//        jc.showOpenDialog(null);
//        File f = jc.getSelectedFile();
//        ImageIcon icon= new ImageIcon();
//        Image im= icon.getImage().getScaledInstance(anh.getWidth(), anh.getHeight(),Image.SCALE_SMOOTH);
//        anh.setIcon(icon);
//    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_getava;
    private javax.swing.JLabel anh;
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel sd;
    private javax.swing.JPasswordField txt_checkpin;
    private javax.swing.JTextField txt_hoten;
    private com.toedter.calendar.JDateChooser txt_ns;
    private javax.swing.JPasswordField txt_pin;
    // End of variables declaration//GEN-END:variables
}
