package scard;

public class info {
    private String sothe, hoten, ngaysinh, pin;
    private byte[] avatar;
    public info(String sothe, String hoten, String ngaysinh,String pin,byte[] avatar) {
        this.sothe = sothe;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.pin = pin;
        this.avatar= avatar;
    }
    public info(){
        
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getSothe() {
        return sothe;
    }

    public void setSothe(String sothe) {
        this.sothe = sothe;
    }
    
    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
