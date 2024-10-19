package util;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.time.LocalDate;

public class PdfGenerateUtil {
    public static String create(String text) {
        try {
            String path = "Documents/LastBill.pdf";
            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph(text));
            document.close();
            return path;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Boolean generateAnnualSalesReport(String text, LocalDate date) {
        try {
            String path = "Documents/AnnualSalesReports/AnnualSalesReport "+date.getYear()+".pdf";
            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph(text));
            document.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static Boolean generateMonthlySalesReport(String text, LocalDate date) {
        try {
            String path = "Documents/MonthlySalesReport/MonthlySalesReport "+date.getMonth()+"-"+date.getYear()+".pdf";
            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph(text));
            document.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean generateDailySalesReport(String text, LocalDate date) {
        try {
            String path = "Documents/DailySalesReport/DailySalesReport "+date+".pdf";
            PdfWriter writer = new PdfWriter(path);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.add(new Paragraph(text));
            document.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
