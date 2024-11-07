package model;

public abstract class Vehicle {
    protected String controlPlate; // biển kiểm soát
    protected String nameProduct; // tên nhà sản xuất
    protected String yearManufacture; // năm sản xuất
    protected String Orwer; // chủ sở hữu

    public String getControlPlate() {
        return controlPlate;
    }

    public void setControlPlate(String controlPlate) {
        this.controlPlate = controlPlate;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(String yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public String getOrwer() {
        return Orwer;
    }

    public void setOrwer(String orwer) {
        Orwer = orwer;
    }

    public Vehicle(String controlPlate, String nameProduct, String yearManufacture, String orwer) {
        this.controlPlate = controlPlate;
        this.nameProduct = nameProduct;
        this.yearManufacture = yearManufacture;
        Orwer = orwer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "controlPlate='" + controlPlate + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", yearManufacture='" + yearManufacture + '\'' +
                ", Orwer='" + Orwer + '\'' +
                '}';
    }
    public abstract String getInforToCSV();
}
