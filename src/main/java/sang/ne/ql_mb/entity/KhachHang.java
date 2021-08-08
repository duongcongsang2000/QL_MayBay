/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.entity;

/**
 *
 * @author Yahiko
 */
public class KhachHang {
    private String CMND;
    private String TENKH;
    private String SDT;
    private String Username;
    private String Password;
    private int TrangThai;
    private int Vaitro;
    private int GIOITINH;
    private String Email;
    public KhachHang() {
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getTENKH() {
        return TENKH;
    }

    public void setTENKH(String TENKH) {
        this.TENKH = TENKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getVaitro() {
        return Vaitro;
    }

    public void setVaitro(int Vaitro) {
        this.Vaitro = Vaitro;
    }

    public int getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(int GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public KhachHang(String CMND, String TENKH, String SDT, String Username, String Password, int TrangThai, int Vaitro, int GIOITINH, String Email) {
        this.CMND = CMND;
        this.TENKH = TENKH;
        this.SDT = SDT;
        this.Username = Username;
        this.Password = Password;
        this.TrangThai = TrangThai;
        this.Vaitro = Vaitro;
        this.GIOITINH = GIOITINH;
        this.Email = Email;
    }

    
}
