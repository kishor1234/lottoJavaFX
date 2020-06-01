/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.AdvanceDraw;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author asksoft
 */
public class AdvanceData {

    private String status;
    private String msg;
    //private Series data;
    private Map<String, String> pdata;
    private ArrayList<Map> data;
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

//    public Series getData() {
//        return data;
//    }
//
//    public void setData(Series data) {
//        this.data = data;
//    }
    public Map<String, String> getpdata() {
        return pdata;
    }

    public void setpdata(Map<String, String> pdata) {
        this.pdata = pdata;
    }
    public ArrayList<Map> getProperties()
    {
        return this.data;
    }
    public void setproperties(ArrayList<Map> properties)
    {
        this.data=properties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***** Employee Details *****\n");
        sb.append("Status=" + getStatus() + "\n");
        sb.append("Message=" + getMessage() + "\n");
       // sb.append("Data=" + getData() + "\n");
        sb.append("Properties=" + getProperties() + "\n");
        sb.append("*****************************");

        return sb.toString();
    }

}
