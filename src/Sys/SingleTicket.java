/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys;

/**
 *
 * @author asksoft
 */
public class SingleTicket {

    String srno, drDate, drTime, name, mrp, digit, qty;

    public SingleTicket(String srno, String drDate, String drTime, String name, String mrp, String digit, String qty) {
        this.srno=srno;
        this.drDate=drDate;
        this.drTime=drTime;
        this.name=name;
        this.mrp=mrp;
        this.digit=digit;
        this.qty=qty;
    }

    public String getSrno() {
        return srno;
    }

    public void setSrno(String srno) {
        this.srno = srno;
    }

    public String getDrDate() {
        return drDate;
    }

    public void setDrDate(String drDate) {
        this.drDate = drDate;
    }

    public String getDrTime() {
        return drTime;
    }

    public void setDrTime(String drTime) {
        this.drTime = drTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getDigit() {
        return digit;
    }

    public void setDigit(String digit) {
        this.digit = digit;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

}
