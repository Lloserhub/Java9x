public abstract class Shape implements Drawable {
    String shapeColor;
    Shape() {
        this.shapeColor = "white";
    }

    Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    abstract double calcArea();

    @Override
    public String toString() {
        return "Shape{" +
                "shapeColor='" + shapeColor + '\'' +
                '}';
    }
}
