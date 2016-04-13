import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;
 
/**
 * This class makes the prints appear in the text area rather than in the console
 * Got this code from:
 * @author www.codejava.net
 */
public class TextOutput extends OutputStream {
    private JTextArea textArea;
     
    public TextOutput(JTextArea textArea) {
        this.textArea = textArea;
    }
     
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}