package model.Class;

public abstract class Product {
    protected int id;
    protected String  name;
    protected TypeProduct type;
    protected long price;

    public Product(int id, String name, TypeProduct type, long price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }
    public Product(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeProduct getType() {
        return type;
    }

    public void setType(TypeProduct type) {
        this.type = type;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
    //    public void input(){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap thong tin cho San Pham: ");
//        System.out.println("Nhap id: ");
//        TypeProductManager typeProductManager = new TypeProductManager();
//        do {
//            this.id = Integer.parseInt(sc.nextLine());
//        }while(typeProductManager.search(id)!=null);
//        System.out.println("Name: ");
//        this.name = sc.nextLine();
//        System.out.println("Nhap thông tin cho loai san pham: ");
//        type.input();
//        System.out.println("Gia cua san pham: ");
//    }
    public abstract long priceForSale();

}