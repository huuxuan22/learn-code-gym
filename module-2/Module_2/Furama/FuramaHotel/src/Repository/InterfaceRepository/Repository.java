package Repository.InterfaceRepository;

import model.Facility.Facility;
import model.Facility.House;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface Repository<T> {
     List<T> getAll() ;
     void add(T item);
     void update(ArrayList<T> listItem);
     void delete(String id) throws ParseException;

}
