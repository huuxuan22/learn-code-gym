package Service.InterfaceService;

import model.OrderService.Booking;
import model.OrderService.Contact;

import java.util.ArrayList;
import java.util.TreeSet;

public interface IContactService extends Service{
    TreeSet<Booking> contactTree();
}
