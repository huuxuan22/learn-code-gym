package Repo.InterfaceRepository;

import java.util.ArrayList;

public interface IVehicleRepo<T> {
    ArrayList<T> getAll();
    void add(T t);
    ArrayList<String> stringList();
}
