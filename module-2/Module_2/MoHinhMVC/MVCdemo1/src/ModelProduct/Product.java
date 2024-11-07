package ModelProduct;

public class Product {
    private String id;
    private String Name;
    private int gia;
    private String danhGia;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public Product(String id, String name, int gia, String danhGia) {
        this.id = id;
        Name = name;
        this.gia = gia;
        this.danhGia = danhGia;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", gia=" + gia +
                ", danhGia='" + danhGia + '\'' +
                '}';
    }
}
