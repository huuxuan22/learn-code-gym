package DemSoLanXuatHien;

import java.security.Key;
import java.util.*;

public class DemSoLanXuatHien {
    private Map<String, String> tuDien = new HashMap<>();

    public DemSoLanXuatHien(Map<String, String> tuDien) {
        this.tuDien = tuDien;
    }

    public Map<String, String> getTuDien() {
        return tuDien;
    }

    public void setTuDien(Map<String, String> tuDien) {
        this.tuDien = tuDien;
    }

    // chuyển đổi hết thành chu thường
    public void convert(Set<String> setKeyTolower){
       for (String key : tuDien.keySet()){
           setKeyTolower.add(key.toLowerCase());
       }
    }
    public int demSoLanXuatHien(String tuKhoa){
        Set<String> setKey = new HashSet<>();
        convert(setKey);
        int dem = 0;
        for (String keys : setKey){
            if (keys.equals(tuKhoa)){
                dem++;
            }
        }
        return dem;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Map<String, String> tuDien = new HashMap<>();
        DemSoLanXuatHien dem = new DemSoLanXuatHien(tuDien);
        tuDien.put("hello","XinChao");
        tuDien.put("apple","Tao");
        tuDien.put("banana","CHuoi");
        System.out.println("Nhap vao tu kiem tra: ");
        String tuKhoa = sc.nextLine();
        if (dem.demSoLanXuatHien(tuKhoa.toLowerCase()) != 0)
            System.out.println(dem.demSoLanXuatHien(tuKhoa.toLowerCase()));
        else
            System.out.println("Khoong co trong tu dien");
    }
}
