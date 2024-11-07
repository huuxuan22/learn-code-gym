package howToColor;

public class Circle extends Shape {
    private double radius;

    public Circle() {

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double radius) {
        super(Integer.parseInt(color));
        this.radius = radius;
    }
    public double getArea(){

        return Math.PI*radius*radius;
    }
}
