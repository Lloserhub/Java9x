package model;

public class Circle extends Shape {

    private double r;

    public Circle() {
        this.r = 1;
    }

    public Circle(double r) {
        this.r = r;
    }

    public Circle(String shapeColor, double r) {
        super(shapeColor);
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.println("Draw circle");
    }

    @Override
    public double calcArea() {
        return Math.PI * r * r;
    }

    @Override
    public String toString() {
        return "model.Circle{" +
                "r=" + r +
                ", shapeColor='" + shapeColor + '\'' +
                '}';
    }
}
