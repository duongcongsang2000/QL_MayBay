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
public class SanBay {
    private String maSanBay;
    private String tenSanBay;
    private String  tinhThanh;

   
    public SanBay() {
    }

    public SanBay(String maSanBay, String tenSanBay,String tinhThanh) {
        this.maSanBay = maSanBay;
        this.tenSanBay = tenSanBay;
    }
    
    public String getMaSanBay() {
        return maSanBay;
    }

    public void setMaSanBay(String maSanBay) {
        this.maSanBay = maSanBay;
    }

    public String getTenSanBay() {
        return tenSanBay;
    }

    public void setTenSanBay(String tenSanBay) {
        this.tenSanBay = tenSanBay;
    }
     public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }
}
