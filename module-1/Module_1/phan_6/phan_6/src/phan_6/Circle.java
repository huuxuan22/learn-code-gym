package phan_6;

public class Circle {
    protected double radius;
    protected String color;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle_Cylinder{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
