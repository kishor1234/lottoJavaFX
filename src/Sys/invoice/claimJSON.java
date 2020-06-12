/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.invoice;

import Sys.TimeFormats;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author asksoft
 */
public class claimJSON {

    public static String claimJSONPrint(String data, String printer) throws Exception {
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
            // printPage += "RajLaxmi Lottery\n";
//            String drDetails= "Dr.:" + printMap.get("gametimeid") + " " + printMap.get("enterydate") + " " + TimeFormats.timeConvert(printMap.get("gameendtime")) + "\n";
//                String secondPrice = "Second Prize Amt: 180/- \n";
//                String numberHeader = "Num Qty Num Qty Num Qty ";
            String drDetails = "Wining Point's\n";
            drDetails += "Wining Ticke id : " + (String) jo.get("id");
            String secondPrice = "  Draw id : " + (String) jo.get("drawid") + "\n";
            secondPrice += "Date: " + (String) jo.get("date") + "\n\n";
            String numberHeader = "NUMBER QT NUMBER QT NUMBER QT";
            int k = 1;
            int sum = 0;
            for (Map.Entry<String, String> finas : wPoint.entrySet()) {
                if (k == 3) {
                    printPage += "RL" + finas.getKey() + " " + finas.getValue() + "\n";
                    k = 0;
                } else {
                    printPage += "RL" + finas.getKey() + " " + finas.getValue() + "  ";
                }
                sum = sum + Integer.parseInt(finas.getValue());
                k++;
                //printPage+="Num\tqty\tNum\tqty\tNum\tqty\t";
                //System.out.println(finas.getKey() + ":" + finas.getValue());
            }
            String printPageFooter = "\nTotal Quantity : " + sum + "\n";
            printPageFooter += "Wining point's    : " + jo.get("amount") + "\n\n";
            //System.out.println(printPage);
            PrintInvoice.Sample(printer, drDetails, secondPrice, numberHeader, printPage, printPageFooter, (String) jo.get("id"));

            //PrintInvoice.Sample(printer, printPage, (String) jo.get("id"));
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
