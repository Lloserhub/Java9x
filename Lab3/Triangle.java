public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(String shapeColor, double a, double b, double c) {
        super(shapeColor);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void draw() {
        System.out.println("Draw triangle");
    }

    @Override
    double calcArea() {
        double p2 = (a + b + c) / 2;
        return Math.sqrt(p2 * (p2 - a) * (p2 - b) * (p2 - c));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "shapeColor='" + shapeColor + '\'' +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
