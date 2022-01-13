import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class InputStreamEncode extends FilterWriter {
    InputStreamEncode(Writer out) {
        super(out);
    }
    public void write(String str) throws IOException {
        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.setCharAt(i, (char)((int)str.charAt(i) + (int)Crypto.key));
        }
        super.write(stringBuilder.toString());
    }
}
