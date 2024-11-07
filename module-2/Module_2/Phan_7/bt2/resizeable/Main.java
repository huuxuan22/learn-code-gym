package resizeable;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        System.out.println("ban kinh cua hinh tron truoc khi sua: "+ circle.getRadius());
        circle.Resizeable();
        System.out.println("ban kinh cua hinh tron sau khi tang: "+ circle.getRadius());
        Retangle retangle = new Retangle(3,4);
        System.out.println("chieu dai va chieu rong trc khi sua: "+ retangle.getLength() + "," + retangle.getWidth());
        retangle.Resizeable();
        System.out.println("chieu dai va chieu rong sau khi sua: "+ retangle.getLength()+","+ retangle.getWidth());
    }
}
