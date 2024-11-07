package model.Class;

import java.util.Scanner;

public class ProductOut extends  Product{
    @Override
    public long priceForSale() {
        return price+extraOut + (long)(0.1 * extraOut);
    }
    protected long extraOut;

    public long getExtraOut() {
        return extraOut;
    }

    public void setExtraOut(long extraOut) {
        this.extraOut = extraOut;
    }

    public ProductOut(int id, String name, TypeProduct type, long price, long extraOut) {
        super(id, name, type, price);
        this.extraOut = extraOut;
    }
    public ProductOut(){
        super();
    }
//    public void input(){
//        Scanner sc = new Scanner(System.in);
//        super.input();
//        System.out.println("extraOut: ");
//        this.extraOut = Long.parseLong(sc.nextLine());
//    }
}
