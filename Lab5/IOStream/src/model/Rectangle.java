package model;

public class Rectangle extends Shape {
    private double a;
    private double b;

    Rectangle() { a = 1; b = 1;}

    public Rectangle(double a, double b) {
        super();
        this.a = a;
        this.b = b;
    }

    public Rectangle(String shapeColor, double a, double b) {
        super(shapeColor);
        this.a = a;
        this.b = b;
    }

    @Override
    public void draw() {
        System.out.println("Draw rectangle");
    }

    @Override
    public double calcArea() {
        return a * b;
    }

    @Override
    public String toString() {
        return "model.Rectangle{" +
                "a=" + a +
                ", b=" + b +
                ", shapeColor='" + shapeColor + '\'' +
                '}';
    }
}
