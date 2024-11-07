package Repository.OrderRePository;

import model.OrderService.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        int startDay = o1.getDayBooking().compareTo(o2.getDayBooking());
        if(startDay == 0){
            return o1.getNgayHetThue().compareTo(o2.getNgayHetThue());
        }
        return startDay;
    }
}
