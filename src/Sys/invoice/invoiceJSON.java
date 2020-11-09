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
import Sys.TimeFormats;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
        String trno = (String) jo.get("trno");
        Map<String,String>printInformation=new HashMap<>();
        if (status.equals("1")) {
            String printPage = "";

            ArrayList<Map> ja = (ArrayList) jo.get("print");
            for (int i = 0; i < ja.size(); i++) {
                Map<String, String> printMap = ja.get(i);
                //System.out.println("Print data " + printMap);
                //printPage += "Rajashreee Lottery\n";
                String drDetails= "Dr.:" + printMap.get("gametimeid") + " " + printMap.get("enterydate") + " " + TimeFormats.timeConvert(printMap.get("gameendtime")) + "";
                //System.out.println(drDetails);
                String secondPrice = "Second Prize Amt: 180/- ";
                //System.out.println(secondPrice);
                String numberHeader = "NUMBER QT NUMBER QT NUMBER QT";
                //System.out.println(numberHeader);
                Map<String, ArrayList> printMapd = new TreeMap<>(ja.get(i));
                ArrayList<Map> point = printMapd.get("point");
                int k = 1;
                int limit = 1;
                String numberTable = "";
                String printPageFooter = "";
                printPageFooter += "Per Ticket price .2.00\n";
                printPageFooter += "Total Quantity : " + printMap.get("totalpoint") + "\n";
                printPageFooter += "Total Point    : " + printMap.get("amount") + "\n";
                printPageFooter += "Total Tr No.   : " + trno + "\n";
                printPageFooter += "Barcode No.    : " + printMap.get("game") + "-\n";
                for (int j = 0; j < point.size(); j++) {
                    Map<String, String> dPoint = new TreeMap<>(point.get(j));

                    for (Map.Entry<String, String> finas : dPoint.entrySet()) {
                        int val = Integer.parseInt(finas.getValue());

                        for (int c = 0; c < val; c++) {
                            if (limit == 57) {
                                limit = 1;
                                //String dp = buildInvoice(numberTable, printPage, printPageFooter);
                                //System.out.println(dp);
                                PrintInvoice.Sample(currentPrinter, drDetails,secondPrice,numberHeader,numberTable,printPageFooter, printMap.get("game"));
                                numberTable = "";
                                numberTable += "RL" + finas.getKey() + " " + 1 + "  ";
                                k = 2;
                            } else {
                                if (k == 3) {
                                    numberTable += "RL" + finas.getKey() + " " + 1 + "  \n";
                                    k = 0;
                                } else {
                                    numberTable += "RL" + finas.getKey() + " " + 1 + "  ";
                                }
                                k++;
                                limit++;
                            }
                        }

                        //k++;
                        //printPage+="Num\tqty\tNum\tqty\tNum\tqty\t";
                        ////System.out.println(finas.getKey() + ":" + finas.getValue());
                    }

                }
                //System.out.println(numberTable);
                //System.out.println(printPageFooter);
                if (limit >= 1) {
                    limit = 1;
//                    String dp = buildInvoice(numberTable, printPage, printPageFooter);
//                    System.out.println(dp);
                    PrintInvoice.Sample(currentPrinter, drDetails,secondPrice,numberHeader,numberTable,printPageFooter, printMap.get("game"));
                            
                    numberTable = "";
                    k = 0;
                }
                
                //printPage += invoiceJSON.getBarocde();
                //System.out.println(printPage);
                //PrintInvoice.Sample(currentPrinter, printPage, printMap.get("game"));
                printPage = "";
                System.gc();
            }

        }

        // iterating phoneNumbers 
        return Msg;
    }

    private static String buildInvoice(String numberTable, String printPage, String printPageFooter) {
        return printPage + "\n" + numberTable + "\n" + printPageFooter;
    }
}
