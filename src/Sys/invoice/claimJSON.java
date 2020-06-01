/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.invoice;

import controller.DashboardController;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author asksoft
 */
public class claimJSON {

    public static String claimJSONPrint(String data,String printer) throws Exception {
        // parsing file "JSONExample.json" 
        Object obj = new JSONParser().parse(data);
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj;
        String printPage = "";
        // getting firstName and lastName 
        String status = (String) jo.get("status");
        String Msg = (String) jo.get("message");
        //System.out.println(jo.get("winPoint"));
        //System.exit(0);
        if (status.equals("1")) {
            Map<String, String> wPoint = (Map<String, String>) jo.get("winPoint");
            printPage += "Rajashreee Lottery\n";
            printPage += "Wining Point's\n";
            printPage += "Wining Ticke id : " + (String) jo.get("id");
            printPage += "  Draw id : " + (String) jo.get("drawid") + "\n";
            printPage += "Date: " + (String) jo.get("date") + "\n\n";
            printPage += "Num    qty    Num    qty    Num    qty    \n";
            int k = 1;
            int sum = 0;
            for (Map.Entry<String, String> finas : wPoint.entrySet()) {
                if (k == 3) {
                    printPage += "" + finas.getKey() + "\t" + finas.getValue() + "\n";
                    k = 0;
                } else {
                    printPage += "" + finas.getKey() + "\t" + finas.getValue() + "\t";
                }
                sum = sum + Integer.parseInt(finas.getValue());
                k++;
                //printPage+="Num\tqty\tNum\tqty\tNum\tqty\t";
                //System.out.println(finas.getKey() + ":" + finas.getValue());
            }
            printPage += "\nTotal Quantity : " + sum + "\n";
            printPage += "Wining point's    : " + jo.get("amount") + "\n\n";
            //System.out.println(printPage);
            PrintInvoice.Sample(printer, printPage, (String) jo.get("id"));
        }
        return Msg;
    }

//    public static void main(String args[]) {
//        try {
//            String data = "\n"
//                    + "{\"status\":\"1\",\"message\":\"You won!\",\"amount\":2,\"own\":\"10001\",\"drawid\":\"34\",\"id\":\"ask5e8dc8429f16f\",\"data\":\"2020-04-08 18:19:07\",\"winPoint\":{\"1765\":\"1\"}}";
//            claimJSON.claimJSONPrint(data);
//        } catch (Exception ex) {
//            Logger.getLogger(claimJSON.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
