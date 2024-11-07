package resizeable;
import java.util.Random;
public class Circle implements resizeable{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void Resizeable(){
        Random random = new Random();
        double parant = 1+ random.nextDouble()*99;
         this. radius = this.radius + this.radius*(parant)/100;
    }
}
