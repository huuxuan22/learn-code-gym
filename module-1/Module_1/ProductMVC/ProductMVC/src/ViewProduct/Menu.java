package ViewProduct;

import ControllerProduct.ProductManagerController;
import ServiceProduct.ProductManagerService;
import ServiceProduct.TypeProductManagerService;
import model.Class.Product;
import model.Class.TypeProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManagerService productManagerService = new ProductManagerService();
        TypeProductManagerService typeProductManagerService = new TypeProductManagerService();
        System.out.println(
                "1. Quản lí loại sản phẩm\n" +
                        "    1.1. Xem thông tin loại sản phẩm\n" +
                        "    1.2. Tạo loại sản phẩm\n" +
                        "    1.3. Tìm kiếm loại sản phẩm\n" +
                        "        1.3.1. Tìm kiếm theo id\n" +
                        "        1.3.2. Tìm kiếm theo tên loại sản phẩm\n" +
                        "    1.4. Sắp xếp loại sản phẩm\n" +
                        "        1.4.1. Sắp xếp tăng dần theo id\n" +
                        "        1.4.2. Sắp xếp giảm dần theo id\n" +
                        "        1.4.3. Sắp xếp giảm dần theo số lượng sản phẩm có loại sản phẩm đó.\n" +
                        "    1.5. Đưa ra danh sách sản phẩm dựa vào TypeProduct\n" +
                        "    1.6. Xoá loại sản phẩm\n" +
                        "    1.7. Thoát quản lí sản phẩm\n" +
                        "2. Quản lí sản phẩm\n" +
                        "    2.1. Xem thông tin sản phẩm\n" +
                        "        2.1.1. Xem danh sách tất cả sản phẩm\n" +
                        "        2.1.2. Xem danh sách sản phẩm nội địa\n" +
                        "        2.1.3. Xem danh sách sản phẩm nhập khẩu\n" +
                        "        2.1.4. Xem những sản phẩm có giá bán ra lớn hơn 100000\n" +
                        "    2.2. Tạo sản phẩm\n" +
                        "        2.2.1. Tạo sản phẩm nội địa\n" +
                        "        2.2.2. Tạo sản phẩm nhập khẩu\n" +
                        "    2.3. Tìm kiếm sản phẩm\n" +
                        "        2.3.1. Tìm kiếm theo id\n" +
                        "        2.3.2. Tìm kiếm theo tên\n" +
                        "    2.4. Sắp xếp sản phẩm\n" +
                        "        2.4.1. Sắp xếp tăng dần theo id\n" +
                        "        2.4.2. Sắp xếp giảm dần theo id\n" +
                        "        2.4.3. Sắp xếp tăng dần theo giá bán ra\n" +
                        "        2.4.4. Sắp xếp giảm dần theo giá bán ra\n" +
                        "    2.5. Xoá sản phẩm\n" +
                        "    2.6. Thoát quản lí sản phẩm\n" +
                        "3. Thoát chương trình");
            }

        }


