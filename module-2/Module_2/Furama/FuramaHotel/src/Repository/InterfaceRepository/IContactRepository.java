package Repository.InterfaceRepository;

import model.OrderService.Booking;
import model.OrderService.Contact;

import java.util.ArrayList;
import java.util.TreeSet;

public interface IContactRepository<Contact> extends Repository<Contact>{
    TreeSet<Booking> getAllTreBooing();
}
