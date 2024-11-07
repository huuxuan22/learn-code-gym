package MoveablePoint;

public class MoveablePoint extends Point{
    private float xspeed;
    private float yspeed;

    public float getXspeed() {
        return xspeed;
    }

    public void setXspeed(float xspeed) {
        this.xspeed = xspeed;
    }

    public float getYspeed() {
        return yspeed;
    }

    public void setYspeed(float yspeed) {
        this.yspeed = yspeed;
    }
    public MoveablePoint(){
        super();
    }

    public MoveablePoint(float xspeed, float yspeed) {
        this.xspeed = xspeed;
        this.yspeed = yspeed;
    }

    public MoveablePoint(float x, float y, float xspeed, float yspeed) {
        super(x, y);
        this.xspeed = xspeed;
        this.yspeed = yspeed;
    }
    public float[] getSpeed(){
        float[] arr = new float[2];
        arr[0] = this.xspeed;
        arr[1] = this.yspeed;
        return  arr;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")"+",speed=("+xspeed+","+yspeed+")";
    }
    MoveablePoint move(){
        x +=xspeed;
        y += yspeed;
        return this;
    }
}
