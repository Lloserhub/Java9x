import javafx.scene.control.Tab;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileIO {
    public static void main(String[] args) throws IOException {
        String content = null;
        URLConnection connection = null;
        String html = "https://google.com";
        List<String> tags = new ArrayList<>();
        try {
            connection =  new URL(html).openConnection();

            tags = getTags(new InputStreamReader(connection.getInputStream()));
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        List<Pair> pairs = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String string : tags) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            } else {
                map.put(string, map.get(string) + 1);
            }
        }


        for (String key : map.keySet()) {
            pairs.add(new Pair(key, map.get(key)));
        }
        System.out.println("String sort: ");
        pairs.sort(Comparator.comparing(o -> o.tag));
        for (Pair pair : pairs) {
            System.out.println(pair.tag + " " + pair.freq);
        }

        System.out.println("\n\nFreq sort");
        pairs.sort(Comparator.comparingInt(o -> o.freq));
        for (Pair pair : pairs) {
            System.out.println(pair.tag + " " + pair.freq);
        }
    }

    static public List<String> getTags(Reader reader)
            throws IOException {

        final List<String> tags = new ArrayList<>();
        HTMLEditorKit.ParserCallback callback =
                new HTMLEditorKit.ParserCallback() {
                    @Override
                    public void handleStartTag(HTML.Tag tag,
                                               MutableAttributeSet attributes,
                                               int pos) {
                        super.handleStartTag(tag, attributes, pos);
                        tags.add(tag.toString());
                    }
                };
        HTMLEditorKit.Parser parser = new ParserDelegator();
        parser.parse(reader, callback, true);

        return tags;
    }
}
