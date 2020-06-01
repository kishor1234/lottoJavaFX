/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.invoice;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author asksoft
 */
public class print {

    public String own;
    public String totalpoint;
    public String amount;
    public String enterydate;
    public String gametime;
    public String gameendtime;
    public String gametimeid;
    public String game;
    public ArrayList<Map> point;

    public String getGame() {
        return this.game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getGameTimeid() {
        return this.gametimeid;
    }

    public void setGameTimeid(String gametimeid) {
        this.gametimeid = gametimeid;
    }

    public String getGameEndTime() {
        return this.gameendtime;
    }

    public void setGameEndTime(String gameendtime) {
        this.gameendtime = gameendtime;
    }

    public String getGameTime() {
        return this.gametime;
    }

    public void setGameTime(String gametime) {
        this.gametime = gametime;
    }

    public String getEnteryDate() {
        return this.enterydate;
    }

    public void setEnteryDate(String enterydate) {
        this.enterydate = enterydate;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOwn() {
        return this.own;
    }

    public void setOwn(String own) {
        this.own = own;
    }

    public String getTotalPoint() {
        return this.totalpoint;
    }

    public void setTotalPoint(String totalPoint) {
        this.totalpoint = totalPoint;
    }

    public ArrayList<Map> getPoint() {
        return this.point;
    }

    public void setPoint(ArrayList<Map> point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return getOwn() + ", " + getGame() + ", " + getTotalPoint();
    }
}
