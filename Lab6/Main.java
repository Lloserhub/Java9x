import java.util.Scanner;

public class Main {
    public static Dictionary dictionary = new Dictionary();

    public static void main(String[] args) {
        init();
        String tr = "Здоров я ювелір, ім'я Макс";
        System.out.println("Original: " + tr);
        System.out.println("Translate: " + dictionary.translateText(tr));
        Scanner in = new Scanner(System.in);
        while (true) {
            int choice = 1;
            System.out.println("1: add word-translate");
            System.out.println("2: translate from english word");
            System.out.println("3: translate from ua word");
            System.out.println("0: exit");
            choice = in.nextInt();
            String temp = "";
            switch (choice) {
                case 1:
                    String word;
                    String translate;
                    System.out.println("Input word");
                    word = in.next();
                    System.out.println("Input translate");
                    translate = in.next();
                    dictionary.add(word, translate);
                    break;
                case 2:
                    System.out.println("Input english: ");
                    temp = in.next();
                    System.out.println("Translate: " + dictionary.translate(temp));
                    break;
                case 3:
                    System.out.println("Input ua: ");
                    temp = in.next();
                    System.out.println("Translate: " + dictionary.reverseTranslate(temp));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    public static void init() {
        dictionary.add("jeweller", "ювелір");
        dictionary.add("door", "двері");
        dictionary.add("horse", "коня");
        dictionary.add("hi", "Здоров");
        dictionary.add("goodbye", "До побачення");
        dictionary.add("me", "мене");
        dictionary.add("name", "ім'я");
        dictionary.add("My", "мій");
        dictionary.add("I", "Я");
    }
}
