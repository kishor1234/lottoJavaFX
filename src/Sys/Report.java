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
public class Report {

    String srno, userid, game, ticketno, drawid, netPoint, discountPer, discountPoint, finalPoint, winPoint, netPayable, date;

    public Report(String srno, String userid, String game, String ticketno, String drawid, String netPoint, String discountPer, String discountPoint, String finalPoint, String winPoint, String netPayable, String date) {
        this.srno = srno;
        this.userid = userid;
        this.game = game;
        this.ticketno = ticketno;
        this.drawid = drawid;
        this.netPoint = netPoint;
        this.discountPer = discountPer;
        this.discountPoint = discountPoint;
        this.finalPoint = finalPoint;
        this.winPoint = winPoint;
        this.netPayable = netPayable;
        this.date = date;
    }

    public String getSrno() {
        return srno;
    }

    public void setSrno(String srno) {
        this.srno = srno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno;
    }

    public String getDrawid() {
        return drawid;
    }

    public void setDrawid(String drawid) {
        this.drawid = drawid;
    }

    public String getNetPoint() {
        return netPoint;
    }

    public void setNetPoint(String netPoint) {
        this.netPoint = netPoint;
    }

    public String getDiscountPer() {
        return discountPer;
    }

    public void setDiscountPer(String discountPer) {
        this.discountPer = discountPer;
    }

    public String getDiscountPoint() {
        return discountPoint;
    }

    public void setDiscountPoint(String discountPoint) {
        this.discountPoint = discountPoint;
    }

    public String getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(String finalPoint) {
        this.finalPoint = finalPoint;
    }

    public String getWinPoint() {
        return winPoint;
    }

    public void setWinPoint(String winPoint) {
        this.winPoint = winPoint;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNetPayable() {
        return netPayable;
    }

    public void setNetPayable(String netPayable) {
        this.netPayable = netPayable;
    }

}
