package resizeable;

import java.util.Random;

public class Retangle implements resizeable{
    private double width;
    private double length;

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

    public Retangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public void Resizeable() {
        Random random = new Random();
        double parantlength = 1 + random.nextDouble()*99;
        double parantwidth = 1 + random.nextDouble()*99;
        this.length = this.length + this.length*parantlength/100;
        this.width = this.width + this.width*parantwidth/100;
    }
}
