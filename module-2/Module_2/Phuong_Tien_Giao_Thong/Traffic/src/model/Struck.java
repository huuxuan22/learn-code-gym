package model;

public class Struck extends Vehicle{
    private int wattage; // công suất

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    public Struck(String controlPlate, String nameProduct, String yearManufacture, String orwer, int wattage) {
        super(controlPlate, nameProduct, yearManufacture, orwer);
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Struck{" +
                "wattage=" + wattage +
                ", controlPlate='" + controlPlate + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", yearManufacture='" + yearManufacture + '\'' +
                ", Orwer='" + Orwer + '\'' +
                "} " + super.toString();
    }

    @Override
    public String getInforToCSV() {
        return controlPlate + "," + nameProduct + ","+ yearManufacture + ","+Orwer+","+ wattage;
    }
}
