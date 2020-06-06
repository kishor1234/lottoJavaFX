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

        // getting firstName and lastName 
        String status = (String) jo.get("status");
        String Msg = (String) jo.get("msg");
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
                        if (k == 3) {
                            printPage += "" + finas.getKey() + "  " + finas.getValue() + "\n";
                            k = 0;
                        } else {
                            printPage += "" + finas.getKey() + "  " + finas.getValue() + "  ";
                        }
                        k++;
                        //printPage+="Num\tqty\tNum\tqty\tNum\tqty\t";
                        ////System.out.println(finas.getKey() + ":" + finas.getValue());
                    }

                }
                printPage += "\nTotal Quantity : " + printMap.get("totalpoint") + "\n";
                printPage += "Total Point    : " + printMap.get("amount") + "\n\n";
                printPage += "Invoice " + printMap.get("game") + "\n";
                //printPage += invoiceJSON.getBarocde();
                ////System.out.println(printPage);
                PrintInvoice.Sample(currentPrinter, printPage, printMap.get("game"));
//            printerService.printString("PDF", printPage);
//            byte[] cutP = new byte[]{0x1d, 'V', 1};
//            printerService.printBytes("PDF", cutP);
                ////System.out.println("New Print");
                printPage = "";
            }
        } else {

        }

        // iterating phoneNumbers 
        return Msg;
    }
//    public static BarCode getBarocde()
//	{
//		BarCode code128 = new BarCode();
//		
//		//IBarCode.CODE128, IBarCode.CODE128A, IBarCode.CODE128B, 
//		//     or IBarCode.CODE128C
//		code128.setSymbology(IBarCode.CODE128);
//	
//	    //Input your barcode encoding data:
//		code128.setCodeToEncode("ask5e884b33c8a9f");
//		
//		
//		
//	    /*
//	     * 
//	     * Set TildeEnabled to true, specifying special characters in barcode data.
//
//           Support escape '~' for data message
//
//           1-byte character: ~ddd (character value from 0 ~ 255)
//           ASCII (with EXT): from ~000 to ~255
//
//           For example, ASCII char [GS] is non-printable, and its decimal value is 29. 
//           In barcode data, you need use ~029 for char [GS].
//
//	     * 
//	     */
//		code128.setTildeEnabled(false);
//		
//		
//		
//		
//		
//	    
//	    // Barcode Size Settings Here
//	    
//	    // if AutoSizeAdjust is true, the library will use the properties
//	    // BarcodeWidth & BarcodeHeight, and ignore properties X & Y. 
//	    // The library will calculate the max X and Y value.
//		code128.setAutoSizeAdjust(false);
//	    
//	    // Unit of measure, pixel, cm and inch supported.
//		code128.setUOM(IBarCode.UOM_PIXEL);
//	    
//	    // Barcode image resolution in dpi
//		code128.setDpi(300);
//	    
//	    // Barcode image width & height
//		code128.setBarcodeWidth(300);
//		code128.setBarcodeHeight(200);
//	    
//	    // Barcode bar module width (X dimention)
//		code128.setX(3);
//	    // Barcode bar module height (Y dimention)
//		code128.setY(180);
//
//	    // barcode image left margin size.
//		code128.setLeftMargin(0);
//	    // Image right margin size.
//		code128.setRightMargin(0);
//	    // Image top margin size.
//		code128.setTopMargin(0);
//	    // Image bottom margin size.
//	    code128.setBottomMargin(0);
//
//	    // barcode orientation, 90, 180, 270 degrees supported.
//	    code128.setOrientation(IBarCode.ROTATE_0);
//	    
//	    // barcode alignment in the image
//	    code128.setBarAlignment(IBarCode.BAR_ALIGN_CENTER);
//	    
//	    // set barcode back and fore colors
//	    code128.setBackColor(Color.white);
//	    code128.setForeColor(Color.black);
//	    
//	    
//	    // Barcode Text Settings
//	    
//	    // Set to true, displaying barcode value text, 
//	    // otherwise do not display. 
//	    code128.setDisplayText(true);
//	    
//	    // Barcode text font style. 
//	    code128.setTextFont(new Font("Arial", Font.PLAIN, 22));
//	   
//		// text color
//	    code128.setTextColor(Color.black);
//		
//		// margin space between text and bar
//	    code128.setTextMargin(10);
//
//
//	    // barcode image formats, supporting Png, Jpeg, Gif, Tiff, Bmp, etc.
//	    code128.setImageFormat(IBarCode.IMG_PNG);
//            return code128;
////	    try
////	    {     
////	    	// Generate barcodes in image format GIF
////	    	code128.draw("ka-demo-code128.png");
////	    }
////	    catch (Exception e) 
////	    {
////	    	e.printStackTrace();
////	    }
//	}
}
