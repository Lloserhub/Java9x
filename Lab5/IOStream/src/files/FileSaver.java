package files;

import model.Shape;

import java.io.*;
import java.util.*;

public class FileSaver {
    public static void save(List<Shape> shapes, String filename) throws IOException {
        FileOutputStream f = new FileOutputStream(new File(filename));
        ObjectOutputStream o = new ObjectOutputStream(f);
        for (Shape shape : shapes) {
            o.writeObject(shape);
        }
        o.close();
        f.close();
    }

    public static List<Shape> load(String filename) throws IOException, ClassNotFoundException {
        Shape shape = null;
        FileInputStream fi = new FileInputStream(new File(filename));
        ObjectInputStream oi = new ObjectInputStream(fi);
        System.out.println(shape);
        List<Shape> shapes = new ArrayList<>();
        while (true) {
            try {

                shape = (Shape)oi.readObject();
            } catch (EOFException e) {
                break;
            }
            if (shape == null) {
                break;
            } else {
                shapes.add(shape);
            }
        }
        oi.close();
        fi.close();
        return shapes;
    }
}
