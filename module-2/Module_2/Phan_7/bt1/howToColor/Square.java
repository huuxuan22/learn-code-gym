gpackage howToColor;

public class Square extends Shape implements colorAble{
    private double edge;

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public Square() {
        this.edge = edge;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
    public double getArea(){
        return this.edge*this.edge;
    }
}
