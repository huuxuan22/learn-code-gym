package model;

public class Motobike extends Vehicle{
    private int payload; // trọng tải

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    public Motobike(String controlPlate, String nameProduct, String yearManufacture, String orwer, int payload) {
        super(controlPlate, nameProduct, yearManufacture, orwer);
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Motobike{" +
                "payload=" + payload +
                ", controlPlate='" + controlPlate + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", yearManufacture='" + yearManufacture + '\'' +
                ", Orwer='" + Orwer + '\'' +
                "} " + super.toString();
    }

    @Override
    public String getInforToCSV() {
        return controlPlate + "," + nameProduct + ","+ yearManufacture + ","+Orwer+","+payload;
    }

}

