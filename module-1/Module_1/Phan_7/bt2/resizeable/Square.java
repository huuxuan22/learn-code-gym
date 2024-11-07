package resizeable;

import java.util.Random;

public class Square implements resizeable{
    private double edge;

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public Square(double edge) {
        this.edge = edge;
    }

    @Override
    public void Resizeable() {
        Random random = new Random();
        double parantEdge = 1+ random.nextDouble()*99;
        this.edge = this.edge + this.edge*parantEdge/100;
    }
}
