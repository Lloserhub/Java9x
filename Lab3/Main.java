import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 10;
        Shape[] shapes = new Shape[size];
        for (int i = 0; i < size; i++) {
            shapes[i] = getRandomShape();
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
        Arrays.sort(shapes, comparatorArea);
        System.out.println("\nAfter area sort: ");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        Arrays.sort(shapes, comparatorColor);
        System.out.println("\nAfter color sort: ");
        for (Shape shape : shapes) {
            System.out.println(shape);
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
