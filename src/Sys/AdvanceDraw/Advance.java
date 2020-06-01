/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.AdvanceDraw;

/**
 *
 * @author asksoft
 */
public class Advance {

    public String id;
    public String stime;
    public String etime;
    public String status;
    

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStime() {
        return this.stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }
     public String getEtime() {
        return this.etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }
     public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   

    @Override
    public String toString() {
        return getId()+""+getEtime();
    }
}
