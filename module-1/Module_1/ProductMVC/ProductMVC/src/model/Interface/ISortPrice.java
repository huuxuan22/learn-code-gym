package model.Interface;

public interface ISortPrice {
    void sortByPrice();//dùng có sắp xếp tên theo priceForSale
    void sortByPrice(boolean reseve);//nếu reverse bằng true thì sắp xếp giảm dần, ngược lại sắp xếp tăng giảm theo priceForSale
}

