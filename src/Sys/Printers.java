/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sys;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 *
 * @author asksoft
 */
public class Printers {

    public static PrintService[] loadPrinter() {
        try {

            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

            PrintService printServices[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
            return printServices;
        } catch (Exception ex) {

        }
        return null;
    }
}
