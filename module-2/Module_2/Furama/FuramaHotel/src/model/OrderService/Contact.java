package model.OrderService;

import Repository.InterfaceRepository.IContactRepository;

import java.util.ArrayList;
import java.util.Date;

public class Contact {
    private String numberContact;
    private String idBooking;
    private int deposit;// tiền cọc
    private int totalAmount;// tổng tiền

    public String getNumberContact() {
        return numberContact;
    }

    public void setNumberContact(String numberContact) {
        this.numberContact = numberContact;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Contact(String numberContact, String idBooking, int deposit, int totalAmount) {
        this.numberContact = numberContact;
        this.idBooking = idBooking;
        this.deposit = deposit;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "numberContact='" + numberContact + '\'' +
                ", idBooking='" + idBooking + '\'' +
                ", deposit=" + deposit +
                ", totalAmount=" + totalAmount +
                '}';
    }
    public String getInforContactToTxt(){
        return numberContact+ ","+idBooking+ ","+deposit+ ","+totalAmount;
    }
}
