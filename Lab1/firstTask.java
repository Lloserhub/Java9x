import java.util.Arrays;

public class Solver {

    public static void main(String[] args) {
        Solver solver = new Solver();
        String text = "hello I am масив of woзrds";
        System.out.println("Initial string: " + text);
        System.out.println("Only english words: " + Arrays.toString(solver.getEnglishWords(text)));
        System.out.println("Only equals words: " + Arrays.toString(solver.getEqualWords(solver.getEnglishWords(text))));
        String[] solve = solver.solveTask(text); //Result
    }

    String[] solveTask(String text) {
        return getEqualWords(getEnglishWords(text));
    }

    String[] getEqualWords(String[] words) {
        String[] equalWords = new String[0];
        for (String word : words) {
            int vowels = 0;
            int unvowels = 0;
            for (Character ch : word.toCharArray()) {
                if (isVowel(ch)) {
                    vowels++;
                } else {
                    unvowels++;
                }
            }
            if (vowels == unvowels) {
               equalWords = addStringToArray(word, equalWords);
            }
        }
        return equalWords;
    }

    boolean isVowel(Character ch) {
        switch (Character.toLowerCase(ch)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y': return true;
            default: return false;
        }
    }

    String[] getEnglishWords(String text) {
        String[] words = text.split(" ");
        String[] enWords = new String[0];
        for (String str : words) {
            boolean isEnglish = true;
            for (Character ch : str.toCharArray()) {
                if (!isEnglishChar(ch)) {
                    isEnglish = false;
                }
            }
            if (isEnglish) {
                enWords =  addStringToArray(str, enWords);
            }
        }
        return enWords;
    }

    private String[] addStringToArray(String string, String[] array) {
        String[] newArr = new String[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        newArr[array.length] = string;
        return newArr;
    }

    boolean isEnglishChar(char ch) {
        if (Character.toLowerCase(ch) >= 'a' && Character.toLowerCase(ch) <= 'z') {
            return true;
        } else {
            return false;
        }
    }

}
