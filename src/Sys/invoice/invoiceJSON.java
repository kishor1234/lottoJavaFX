/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.invoice;

/**
 *
 * @author asksoft
 */
// Java program to read JSON from a file 
import controller.DashboardController;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class invoiceJSON {

    public static String invoiceJSONPrint(String data, String currentPrinter) throws Exception {
        // parsing file "JSONExample.json" 
        //DashboardController dc = new DashboardController();
        Object obj = new JSONParser().parse(data);

        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj;
        System.out.println(jo);

        // getting firstName and lastName 
        String status = (String) jo.get("status");
        String Msg = (String) jo.get("msg");
        String Advance = (String) jo.get("advance");
        if (status.equals("1")) {
            String printPage = "";

            ArrayList<Map> ja = (ArrayList) jo.get("print");
            for (int i = 0; i < ja.size(); i++) {
                Map<String, String> printMap = ja.get(i);
                // //System.out.println("Print data "+printMap);
                printPage += "Rajashreee Lottery\n";
                printPage += "Draw ID:" + printMap.get("gametimeid") + "     Draw Time:" + printMap.get("gameendtime") + "\n\n";
                printPage += "Num  qty  Num  qty  Num  qty  \n";
                Map<String, ArrayList> printMapd = ja.get(i);
                ArrayList<Map> point = printMapd.get("point");
                int k = 1;
                for (int j = 0; j < point.size(); j++) {
                    Map<String, String> dPoint = point.get(j);

                    for (Map.Entry<String, String> finas : dPoint.entrySet()) {
                        int val = Integer.parseInt(finas.getValue());
                       
                        for (int c = 0; c<val; c++) {
                            if (k == 3) {
                                printPage += "" + finas.getKey() + "  " + 1 + "\n";
                                k = 0;
                            } else {
                                printPage += "" + finas.getKey() + "  " + 1 + "  ";
                            }
                            k++;
                        }
                        //k++;
                        //printPage+="Num\tqty\tNum\tqty\tNum\tqty\t";
                        ////System.out.println(finas.getKey() + ":" + finas.getValue());
                    }

                }
                printPage += "\nTotal Quantity : " + printMap.get("totalpoint") + "\n";
                printPage += "Total Point    : " + printMap.get("amount") + "\n\n";
                printPage += "Invoice " + printMap.get("game") + "\n";
                //printPage += invoiceJSON.getBarocde();
                System.out.println(printPage);
                PrintInvoice.Sample(currentPrinter, printPage, printMap.get("game"));

                printPage = "";
            }

        }

        // iterating phoneNumbers 
        return Msg;
    }
}
