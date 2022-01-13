import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class OutputStreamDecode extends FilterReader {
    OutputStreamDecode(Reader in) {
        super(in);
    }

    public int read() throws IOException {
        int x = super.read();
        x = x - Crypto.key;
        return x;
    }
}
