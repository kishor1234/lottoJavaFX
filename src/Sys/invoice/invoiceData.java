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
public class invoiceData {

    private String status;
    private String msg;
    private ArrayList<Map> print;
    private ArrayList<Map> point;
    //private Series data;
    private Map<String, String> pdata;
    private ArrayList<Map> data;
    private print Print;
   

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

    public ArrayList<Map> getPrintData() {
        return print;
    }

    public void setPrintData(ArrayList<Map> print) {
        this.print = print;
    }
    
     public print getInvoice() {
        return this.Print;
    }

    public void setInvoice(print Print) {
        this.Print = Print;
    }
    
    

//    public Map<String, String> getpdata() {
//        return pdata;
//    }
//
//    public void setpdata(Map<String, String> pdata) {
//        this.pdata = pdata;
//    }
//
//    public ArrayList<Map> getProperties() {
//        return this.data;
//    }
//
//    public void setproperties(ArrayList<Map> properties) {
//        this.data = properties;
//    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("***** Employee Details *****\n");
        sb.append("Status=" + getStatus() + "\n");
        sb.append("Message=" + getMessage() + "\n");
        // sb.append("Data=" + getData() + "\n");
        sb.append("Print=" + getPrintData() + "\n");
        //print iv=getInvoice();
        sb.append("Own=" + getInvoice() + "\n");
        sb.append("*****************************");

        return sb.toString();
    }
}
