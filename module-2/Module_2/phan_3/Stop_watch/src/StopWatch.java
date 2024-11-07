
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Random;
public class StopWatch {
    private long startTime,endTime;

    public void setStartTime(long startTime){
        this.startTime = startTime;
    }
    public long getStartTime(){
        return startTime;
    }
    public void setEndTime(long endTime){
        this.endTime = endTime;
    }
    public long getEndTime(){
        return endTime;
    }
    public StopWatch(){
        this.startTime = System.currentTimeMillis();
    }
    public void start(){
        startTime = System.currentTimeMillis();
    }
    public void stop(){
        endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return endTime-startTime;
    }

    // phuong thuc xap xep theo thu tu tang dan;
    public static void sapXep(int [] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int [] arr = new int[100000];
        Random random = new Random();
        for (int i=0;i<100;i++){
            arr[i] = random.nextInt();
        }
        StopWatch time = new StopWatch();
        time.start();
        sapXep(arr);
        time.stop();
        System.out.println("thoi gian de thuc hien chuong trinh tren la: "+ time.getElapsedTime()+ "ms");
    }
}