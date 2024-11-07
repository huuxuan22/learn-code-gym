package TimKiemNhiPhan;

import java.util.*;

public class TimKiemNhiPhan {

//    public static int timKiem(ArrayList<Integer> danhSach,int intSearch,int left,int right){
//         int mid = left + (right-left)/2;
//        if (danhSach.get(mid) == intSearch){
//            return mid;
//        }else if(danhSach.get(mid) < intSearch){
//            return timKiem(danhSach,intSearch,left,mid-1);
//        }else if (danhSach.get(mid) > intSearch){
//            return timKiem(danhSach,intSearch,mid+1,right);
//        }
//        return -1;
//    }
public static int timKiem(ArrayList<Integer> danhSach, int intSearch, int left, int right) {
    if(left >= right){
        return -1;
    } else {
        int mid = left + (right - left) / 2;
        if (danhSach.get(mid).hashCode() == intSearch) {
            return mid;
        } else if (danhSach.get(mid) > intSearch) {
            return timKiem(danhSach, intSearch, left, mid - 1);
        } else {
            return timKiem(danhSach, intSearch, mid + 1, right);
        }
    }
}
    public static void sort(ArrayList<Integer> danhSach){
        for (int i = 0; i < danhSach.size() - 1; i++) {
            for (int j = i + 1; j < danhSach.size() - i-1; j++) {
                if (danhSach.get(j) > danhSach.get(i)) {
                    int temp = danhSach.get(j);
                    danhSach.set(j, danhSach.get(j+1));
                    danhSach.set(j+1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Bạn muốn nhập mảng có độ dài là bao nhiêu: ");
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> danhSach = new ArrayList<>(n);
        Random random = new Random();
        for (int i=0;i<n;i++){
            int soNguyen = random.nextInt(100);
            // kiểm tra số nhập vào có giống số trc hay không
            if (!danhSach.contains(soNguyen)){
                danhSach.add(soNguyen);
            }
        }
        int left = 0;
        int right = n -1;
        Collections.sort(danhSach);
        System.out.println("Danh sách của bạn sau khi nhập là: "+ danhSach);
        System.out.println("Nhap vao so nguyen muon tim kiem: ");
        int intSearch = sc.nextInt();
        int timKiem = timKiem(danhSach,intSearch,left,right);
        if (timKiem != -1){
            System.out.println(timKiem);
        }else {
            System.out.println("Không tìm thấy trong danh sách");
        }
    }
}
