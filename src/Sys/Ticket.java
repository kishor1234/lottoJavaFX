/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys;

import javafx.scene.control.Button;

/**
 *
 * @author asksoft
 */
public class Ticket {

    String srno, utrno, amount, userid, date;
    Button action;

    public Ticket(String srno, String utrno, String amount, String userid, String date, Button action) {
        this.srno = srno;
        this.utrno = utrno;
        this.amount = amount;
        this.userid = userid;
        this.date = date;
        this.action = action;
    }

    public String getSrno() {
        return srno;
    }

    public void setSrno(String srno) {
        this.srno = srno;
    }

    public String getUtrno() {
        return utrno;
    }

    public void setUtrno(String utrno) {
        this.utrno = utrno;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }

}
