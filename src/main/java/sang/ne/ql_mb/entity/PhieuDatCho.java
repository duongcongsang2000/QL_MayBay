/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.entity;

import java.util.Date;

/**
 *
 * @author CCLaptop.com
 */
public class PhieuDatCho {
    private String MaPhieu;
    private Date NgayDat;
    private String SoGhe;
    private String CMND;
    private String MaHangVe;
    private String MaChuyenBay;
    private int TongTien;
    private int Thue;

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public int getThue() {
        return Thue;
    }

    public void setThue(int Thue) {
        this.Thue = Thue;
    }

    public PhieuDatCho(String MaPhieu, Date NgayDat, String SoGhe, String CMND, String MaHangVe, String MaChuyenBay, int TongTien, int Thue) {
        this.MaPhieu = MaPhieu;
        this.NgayDat = NgayDat;
        this.SoGhe = SoGhe;
        this.CMND = CMND;
        this.MaHangVe = MaHangVe;
        this.MaChuyenBay = MaChuyenBay;
        this.TongTien = TongTien;
        this.Thue = Thue;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public Date getNgayDat() {
        return NgayDat;
    }

    public void setNgayDat(Date NgayDat) {
        this.NgayDat = NgayDat;
    }

    public String getSoGhe() {
        return SoGhe;
    }

    public void setSoGhe(String SoGhe) {
        this.SoGhe = SoGhe;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getMaHangVe() {
        return MaHangVe;
    }

    public void setMaHangVe(String MaHangVe) {
        this.MaHangVe = MaHangVe;
    }

    public String getMaChuyenBay() {
        return MaChuyenBay;
    }

    public void setMaChuyenBay(String MaChuyenBay) {
        this.MaChuyenBay = MaChuyenBay;
    }

    public PhieuDatCho() {
    }
}
