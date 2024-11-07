package Repository.OrderRePository;

import Repository.InterfaceRepository.IContactRepository;
import model.OrderService.Booking;
import model.OrderService.Contact;

import java.text.ParseException;
import java.util.*;

public class ContactRepository implements IContactRepository<Contact> {
    private static final ArrayList<Contact> contactList = new ArrayList<>();
    private static final BookingRepository bookingRepository = new BookingRepository();

    public static void addContact(Contact contact){
        contactList.add(contact);
    }

    @Override
    public List<Contact> getAll() {
        return contactList;
    }

    @Override
    public void add(Contact item) {
        addContact(item);
    }

    @Override
    public void update(ArrayList<Contact> listItem) {

    }

    @Override
    public void delete(String id) throws ParseException {

    }

    @Override
    public TreeSet<Booking> getAllTreBooing() {
        return bookingRepository.getAllTreeBooking();
    }
}
