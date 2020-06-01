/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys.invoice;

import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.output.PrinterOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;

/**
 *
 * @author asksoft
 */
public class TestEP {

    public static void main(String args[]) {
        PrinterOutputStream printerOutputStream = null;
        try {
            PrintService printService = PrinterOutputStream.getPrintServiceByName("PDF");
            printerOutputStream = new PrinterOutputStream(printService);
            EscPos escpos = new EscPos(printerOutputStream);
            escpos.writeLF("Hello Wold");
            escpos.feed(5);
            escpos.cut(EscPos.CutMode.FULL);
            escpos.close();
        } catch (IOException ex) {
            Logger.getLogger(TestEP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                printerOutputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(TestEP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
