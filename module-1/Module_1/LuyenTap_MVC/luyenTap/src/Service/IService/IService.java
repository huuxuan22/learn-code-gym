package Service.IService;

import java.util.ArrayList;

public interface IService<T>{
    ArrayList<T> getAll();
    void add(T t);
}
