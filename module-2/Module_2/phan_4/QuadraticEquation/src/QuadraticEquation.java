// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class QuadraticEquation {
    private double a,b,c;
    public void setA (double a){
        this.a = a;
    }
    public double getA(){
        return a;
    }

    public void setB(double b){
        this.b = b;
    }
    public double getB (){
        return b;
    }

    public void setC (double c){
        this.c =c;
    }
    public double getC (){
        return c;
    }
    QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // phuong thuc tra ve delta cua phuong trinh
    public double getDiscriminant(){
        return b*b - 4*a*c;
    }

    // phuong thuc tra ve nghiem x1 neu delta > 0
    public double getRoot1(){
        return (-b+Math.pow((-b+Math.pow((b*b-4*a*c),0.5)),0.5))/2*a;
    }

    // phuong thuc tra ve nghiem x2 neu delta > 0
    public double getRoot2(){
        return (-b+Math.pow((-b+Math.pow((b*b-4*a*c),0.5)),0.5))/2*a;
    }
}