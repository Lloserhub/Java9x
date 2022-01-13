import files.FileSaver;
import model.Circle;
import model.Rectangle;
import model.Shape;
import model.Triangle;

import java.io.IOException;
import java.util.*;

public class Main {
    static List<Shape> shapes = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while (true) {
            System.out.println("1: Init to file...");
            System.out.println("2: Load from file...");
            System.out.println("3: Print all shapes...");
            System.out.println("0: Exit");
            choice = in.nextInt();
            String filename = "";
            switch (choice) {
                case 1:
                    System.out.println("Input filename to save...");
                    filename = in.next();
                    init(filename);
                    break;
                case 2:
                    System.out.println("Input filename to save...");
                    filename = in.next();
                    try {
                        System.out.println(filename);
                        shapes = FileSaver.load(filename);
                    } catch (IOException e) {
                        System.out.println("Can't load: " + e.getMessage());
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        System.out.println("Can't parse: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(shapes);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }

    static void init(String filename) {
        int size = 10;

        for (int i = 0; i < size; i++) {
            shapes.add(getRandomShape());
        }
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        double sum = 0;

        for (Shape shape : shapes) {
            sum += shape.calcArea();
        }
        System.out.println("Total area: " + sum);

        sum = 0;
        for (Shape shape : shapes) {
            if (shape instanceof Triangle) {
                sum += shape.calcArea();
            }
        }
        System.out.println("Total triangles sum: " + sum);

        sum = 0;
        for (Shape shape : shapes) {
            if (shape instanceof Rectangle) {
                sum += shape.calcArea();
            }
        }
        System.out.println("Total rectangles sum: " + sum);

        sum = 0;
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                sum += shape.calcArea();
            }
        }
        System.out.println("Total circles sum: " + sum);
        Comparator<Shape> comparatorArea = (o1, o2) -> (int) (o1.calcArea() - (o2.calcArea()));
        Comparator<Shape> comparatorColor = (o1, o2) -> o1.shapeColor.compareTo(o2.shapeColor);
        shapes.sort(comparatorArea);
        System.out.println("\nAfter area sort: ");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        shapes.sort(comparatorColor);
        System.out.println("\nAfter color sort: ");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        try {
            FileSaver.save(shapes, filename);
            System.out.println("Info saved");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Shape getRandomShape() {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                return new Circle("red", random.nextInt(10) + 1);
            case 1:
                return new Rectangle("blue", random.nextInt(10) + 1, random.nextInt(10) + 1);
            case 2:
                int triangleSide = random.nextInt(10);
                triangleSide++;
                return new Triangle("green", triangleSide, triangleSide + 1, triangleSide + 2);
        }
        return new Circle("red", random.nextInt(10));
    }
}
