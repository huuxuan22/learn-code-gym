package phan_6;

public class Cylinder extends Circle{
    private double height;


    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public Cylinder(double radius, String color,double height) {
        super(radius, color);
        this.height = height;
    }
    public double Area(){
        return 3.14*radius*radius;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}';
    }
}
