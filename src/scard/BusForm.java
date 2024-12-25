/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowListener;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import db.TheBusDAO;
import java.math.BigInteger;

public class BusForm extends javax.swing.JFrame {

    private final static byte PIN_trylimit = (byte) 0x03; // So lan nhap pin m
    private int pinTryCounter = PIN_trylimit; // bien luu tru so lan nhap con lai
    private int serviceCount = 0;
    static info info;
    static theBus thebus;
    private Boolean input = false;
    private boolean cardready = false;
    private boolean connected = false;
    public byte[] rsaPubKey = new byte[128];
    public Color Azalea = new Color(251, 197, 197);
    private String Thexebus;
    private TheBusDAO theBusDAO;
    private String CardID = "";

    public BusForm() {
        info = new info();
        thebus = new theBus();
        theBusDAO = new TheBusDAO();
        initComponents();
    }

    //URL urlThexebus = BusForm.class.getResource("Thexebus.jpg");
    //Image img = Toolkit.getDefaultToolkit().createImage(Thexebus);
    //this.setIconImage(img);
    //hien thi apdu lenh len GUI
    public void setCommandAPDU(byte[] cmnds, byte lc, byte[] data, byte le) {
        txt_cla.setText(thebus.byteToHex(cmnds[0]));
        txt_ins.setText(thebus.byteToHex(cmnds[1]));
        txt_p1.setText(thebus.byteToHex(cmnds[2]));
        txt_p2.setText(thebus.byteToHex(cmnds[3]));
        txt_lc.setText(thebus.byteToHex(lc));
        //data
        String temp = "";
        for (int i = 0; i < data.length; i++) {
            temp += thebus.byteToHex(data[i]);
            temp += " ";
        }
        txt_cmd.setText(temp);
        txt_le.setText(thebus.byteToHex(le));
    }

    //hien thi apdu phan hoi len
    public void setResponseAPDU(byte[] datares, short le) {
        int status1 = thebus.resAPDU.getSW1();
        int status2 = thebus.resAPDU.getSW2();
        txt_sw1.setText(thebus.shorttoHex((short) status1));
        txt_sw2.setText(thebus.shorttoHex((short) status2));
        if (le != 0 && datares.length != 0) {
            //hien thi du lieu ra
            String temp = "";
            for (int i = 0; i < datares.length; i++) {
                temp += thebus.byteToHex(datares[i]);
                temp += " ";
            }
            txt_respon.setText(temp);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel_info = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        anhthe = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_sodu = new javax.swing.JLabel();
        txt_sothe = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JLabel();
        txt_ngaysinh = new javax.swing.JLabel();
        Btn_thayanh = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_pin = new javax.swing.JPasswordField();
        Btn_Xemtt = new javax.swing.JButton();
        btn_changePIN = new javax.swing.JButton();
        btn_capnhat = new javax.swing.JButton();
        btn_thanhtoan = new javax.swing.JButton();
        bnt_naptien = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_dichvu = new javax.swing.JLabel();
        Bg_BusForm2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        txt_cla = new javax.swing.JTextField();
        txt_ins = new javax.swing.JTextField();
        txt_p1 = new javax.swing.JTextField();
        txt_p2 = new javax.swing.JTextField();
        txt_lc = new javax.swing.JTextField();
        txt_le = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        txt_cmd = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        txt_sw1 = new javax.swing.JTextField();
        txt_sw2 = new javax.swing.JTextField();
        txt_respon = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_init = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        Button_Unblock = new javax.swing.JButton();
        Button_connect = new javax.swing.JButton();
        Button_Disconnect = new javax.swing.JButton();
        Bg_BusForm1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(getIconImages());
        setLocationByPlatform(true);

        jPanel_info.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_info.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("THẺ XE BUS");
        jPanel_info.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 144, 36));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("ID thẻ:");
        jPanel_info.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 50, 25));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Họ tên:");
        jPanel_info.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 51, 20));

        anhthe.setBackground(new java.awt.Color(0, 0, 0));
        anhthe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_info.add(anhthe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 130, 180));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Số lần sử dụng dịch vụ:");
        jPanel_info.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));
        jPanel_info.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_sodu.setText("0");
        jPanel_info.add(txt_sodu, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 50, -1));
        jPanel_info.add(txt_sothe, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 170, 22));
        jPanel_info.add(txt_hoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 170, 22));
        jPanel_info.add(txt_ngaysinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 170, 20));

        Btn_thayanh.setBackground(new java.awt.Color(153, 255, 204));
        Btn_thayanh.setText("Thay ảnh");
        Btn_thayanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_thayanhActionPerformed(evt);
            }
        });
        jPanel_info.add(Btn_thayanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 80, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Ngày sinh:");
        jPanel_info.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, 20));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nhập mã PIN:");
        jPanel_info.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        txt_pin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pinActionPerformed(evt);
            }
        });
        jPanel_info.add(txt_pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 140, 30));

        Btn_Xemtt.setBackground(new java.awt.Color(153, 255, 204));
        Btn_Xemtt.setText("Enter");
        Btn_Xemtt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_XemttActionPerformed(evt);
            }
        });
        jPanel_info.add(Btn_Xemtt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 70, 32));

        btn_changePIN.setForeground(new java.awt.Color(15, 14, 14));
        btn_changePIN.setText("Thay đổi mã PIN");
        btn_changePIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changePINActionPerformed(evt);
            }
        });
        jPanel_info.add(btn_changePIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 160, 30));

        btn_capnhat.setForeground(new java.awt.Color(15, 14, 14));
        btn_capnhat.setText("Đổi thông tin");
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });
        jPanel_info.add(btn_capnhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 160, 30));

        btn_thanhtoan.setForeground(new java.awt.Color(15, 14, 14));
        btn_thanhtoan.setText("Thanh toán");
        btn_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhtoanActionPerformed(evt);
            }
        });
        jPanel_info.add(btn_thanhtoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 160, 30));

        bnt_naptien.setForeground(new java.awt.Color(15, 14, 14));
        bnt_naptien.setText("Nạp tiền");
        bnt_naptien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_naptienActionPerformed(evt);
            }
        });
        jPanel_info.add(bnt_naptien, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 160, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Số dư:");
        jPanel_info.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, -1));

        txt_dichvu.setText("0");
        jPanel_info.add(txt_dichvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 50, -1));

        Bg_BusForm2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Thexebus.jpg"))); // NOI18N
        jPanel_info.add(Bg_BusForm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 480, 550));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel68.setText("APDU Lệnh");
        jPanel11.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 12, 97, 28));

        jLabel69.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel69.setText("CLA");
        jLabel69.setToolTipText("");
        jPanel11.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 46, 60, 39));

        jLabel70.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel70.setText("INS");
        jPanel11.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 46, 59, 39));

        jLabel71.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel71.setText("P1");
        jPanel11.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 46, 59, 38));

        jLabel72.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel72.setText("P2");
        jPanel11.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 46, 59, 39));

        jLabel73.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel73.setText("LC");
        jPanel11.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 46, 60, 39));

        jLabel74.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel74.setText("LE");
        jPanel11.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 46, 60, 38));

        txt_cla.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jPanel11.add(txt_cla, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 91, 60, 39));

        txt_ins.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jPanel11.add(txt_ins, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 91, 59, 39));

        txt_p1.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jPanel11.add(txt_p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 91, 59, 38));

        txt_p2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        txt_p2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_p2ActionPerformed(evt);
            }
        });
        jPanel11.add(txt_p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 91, 59, 39));

        txt_lc.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jPanel11.add(txt_lc, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 91, 60, 39));

        txt_le.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jPanel11.add(txt_le, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 91, 60, 38));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel75.setText("Dữ liệu:");
        jPanel11.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 141, 41, 39));
        jPanel11.add(txt_cmd, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 141, 431, 39));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel76.setText("SW1");
        jPanel11.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 180, 48, 30));

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel77.setText("SW2");
        jPanel11.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 180, 48, 30));
        jPanel11.add(txt_sw1, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 216, 48, 39));
        jPanel11.add(txt_sw2, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 217, 48, 38));

        txt_respon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_responActionPerformed(evt);
            }
        });
        jPanel11.add(txt_respon, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 265, 429, 39));

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel78.setText("APDU phản hồi");
        jPanel11.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 197, 120, 30));

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel79.setText("Dữ liệu:");
        jPanel11.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 265, 49, 39));

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_init.setForeground(new java.awt.Color(2, 0, 0));
        btn_init.setText("Khởi tạo thẻ");
        btn_init.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_initActionPerformed(evt);
            }
        });
        jPanel5.add(btn_init, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 100, 30));

        btn_clear.setForeground(new java.awt.Color(15, 14, 14));
        btn_clear.setText("Xóa thẻ");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel5.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 100, 30));

        Button_Unblock.setForeground(new java.awt.Color(15, 14, 14));
        Button_Unblock.setText("Mở khóa thẻ");
        Button_Unblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_UnblockActionPerformed(evt);
            }
        });
        jPanel5.add(Button_Unblock, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 100, 30));

        Button_connect.setForeground(new java.awt.Color(15, 14, 14));
        Button_connect.setText("Kết nối");
        Button_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_connectActionPerformed(evt);
            }
        });
        jPanel5.add(Button_connect, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 100, 30));

        Button_Disconnect.setForeground(new java.awt.Color(15, 14, 14));
        Button_Disconnect.setText("Ngắt kết nối");
        Button_Disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_DisconnectActionPerformed(evt);
            }
        });
        jPanel5.add(Button_Disconnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 100, 32));

        Bg_BusForm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/xebus.jpg"))); // NOI18N
        jPanel5.add(Bg_BusForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel_info, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_DisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_DisconnectActionPerformed
        if (thebus.disconnectApplet() == true) {
            txt_sothe.setText("");
            txt_hoten.setText("");
            txt_ngaysinh.setText("");
            txt_pin.setText("");
            txt_sodu.setText("");
            txt_dichvu.setText("");
            anhthe.setIcon(null);
            Button_connect.setText("Kết nối");
            Button_connect.setBackground(Azalea);
            Button_Disconnect.setText("Đã ngắt kết nối");
            Button_Disconnect.setBackground(Color.red);
            txt_respon.setText("");
            txt_sw1.setText("");
            txt_sw2.setText("");
            txt_cmd.setText("");
            txt_cla.setText("");
            txt_ins.setText("");
            txt_p1.setText("");
            txt_p2.setText("");
            txt_lc.setText("");
            txt_le.setText("");
            connected = false;
            cardready = false;
        } else
            JOptionPane.showMessageDialog(this, "Ngắt kết nối không thành công.");
    }//GEN-LAST:event_Button_DisconnectActionPerformed

    private void Button_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_connectActionPerformed
        if (thebus.connectApplet() == true) {//thiet lap ket noi
            byte[] cmd = {(byte) 0x00, (byte) 0xA4, (byte) 0x04, (byte) 0x00};// select
            //mang data gui di la RID,PIX
            byte[] data = {(byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x00};
            byte lc = 6;
            byte le_expect = 2;
            setCommandAPDU(cmd, lc, data, le_expect);//hien thi apdu cmd
            thebus.sendAPDUtoApplet(cmd, data);
            byte[] dataRes = thebus.resAPDU.getData();
            int le = thebus.resAPDU.getNr();
            setResponseAPDU(dataRes, (short) le);//hien thi du lieu phan hoi tu applet
            Button_connect.setText("Đã kết nối");
            Button_connect.setBackground(Color.green);
            Button_Disconnect.setText("Ngắt kết nối");
            Button_Disconnect.setBackground(Color.red);
            connected = true;
        } else
            JOptionPane.showMessageDialog(this, "Kết nối không thành công. Hãy thử lại.");
    }//GEN-LAST:event_Button_connectActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        if (connected == true) {
            if (input == false) {
                JOptionPane.showMessageDialog(null, "Thẻ chưa có dữ liệu.");
            } else {
                byte[] cmd = {(byte) 0xA0, (byte) 0x18, (byte) 0x00, (byte) 0x00};
                byte[] data = {0};
                setCommandAPDU(cmd, (byte) 0, data, (byte) 0);//hien thi apdu cmd len GUI
                thebus.sendAPDUtoApplet(cmd);
                byte[] dataRes = thebus.resAPDU.getData();
                int le = thebus.resAPDU.getNr();
                setResponseAPDU(dataRes, (short) le);//hien thi du lieu phan hoi tu applet
                theBusDAO.deleteByID(CardID);
                txt_sothe.setText("");
                txt_hoten.setText("");
                txt_ngaysinh.setText("");
                txt_pin.setText("");
                txt_sodu.setText("");
                txt_dichvu.setText("");
                JOptionPane.showMessageDialog(null, "Thẻ đã xóa dữ liệu.");
                input = false;
            }

        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_initActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_initActionPerformed
        if (connected == true) {
            if (input == false) {
                Formnhap initform = new Formnhap(this);
                initform.setVisible(true);
                initform.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } else {
                JOptionPane.showMessageDialog(null, "Thẻ đã có dữ liệu");
            }
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_btn_initActionPerformed

    private void txt_responActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_responActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_responActionPerformed

    private void txt_p2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_p2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_p2ActionPerformed

    private void Button_UnblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_UnblockActionPerformed
        if (connected == true) {
            pinTryCounter = PIN_trylimit; // Reset số lần  khi mo khoa thành công
            byte[] cmd = {(byte) 0xA0, (byte) 0x20, (byte) 0x00, (byte) 0x00};
            byte[] data = {0};
            setCommandAPDU(cmd, (byte) 0, data, (byte) 0);//hien thi apdu cmd len GUI
            thebus.sendAPDUtoApplet(cmd);
            byte[] dataRes = thebus.resAPDU.getData();
            int le = thebus.resAPDU.getNr();
            setResponseAPDU(dataRes, (short) le);//hien thi du lieu phan hoi tu applet
            JOptionPane.showMessageDialog(null, "Thẻ đã được mở khóa.");
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_Button_UnblockActionPerformed

    private void bnt_naptienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_naptienActionPerformed
        if (connected == true && cardready == true) {
            Naptien naptien = new Naptien();
            naptien.setVisible(true);
            naptien.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_bnt_naptienActionPerformed

    private void Btn_XemttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_XemttActionPerformed
        if (input == false) {
            JOptionPane.showMessageDialog(null, "Thẻ không có dữ liệu.");
        } else {
            if (connected == true) {
                String pin = Arrays.toString(txt_pin.getPassword());
                switch (check_pin(pin)) {
                    case 0:
                        // Mã PIN sai
                        pinTryCounter--; // Giam so lần nhập còn lại
                        if (pinTryCounter > 0) {
                            JOptionPane.showMessageDialog(null,
                                    "Mã PIN sai. Bạn còn " + pinTryCounter + " lần nhập.");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Bạn đã nhập sai quá số lần cho phép. Thẻ đã bị khóa!");
                        }
                        break;
                    case 1:
                        // Mã PIN đúng
                        JOptionPane.showMessageDialog(null, "Connect thẻ thành công.");
                        cardready = true;
                        pinTryCounter = PIN_trylimit; // Reset số lần nhập PIN khi thành công
                        getImage(info.getAvatar());
                        byte[] cmd = {(byte) 0xA0, (byte) 0x11, (byte) 0x00, (byte) 0x00};
                        byte[] data = {0};
                        setCommandAPDU(cmd, (byte) 0, data, (byte) 0); // Hiển thị APDU cmd lên GUI
                        thebus.sendAPDUtoApplet(cmd);
                        byte[] dataRes = thebus.resAPDU.getData();
                        int le = thebus.resAPDU.getNr();
                        setResponseAPDU(dataRes, (byte) le); // Hiển thị dữ liệu phản hồi từ applet
                        String tach = new String(dataRes);
                        String[] a = tach.split(":");
                        String st = a[0];
                        String ht = a[1];
                        String ns = a[2];
                        txt_sothe.setText(st);
                        txt_hoten.setText(ht);
                        txt_ngaysinh.setText(ns);
                        byte[] cmd1 = {(byte) 0xA0, (byte) 0x21, (byte) 0x00, (byte) 0x00};
                        thebus.sendAPDUtoApplet(cmd1);
                        byte[] b = thebus.resAPDU.getData();
                        String sodu = "";
                        for (int i = 0; i < b.length; i++) {
                            sodu += thebus.byteToHex(b[i]);
                        }
                        int sd = Integer.valueOf(sodu, 16).intValue() * 1000;
                        txt_sodu.setText("" + sd);
                        byte[] cmd2 = {(byte) 0xA0, (byte) 0x23, (byte) 0x00, (byte) 0x00};
                        thebus.sendAPDUtoApplet(cmd2);
                        byte[] c = thebus.resAPDU.getData();
                        String dichvu = "";
                        for (int i = 0; i < c.length; i++) {
                            dichvu += thebus.byteToHex(c[i]);
                        }
                        int dv = Integer.valueOf(dichvu, 16).intValue();
                        txt_dichvu.setText("" + dv);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,
                                "Bạn đã nhập sai quá số lần cho phép. Thẻ đã bị khóa!");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
            }
        }

    }//GEN-LAST:event_Btn_XemttActionPerformed

    private void txt_pinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pinActionPerformed

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        if (connected == true && cardready == true) {
            updateInfoForm updateinfo = new updateInfoForm(txt_sothe.getText(), txt_hoten.getText(), txt_ngaysinh.getText());
            updateinfo.setVisible(true);
            updateinfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_btn_capnhatActionPerformed

    private void btn_changePINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changePINActionPerformed
        if (connected == true && cardready == true) {
            updatePIN updatepin = new updatePIN();
            updatepin.setVisible(true);
            updatepin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_btn_changePINActionPerformed

    private void Btn_thayanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_thayanhActionPerformed
        if (connected == true && cardready == true) {
            JFileChooser fc = new JFileChooser();
            int returnValue = fc.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                BufferedImage bimage;
                try {
                    bimage = ImageIO.read(file);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(bimage, "jpg", baos);
                    byte[] img = baos.toByteArray();
                    setImage(img);
                    getImage(img);
                    info.setAvatar(img);
                    JOptionPane.showMessageDialog(this, "Thay ảnh thành công.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ.");
    }//GEN-LAST:event_Btn_thayanhActionPerformed

    private void btn_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhtoanActionPerformed
        if (connected == true && cardready == true) {
            thanhtoan pay = new thanhtoan();
            pay.setParent(this);
            pay.setVisible(true);
            pay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
    }//GEN-LAST:event_btn_thanhtoanActionPerformed

    //public void updateServiceCount() {
    //    int currentCount = Integer.parseInt(txt_dichvu.getText());
    //    currentCount++; // Tăng số lần sử dụng dịch vụ
    //    txt_dichvu.setText(String.valueOf(currentCount));
    //}
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
            java.util.logging.Logger.getLogger(BusForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusForm().setVisible(true);
            }

        });
    }

    public void sendData() {
        if (connected == true) {
            if (!input) {
                setImage(info.getAvatar());
                getImage(info.getAvatar());
                // Chuyển dữ liệu xuống applet
                String sothe = info.getSothe();
                String hoten = info.getHoten();
                String ngaysinh = info.getNgaysinh();
                String pin = info.getPin();
                String arraysend = sothe.concat(".").concat(hoten).concat(".").concat(ngaysinh).concat(".").concat(pin);
                System.out.println("send:" + arraysend);
                int lc = arraysend.length();
                byte datalen = (byte) lc; // Độ dài dữ liệu gửi vào applet
                byte[] cmd = {(byte) 0xA0, (byte) 0x10, (byte) 0x00, (byte) 0x00};
                byte[] data = arraysend.getBytes();
                setCommandAPDU(cmd, (byte) lc, data, (byte) 0);
                thebus.sendAPDUtoApplet(cmd, data);
                byte[] dataRes = thebus.resAPDU.getData();
                int le = thebus.resAPDU.getNr();
                setResponseAPDU(dataRes, (byte) le); // Hiển thị dữ liệu phản hồi từ applet
                String tach = new String(dataRes);
                System.out.print(" response from applet >>>:" + tach);
                String[] a = tach.split(":");
                String st = a[0];
                String ht = a[1];
                String ns = a[2];
                CardID = st;

                byte[] cmd1 = {(byte) 0xA0, (byte) 0x21, (byte) 0x00, (byte) 0x00};
                thebus.sendAPDUtoApplet(cmd1);
                byte[] b = thebus.resAPDU.getData();
                String sodu = "";
                for (int i = 0; i < b.length; i++) {
                    sodu += thebus.byteToHex(b[i]);
                }
                byte[] cmd2 = {(byte) 0xA0, (byte) 0x23, (byte) 0x00, (byte) 0x00};
                thebus.sendAPDUtoApplet(cmd2);
                byte[] c = thebus.resAPDU.getData();
                String dichvu = "";
                for (int i = 0; i < c.length; i++) {
                    dichvu += thebus.byteToHex(c[i]);
                }
                BigInteger modulus = thebus.getModulusPubkey(); // Lấy modulus
                BigInteger exponent = thebus.getExponentPubkey();
                if (modulus != null && exponent != null) {
                    String modulusHex = modulus.toString(16).toUpperCase();
                    String exponentHex = exponent.toString(16).toUpperCase();

                    String publicKeyString = modulusHex + exponentHex;
                    theBusDAO.addToDB(st, publicKeyString);
                }
                input = true;
            } else {
                JOptionPane.showMessageDialog(null, "Thẻ đã có dữ liệu.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chưa connect thẻ");
        }
    }

    private void setImage(byte[] img) {
        if (img == null) {
            return;
        }
        byte[] cmd = {(byte) 0xA0, (byte) 0x12, (byte) 0x01, (byte) 0x00};
        thebus.sendAPDUtoApplet(cmd);
        int sendlen = img.length;
        System.out.println("ảnh gửi:" + img);
        byte[] cmnd = {(byte) 0xA0, (byte) 0x12, (byte) 0x02, (byte) 0x00};
        int pointer = 0;
        byte[] temp = new byte[255];
        int datalen = 255;
        while (sendlen > 0) {
            System.arraycopy(img, pointer, temp, 0, datalen);
            thebus.sendAPDUtoApplet(cmnd, temp);
            pointer += 255;
            sendlen -= 255;
            if (sendlen < 255) {
                datalen = sendlen;
            }
        }
    }

    private void getImage(byte[] img) {
        if (img == null) {
            return;
        }
        try {
            byte[] cmd = {(byte) 0xA0, (byte) 0x13, (byte) 0x01, (byte) 0x00};
            thebus.sendAPDUtoApplet(cmd);
            int sendlen = img.length;
            byte[] cmnd = {(byte) 0xA0, (byte) 0x13, (byte) 0x02, (byte) 0x00};
            byte[] resimg = new byte[sendlen];
            int pointer = 0;
            int datalen = 255;
            while (sendlen > 0) {
                thebus.sendAPDUtoApplet(cmnd);
                byte[] temp = thebus.resAPDU.getData();
                System.arraycopy(temp, 0, resimg, pointer, datalen);
                pointer += 255;
                sendlen -= 255;
                if (sendlen < 255) {
                    datalen = sendlen;
                }
            }
            System.out.println("ảnh res:" + resimg);
            ByteArrayInputStream bais = new ByteArrayInputStream(resimg);
            BufferedImage b;
            b = ImageIO.read(bais);
            ImageIcon icon = new ImageIcon(b.getScaledInstance(anhthe.getWidth(), anhthe.getHeight(), Image.SCALE_SMOOTH));
            icon.getImage();
            anhthe.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(BusForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//        try{
//            b = ImageIO.read(bais);
//            ImageIcon icon= new ImageIcon(b);
//            icon.getImage();
//            anhthe.setIcon(icon);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    public int check_pin(String pin) {
        short lc = (short) pin.length(); //do dai du lieu gui vao applet
        short le = 1;//du lieu nhan mong doi (Le)
        byte[] cmd = {(byte) 0xA0, (byte) 0x19, (byte) 0x00, (byte) 0x00};
        byte[] data = pin.getBytes();
        setCommandAPDU(cmd, (byte) lc, data, (byte) le);
        thebus.sendAPDUtoApplet(cmd, data);
        byte[] dataRes = thebus.resAPDU.getData();
        int lenRes = thebus.resAPDU.getNr();
        setResponseAPDU(dataRes, (byte) lenRes);
        //String a = new String(dataRes);
        if (dataRes[0] == (byte) 0x01) {//đúng mã PIN
            return 1;
        } else if (dataRes[0] == (byte) 0x00) {
            return 0;
        } else {
            return 2;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bg_BusForm1;
    private javax.swing.JLabel Bg_BusForm2;
    private javax.swing.JButton Btn_Xemtt;
    private javax.swing.JButton Btn_thayanh;
    private javax.swing.JButton Button_Disconnect;
    private javax.swing.JButton Button_Unblock;
    private javax.swing.JButton Button_connect;
    private javax.swing.JLabel anhthe;
    private javax.swing.JButton bnt_naptien;
    private javax.swing.JButton btn_capnhat;
    private javax.swing.JButton btn_changePIN;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_init;
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel_info;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txt_cla;
    private javax.swing.JTextField txt_cmd;
    private javax.swing.JLabel txt_dichvu;
    private javax.swing.JLabel txt_hoten;
    private javax.swing.JTextField txt_ins;
    private javax.swing.JTextField txt_lc;
    private javax.swing.JTextField txt_le;
    private javax.swing.JLabel txt_ngaysinh;
    private javax.swing.JTextField txt_p1;
    private javax.swing.JTextField txt_p2;
    private javax.swing.JPasswordField txt_pin;
    private javax.swing.JTextField txt_respon;
    private javax.swing.JLabel txt_sodu;
    private javax.swing.JLabel txt_sothe;
    private javax.swing.JTextField txt_sw1;
    private javax.swing.JTextField txt_sw2;
    // End of variables declaration//GEN-END:variables
}
