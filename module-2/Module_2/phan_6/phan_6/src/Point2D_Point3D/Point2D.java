package Point2D_Point3D;

import java.sql.Array;
import java.util.Scanner;

public class Point2D {
    protected float x;
    protected float y;
    protected Scanner sc;

    public Point2D() {
        Scanner sc= new Scanner(System.in);
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public void setXY(float x,float y){
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
        float [] arr= new float[2];
        arr[0] = x;
        arr[1] = y;
        return arr;
    }

    @Override
    public String toString() {
        return "Point2D(" +x+","+y+')';
    }
}
