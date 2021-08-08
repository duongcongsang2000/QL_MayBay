/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.entity;

import java.util.Date;

/**
 *
 * @author Yahiko
 */
public class HoaDon {
    private String MaHD;
    private Date NgayLap;
    private int ThanhTien;
    private String CMND;
    private int TrangThai;

    public HoaDon() {
    }
    
    public HoaDon(String MaHD, Date NgayLap, int ThanhTien, String CMND, int TrangThai) {
        this.MaHD = MaHD;
        this.NgayLap = NgayLap;
        this.ThanhTien = ThanhTien;
        this.CMND = CMND;
        this.TrangThai = TrangThai;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
