package howToColor;

public class Shape {
    protected String color;
    public Shape(){
        super();
    }
    public Shape(int color) {
        this.color = String.valueOf(color);
    }

    public void draw() {
        System.out.println("Drawing a " + color + " shape");
    }
}
