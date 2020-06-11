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
/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */
import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPosConst;
import com.github.anastaciocintra.escpos.Style;
import com.github.anastaciocintra.escpos.barcode.BarCode;
import com.github.anastaciocintra.output.PrinterOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;

/**
 * Show how to use text styles.
 *
 * @author Marco Cintra
 */
public class PrintInvoice {

    public static void Sample(String printerName, String drDetails, String secondPrice, String numberHeader, String numberTable, String printPageFooter, String Barcode) {

        // get the printer service by name passed on command line...
        //this call is slow, try to use it only once and reuse the PrintService variable.
        PrintService printService = PrinterOutputStream.getPrintServiceByName(printerName);
        EscPos escpos;
        try {
            escpos = new EscPos(new PrinterOutputStream(printService));

            Style title = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Left_Default);

            Style subtitle = new Style(escpos.getStyle())
                    .setBold(true)
                    .setUnderline(Style.Underline.OneDotThick);
            Style bold = new Style(escpos.getStyle())
                    .setBold(true);

            escpos.writeLF(title, "RajLaxmi Lottery").feed(2);
            escpos.writeLF(bold, drDetails)
                    .feed(1);
            escpos.writeLF(bold, numberHeader)
                    .feed(2);
            escpos.writeLF(numberTable)
                    .feed(2);
            escpos.writeLF(bold, printPageFooter)
                    .feed(2);

            BarCode barcode = new BarCode();
            barcode.setSystem(BarCode.BarCodeSystem.CODE93_Default);
            barcode.setHRIPosition(BarCode.BarCodeHRIPosition.BelowBarCode);
            barcode.setBarCodeSize(3, 50);
            escpos.feed(1);
            escpos.write(barcode, Barcode);
            //escpos.feed(5);
            escpos.cut(EscPos.CutMode.FULL);

            escpos.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(PrintInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        if (args.length != 1) {

            
        }

        //System.exit(0);
    }

    public static PrintService findPrintService(String printerName, PrintService[] services) {
        for (PrintService service : services) {
            if (service.getName().equalsIgnoreCase(printerName)) {
                return service;
            }
        }

        return null;
    }

}
