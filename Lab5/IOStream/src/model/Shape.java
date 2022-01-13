package model;

import java.io.Serializable;

public abstract class Shape implements Drawable, Serializable {
    private static final long serialVersionUID = 1L;
    public String shapeColor;
    Shape() {
        this.shapeColor = "white";
    }

    Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return "model.Shape{" +
                "shapeColor='" + shapeColor + '\'' +
                '}';
    }
}
