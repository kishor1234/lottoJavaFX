/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asksoft
 */
import com.itextpdf.text.BaseColor;
import java.io.File;

import java.io.FileOutputStream;

import java.io.OutputStream;

import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;
import java.io.IOException;

public class GeneratePDF {

    class MyCellField implements PdfPCellEvent {

        protected String fieldname;

        public MyCellField(String fieldname) {
            this.fieldname = fieldname;
        }

        public void cellLayout(PdfPCell cell, Rectangle rectangle, PdfContentByte[] canvases) {
            final PdfWriter writer = canvases[0].getPdfWriter();
            final TextField textField = new TextField(writer, rectangle, fieldname);
            try {
                final PdfFormField field = textField.getTextField();
                writer.addAnnotation(field);
            } catch (final IOException ioe) {
                throw new ExceptionConverter(ioe);
            } catch (final DocumentException de) {
                throw new ExceptionConverter(de);
            }
        }
    }

    public static void main(String[] args) {

        try {

            OutputStream file = new FileOutputStream(new File("Test.pdf"));

            Document document = new Document();

            PdfWriter.getInstance(document, file);

            document.open();

            //document.add(new Paragraph("Hello World, iText"));
            document.add(new Paragraph("RajLaxmi Lottery", FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.BOLD, BaseColor.BLACK)));
            document.add(new Paragraph("Nubmer  Qty Number Qty Number Qty", FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.BOLD, BaseColor.BLACK)));
            document.add(new Paragraph("1001    05  10001  05  1000   30", FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.BOLD, BaseColor.BLACK)));
            document.add(new Paragraph("1001    05  10001  05  1000   30", FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.BOLD, BaseColor.BLACK)));
            document.add(new Paragraph("1001    05  10001  05  1000   30", FontFactory.getFont(FontFactory.TIMES_ROMAN, 6, Font.BOLD, BaseColor.BLACK)));
            document.close();

            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
