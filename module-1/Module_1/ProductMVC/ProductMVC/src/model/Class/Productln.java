package model.Class;

public class Productln extends Product {
    @Override
    public long priceForSale(){
        return price + extraln;
    }
    protected long extraln;

    public long getExtraln() {
        return extraln;
    }

    public void setExtraln(long extraln) {
        this.extraln = extraln;
    }

    public Productln(int id, String name, TypeProduct type, long price, long extraln) {
        super(id, name, type, price);
        this.extraln = extraln;
    }
    public Productln(){
        super();
    }
}
