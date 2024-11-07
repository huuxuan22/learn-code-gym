package Service.PersonService;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInputEmployeeCustomer {
    private static final String maNhanVien_REGEX = "NV-[0-9]{4}$";
    private static final Pattern maNhanVien_Patten = Pattern.compile(maNhanVien_REGEX);
    private static final String soCMND_REGEX = "[0-9]{10}$";
    private static final Pattern soCMND_Patten = Pattern.compile(soCMND_REGEX);
    private static final String sdt_REGEX = "0[0-9]{9}$";
    private static final Pattern sdt_Patten = Pattern.compile(sdt_REGEX);
    private static final String maKhachHang_REGEX = "KH-[0-9]{4}$";
    private static final Pattern maKhacHang_Patten = Pattern.compile(maKhachHang_REGEX);



    //  KIỂM TRA ID CỦA NHÂN VIÊN
    // Phương thức kiểm tra mã nhân viên có hợp lệ
    public static boolean checkIdEmployee(String ma){
        Matcher matcher = maNhanVien_Patten.matcher(ma);
        return matcher.matches();
    }

    public static String thayDoiTen(String hoTen) {
        // Tách chuỗi thành các từ
        String[] words = hoTen.split("\\s");

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


    // KIỂM TRA NGÀY SINH NHẬP VÀO CỦA NHÂN VIÊN HOẶC CỦA CUSTOMER
    public static boolean kiemTraNgaySinh(String ngaySinh){
        Period ageDifferent = Period.between(changeTime(ngaySinh), LocalDate.now());
        if (ageDifferent.getYears()>= 18){
            return true;
        }
        return false;
    }

    public static LocalDate changeTime(String ngaySinh){
                LocalDate date = null;
                boolean flagNgaySinh = true;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                date = LocalDate.parse(ngaySinh,formatter);
        return date;
    }


    // KIỂM TRA SỐ CHỨNG MINH NHÂN DÂN CỦA NHÂN VIÊN HOẶC CỦA KHÁCH HÀNG
    public static boolean checkSoCMND(String soCMND){
        Matcher matcher = soCMND_Patten.matcher(soCMND);
        return matcher.matches();
    }

    // KIỂM TRA SỐ ĐIỆN THOẠI NHẬP VÀO CÓ ĐÚNG HAY KHÔNG
    public static boolean checkSDT(String sdt){
        Matcher matcher = sdt_Patten.matcher(sdt);
        return matcher.matches();
    }

    // KIỂM TRA NHẬP MÃ KHÁCH HÀNG CÓ ĐÚNG HAY KHÔNG
    public static boolean checkIdCustomer(String idCustomer){
        Matcher matcher = maNhanVien_Patten.matcher(idCustomer);
        return matcher.matches();
    }
}
