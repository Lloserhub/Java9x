import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileGetter {
    public static List<String> getAllStrings(String fileName) {
        List<String> strings = new ArrayList<>();
        try (FileReader fileReader = new FileReader(new File(fileName));
             BufferedReader reader = new BufferedReader(fileReader)) {
            String str;
            while ((str = reader.readLine()) != null) {
                strings.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
