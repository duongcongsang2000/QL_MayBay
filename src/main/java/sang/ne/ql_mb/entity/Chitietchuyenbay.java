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
public class Chitietchuyenbay {
    private String maChiTiet;
    private String hangBay;
    private String soHieu;

    public Chitietchuyenbay() {
    }

    public Chitietchuyenbay(String maChiTiet, String hangBay, String soHieu) {
        this.maChiTiet = maChiTiet;
        this.hangBay = hangBay;
        this.soHieu = soHieu;
    }

    public String getMaChiTiet() {
        return maChiTiet;
    }

    public void setMaChiTiet(String maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public String getHangBay() {
        return hangBay;
    }

    public void setHangBay(String hangBay) {
        this.hangBay = hangBay;
    }

    public String getSoHieu() {
        return soHieu;
    }

    public void setSoHieu(String soHieu) {
        this.soHieu = soHieu;
    }
    
}
