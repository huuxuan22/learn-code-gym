package model;

public class Car extends Vehicle{
    private int seatNumber; // số chỗ ngồi
    private String vehicleType;// kiểu xe

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Car(String controlPlate, String nameProduct, String yearManufacture, String orwer, int seatNumber, String vehicleType) {
        super(controlPlate, nameProduct, yearManufacture, orwer);
        this.seatNumber = seatNumber;
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seatNumber=" + seatNumber +
                ", vehicleType='" + vehicleType + '\'' +
                ", controlPlate='" + controlPlate + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", yearManufacture='" + yearManufacture + '\'' +
                ", Orwer='" + Orwer + '\'' +
                "} " + super.toString();
    }

    @Override
    public String getInforToCSV() {
        return  controlPlate + "," + nameProduct + ","+ yearManufacture + ","+Orwer+","+ seatNumber+"," + vehicleType;
    }

}
