import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.net.URL;

/**
 * Created by David on 5/1/2017.
 */
public class VegdahlMain {
    public static void main(String[] args) throws IOException {
        final String searchWord = "garbage collection";
        final PDFTextStripper textStripper = new PDFTextStripper();
        for (int i = 1; i < 26; i++) {
            final PDDocument document = PDDocument.load(new URL("http://teaching.up.edu/cs358/lectures/lec" + (i < 10 ? "0" + i : i) + ".pdf").openStream());
            if (textStripper.getText(document).contains(searchWord)) System.out.println("Found in: " + i);
            document.close();
        }
    }

}
