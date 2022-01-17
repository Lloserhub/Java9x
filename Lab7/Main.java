import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AlphaSpecChecker isLatin
                = (ch, first, last)
                -> (Character.toLowerCase(ch) >= Character.toLowerCase(first)
                        && Character.toLowerCase(ch) <= Character.toLowerCase(last));

        SoundMirrored isMirroredByVowelsCons = (word, vowels, cons)  -> {
            int firstHalf = 0, secondHalf = 0;
            for (Character ch : word.toCharArray()) {
                boolean isFound = false;
                for (Character half1 : vowels.toCharArray()) {
                    if (Character.toLowerCase(ch) == Character.toLowerCase(half1)) {
                        firstHalf++;
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    continue;
                }
                for (Character half2 : cons.toCharArray()) {
                    if (Character.toLowerCase(ch) == Character.toLowerCase(half2)) {
                        secondHalf++;
                        break;
                    }
                }
            }
            return secondHalf == firstHalf;
        };

        List<String> words = new ArrayList<>();
        List<String> latinWords = new ArrayList<>();

        Collections.addAll(words,
                "here", "no", "errors");

        for (String word : words) {
            boolean isLa = true;
            for (Character ch : word.toCharArray()) {
                if (!isLatin.isIn(ch, 'a', 'z')) {
                    System.out.println(word);
                    isLa = false;
                    break;
                }
            }
            if (isLa) {
                latinWords.add(word);
            }
        }
        System.out.println(latinWords);
        String vow = "AEIOU";
        String cons = "BCDFGHJKLMNPQRSTVWXYZ";

        List<String> mirrored = new ArrayList<>();
        for (String word : latinWords) {
            if (isMirroredByVowelsCons.isMirrored(word, vow, cons)) {
                mirrored.add(word);
            }
        }
        System.out.println("Result: " + mirrored);
    }



    /**
     * Реализация должна проверять,
     * попадает ли символ ch в диапазон от firstAlphaChar до lastAlphaChar
     * */
    @FunctionalInterface
    interface AlphaSpecChecker {
        boolean isIn(char ch, char firstAlphaChar, char lastAlphaChar);
    }

    /**
     * Реализация должна проверять,
     * равно ли количество символов, принадлежащих множеству firstHalf в слове word,
     * количеству символов, принадлежащих множеству secondHalf
     * */
    @FunctionalInterface
    interface SoundMirrored {
        boolean isMirrored(String word, String firstHalf, String secondHalf);
    }
}
