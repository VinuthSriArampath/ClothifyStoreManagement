package util;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class PdfGenerateUtil {
    public static String create(String text) {
        try {
            String path = "Bill.pdf";
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
}
