
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileInputStream;
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
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

public class BarCode128 {

    public static void main(String[] args) throws FileNotFoundException, DocumentException, PrintException {

        Document document = new Document(new Rectangle(PageSize.A4));
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Java4s_BarCode_128.pdf"));

        document.open();
        
        
        document.add(new Paragraph("Rajashreee Lottery"));
        

        Barcode128 code128 = new Barcode128();
        code128.setGenerateChecksum(true);
        code128.setCode("1234554321");

        document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
        document.newPage();
        
        document.close();

        System.out.println("Document Generated...!!!!!!");
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.PDF;
        PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
        PrintService ps = null;
        for (PrintService printServiceName : services) {
            if (printServiceName.getName().equals("Boomaga")) {
                ps = printServiceName;
                break;
            }
        }
        //PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob job = ps.createPrintJob();
        job.addPrintJobListener(new PrintJobAdapter() {
            public void printDataTransferCompleted(PrintJobEvent event) {
                System.out.println("data transfer complete");
            }

            public void printJobNoMoreEvents(PrintJobEvent event) {
                System.out.println("received no more events");
            }
        });
        FileInputStream fis = new FileInputStream("Java4s_BarCode_128.pdf");
        Doc doc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
        // Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.JPEG, null);
        PrintRequestAttributeSet attrib = new HashPrintRequestAttributeSet();
        attrib.add(new Copies(1));
        job.print(doc, attrib);
    }

}
