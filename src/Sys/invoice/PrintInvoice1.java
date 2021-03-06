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
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;

/**
 * Show how to use text styles.
 *
 * @author Marco Cintra
 */
public class PrintInvoice1 {

    public static void Sample(String printerName, String Data, String Barcode) {

        try {
            // get the printer service by name passed on command line...
            //this call is slow, try to use it only once and reuse the PrintService variable.
            //new code

            Document document = new Document(new Rectangle(PageSize.A4));
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Java4s_BarCode_128.pdf"));

            document.open();
            float fntSize, lineSpacing;
            fntSize = 6.7f;
            lineSpacing = 10f;
            String line = "10";
            Paragraph p = new Paragraph(new Phrase(lineSpacing, line, FontFactory.getFont(FontFactory.COURIER, fntSize)));
            Font f3 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            p = new Paragraph("Samrudhi Lottery");
            p.setFont(f3);
            document.add(p);
            f3 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
            p = new Paragraph(Data);
            p.setFont(f3);
            document.add(p);

            Barcode128 code128 = new Barcode128();
            code128.setGenerateChecksum(true);
            code128.setCode(Barcode);

            document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
            document.close();

            //System.out.println("Document Generated...!!!!!!");
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

            PrintService printService[] = PrintServiceLookup.lookupPrintServices(
                    flavor, pras);
            System.out.println(Arrays.toString(printService));
            PrintService service = findPrintService(printerName, printService);
            DocPrintJob job = service.createPrintJob();
//            job.addPrintJobListener(new PrintJobAdapter() {
//                public void printDataTransferCompleted(PrintJobEvent event) {
//                    //System.out.println("data transfer complete");
//                }
//
//                public void printJobNoMoreEvents(PrintJobEvent event) {
//                    //System.out.println("received no more events");
//                }
//            });
            FileInputStream fis = new FileInputStream("Java4s_BarCode_128.pdf");
            Doc doc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
            // Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.JPEG, null);
            PrintRequestAttributeSet attrib = new HashPrintRequestAttributeSet();
            attrib.add(new Copies(1));
            job.print(doc, null);
            //end
//            PrintService printService = PrinterOutputStream.getPrintServiceByName(printerName);
//            EscPos escpos;
//            try {
//                escpos = new EscPos(new PrinterOutputStream(printService));
//
//                Style title = new Style()
//                        .setFontSize(Style.FontSize._3, Style.FontSize._3)
//                        .setJustification(EscPosConst.Justification.Center);
//
//                Style subtitle = new Style(escpos.getStyle())
//                        .setBold(true)
//                        .setUnderline(Style.Underline.OneDotThick);
//                Style bold = new Style(escpos.getStyle())
//                        .setBold(true);
//                BarCode barcode = new BarCode();
//                escpos.writeLF(title, "RajLaxmi Lottery")
//                        .feed(5);
//                escpos.writeLF(bold, Data)
//                        .feed(8);
//                escpos.writeLF("barcode write HRI above");
//                barcode.setHRIPosition(BarCode.BarCodeHRIPosition.AboveBarCode);
//                escpos.feed(2);
//                escpos.write(barcode, Barcode);
//                escpos.feed(3);
//                escpos.cut(EscPos.CutMode.FULL);
//
//                escpos.close();
        } catch (FileNotFoundException | DocumentException | PrintException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        if (args.length != 1) {

            //PrintInvoice.Sample("Boomaga", "TESTING", "123456");

        }

        //System.exit(0);
    }

    public static PrintService findPrintService(String printerName,PrintService[] services) {
		for (PrintService service : services) {
			if (service.getName().equalsIgnoreCase(printerName)) {
				return service;
			}
		}

		return null;
	}

}
