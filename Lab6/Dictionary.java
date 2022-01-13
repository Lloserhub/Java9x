import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Dictionary {
    private final Map<String, String> dictionary = new HashMap<>();

    public void add(String word, String translate) {
        if (!dictionary.containsKey(word.toLowerCase())) {
            dictionary.put(word.toLowerCase(), translate.toLowerCase());
        } else {
            return;
        }
    }

    public void update(String word, String translate) {
        dictionary.put(word.toLowerCase(), translate.toLowerCase());
    }

    public String translateText(String text) {
        text = text.toLowerCase();
        StringBuilder sb = new StringBuilder();
        String[] strings = text.split(" ");
        for (String str : strings) {
            sb.append(reverseTranslate(str)).append(" ");
        }
        return sb.toString();
    }

    public String translate(String word) {
        word = word.toLowerCase();
        return dictionary.getOrDefault(word, word);
    }

    public String reverseTranslate(String word) {
        word = word.toLowerCase();
        for (String s : dictionary.keySet()) {
            if (dictionary.get(s).equalsIgnoreCase(word)) {
                return s;
            }
        }
        return word;
    }
}
