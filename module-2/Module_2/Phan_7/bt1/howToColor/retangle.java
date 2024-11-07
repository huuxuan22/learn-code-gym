package howToColor;

public class retangle extends Shape {
    private double width;
    private double length;

    public retangle() {
        super();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public retangle(String color, double width, double length) {
        super(Integer.parseInt(color));
        this.width = width;
        this.length = length;
    }
    public double getArea(){
        return this.length*this.width;
    }
}
