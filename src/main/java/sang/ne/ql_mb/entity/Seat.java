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
public class Seat {
    private String seatID;    //rowNumber+columnCharacter
    private boolean status;

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public Seat(String seatID, boolean status) {
        this.seatID = seatID;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    

    

    public Seat() {
    }
}
