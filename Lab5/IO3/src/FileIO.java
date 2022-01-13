import java.io.*;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String filename = in.next();
        StringBuilder stringBuilder = new StringBuilder();
        FileWriter fileWriter = new FileWriter(filename);
        FilterWriter filterWriter = new InputStreamEncode(fileWriter);
        filterWriter.write("encode me, please");
        fileWriter.close();
        filterWriter.close();


        FileReader fileReader = new FileReader(filename);
        int i;
        System.out.println("Encoded: ");
        while ((i = fileReader.read()) != -1) {
            System.out.print((char) i);
        }
        System.out.println();
        fileReader = new FileReader(filename);
        FilterReader filterReader = new OutputStreamDecode(fileReader);
        System.out.println("Decoded: ");
        while ((i = filterReader.read()) != (-1 - Crypto.key)) {
            System.out.print((char)i);

        }
    }
}
