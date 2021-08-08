/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sang.ne.ql_mb.entity;

/**
 *
 * @author CCLaptop.com
 */
public class TuyenBay {
    private String maTuyenBay;
    private String sanBayDi;
    private String sanBayDen;
    private String maSanBay;
    private int chieudai;
    private int trangThai;

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getChieudai() {
        return chieudai;
    }

    public void setChieudai(int chieudai) {
        this.chieudai = chieudai;
    }

    public String getMaTuyenBay() {
        return maTuyenBay;
    }

    public void setMaTuyenBay(String maTuyenBay) {
        this.maTuyenBay = maTuyenBay;
    }

    public String getSanBayDi() {
        return sanBayDi;
    }

    public void setSanBayDi(String sanBayDi) {
        this.sanBayDi = sanBayDi;
    }

    public String getSanBayDen() {
        return sanBayDen;
    }

    public void setSanBayDen(String sanBayDen) {
        this.sanBayDen = sanBayDen;
    }

    public String getMaSanBay() {
        return maSanBay;
    }

    public void setMaSanBay(String maSanBay) {
        this.maSanBay = maSanBay;
    }

    public TuyenBay(String maTuyenBay, String sanBayDi, String sanBayDen, String maSanBay, int chieudai,int trangThai) {
        this.maTuyenBay = maTuyenBay;
        this.sanBayDi = sanBayDi;
        this.sanBayDen = sanBayDen;
        this.maSanBay = maSanBay;
        this.chieudai= chieudai;
        this.trangThai=trangThai;
    }

    public TuyenBay() {
    }
}
