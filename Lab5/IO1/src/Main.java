import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "";
        System.out.println("Input filename: ");
        filename = scanner.next();
        List<String> strings = FileGetter.getAllStrings(filename);
        int max = 0;
        String maxLine = "";
        for (String  s : strings) {
            if (s.split(" ").length > max) {
                max = s.split(" ").length;
                maxLine = s;
            }
        }
        System.out.println("MaxLine: " + maxLine);
        System.out.println("Count words: " + max);
    }
}
