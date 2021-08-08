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
public class ChuyenBay {
      private String maChuyenBay;
    private Date ngayGio;
    private String thoiGianBay;
    private int soGheTrong;
    private String   maTuyenBay;
    private String maChiTietChuyenBay;
    private int trangThai;

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    

    public ChuyenBay(String maChuyenBay, Date ngayGio, String thoiGianBay, int soGheTrong, String maTuyenBay, String maChiTietChuyenBay,int trangThai) {
        this.maChuyenBay = maChuyenBay;
        this.ngayGio = ngayGio;
        this.thoiGianBay = thoiGianBay;
        this.soGheTrong = soGheTrong;
        this.maTuyenBay = maTuyenBay;
        this.maChiTietChuyenBay = maChiTietChuyenBay;
        this.trangThai=trangThai;
    }
     public ChuyenBay() {
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public Date getNgayGio() {
        return ngayGio;
    }

    public void setNgayGio(Date ngayGio) {
        this.ngayGio = ngayGio;
    }

    public String getThoiGianBay() {
        return thoiGianBay;
    }

    public void setThoiGianBay(String thoiGianBay) {
        this.thoiGianBay = thoiGianBay;
    }

    public int getSoGheTrong() {
        return soGheTrong;
    }

    public void setSoGheTrong(int soGheTrong) {
        this.soGheTrong = soGheTrong;
    }

    public String getMaTuyenBay() {
        return maTuyenBay;
    }

    public void setMaTuyenBay(String maTuyenBay) {
        this.maTuyenBay = maTuyenBay;
    }

    public String getMaChiTietChuyenBay() {
        return maChiTietChuyenBay;
    }

    public void setMaChiTietChuyenBay(String maChiTietChuyenBay) {
        this.maChiTietChuyenBay = maChiTietChuyenBay;
    }
}
