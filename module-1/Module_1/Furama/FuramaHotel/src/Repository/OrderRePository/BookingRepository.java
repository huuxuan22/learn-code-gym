package Repository.OrderRePository;

import Repository.FacilityRepository.FacilityRepository;
import Repository.InterfaceRepository.IBookingRepository;
import Repository.InterfaceRepository.IFacilityRepository;
import model.Facility.Facility;
import model.OrderService.Booking;

import java.text.ParseException;
import java.util.*;

public class BookingRepository implements IBookingRepository<Booking> {
    private static final TreeSet<Booking> bookingListTree = new TreeSet<>();
    private static final Queue<Booking> bookingListQueue = new LinkedList<>();
    private static final IFacilityRepository<Facility> facilityRepository = new FacilityRepository();


    @Override
    public TreeSet<Booking> getAllTreeBooking() {
        return bookingListTree;
    }

    @Override
    public LinkedHashMap<Facility, Integer> getAllLinkedHashMap() {
        return facilityRepository.getAllLinkedHashMap();
    }

    public static void addBooking(Booking booking){
        if (bookingListQueue.contains(booking)){
            System.out.println("Booking bạn nhập đã bị trùng lặp: mã Booking: "+ booking.getIdBooking());
        }else {
            bookingListTree.add(booking);
            bookingListQueue.add(booking);
            System.out.println("Booking đã được thêm thành công.");
        }
    }
    @Override
    public List<Booking> getAll() {
        return null;
    }

    @Override
    public void add(Booking item) {
        addBooking(item);
    }

    @Override
    public void update(ArrayList<Booking> listItem) {

    }

    @Override
    public void delete(String id) throws ParseException {

    }
}
