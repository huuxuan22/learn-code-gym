package Repository.InterfaceRepository;

import model.Facility.Facility;
import model.OrderService.Booking;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.TreeSet;

public interface IBookingRepository<Booking> extends Repository<Booking>{
    TreeSet<Booking> getAllTreeBooking();
    LinkedHashMap<Facility,Integer> getAllLinkedHashMap();
}
