package Service.FacilityServvice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInputFacilityService {
    private static final String maDichVuVilla_REGEX = "SVVL-[0-9]{4}$";
    private static final Pattern maDichVuVilla_PATTERN = Pattern.compile(maDichVuVilla_REGEX);
    private static final String maDicVuHouse_REGEX = "SVHO-[0-9]{4}$";
    private static final Pattern maDichVuHouse_PATTERN = Pattern.compile(maDicVuHouse_REGEX);
    private static final String maDichVuRoom_REGEX = "SVRO-[0-9]{4}$";
    private static final Pattern maDichVuRoom_PATTERN = Pattern.compile(maDichVuRoom_REGEX);

    public static boolean checkIDInputRoom(String idRoom){
        Matcher matcher = maDichVuRoom_PATTERN.matcher(idRoom);
        return matcher.matches();
    }
    public static boolean checkIdInputHouse(String idHouse){
        Matcher matcher = maDichVuHouse_PATTERN.matcher(idHouse);
        return matcher.matches();
    }
    public static boolean checkIdInputVilla(String idVilla){
        Matcher matcher = maDichVuVilla_PATTERN.matcher(idVilla);
        return  matcher.matches();
    }

    public static String characterConversion(String tenDichVu){
        // Tách chuỗi thành các từ
        String[] words = tenDichVu.split("\\s");

        // Xử lý từng từ để viết hoa chữ cái đầu
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {  // Đảm bảo từ không rỗng
                // Viết hoa chữ cái đầu của từ và thêm vào kết quả
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return result.toString().trim();
    }

    public static boolean checkNumber(int number){
        if (number > 30){
            return true;
        }
        return false;
    }

    public static String standardizedRetal(String kieuThue){
        return kieuThue.replace(" ","_");
    }

    public static String standardizedRoom(String tieuChuanPhong){
        return tieuChuanPhong.replace(" ","-");
    }
}
