package Service.InterfaceService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface Service<T> {
    void add();
    void update(String id) ;
    void delete(String id);
    List<T> getAll();
    void display();
}
