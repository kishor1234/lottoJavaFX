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

    String srno, ticket, amount, drawid, drawtime, date;
    Button action;
    
    public Ticket(String srno,String ticket,String amount,String drawid,String drawtime,String date,Button action)
    {
        this.srno=srno;
        this.ticket=ticket;
        this.amount=amount;
        this.drawid=drawid;
        this.drawtime=drawtime;
        this.date=date;
        this.action=action;
    }

    public String getSrno() {
        return srno;
    }

    public void setSrno(String srno) {
        this.srno = srno;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDrawid() {
        return drawid;
    }

    public void setDrawid(String drawid) {
        this.drawid = drawid;
    }

    public String getDrawtime() {
        return drawtime;
    }

    public void setDrawtime(String drawtime) {
        this.drawtime = drawtime;
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
