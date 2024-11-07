package Repo.IRepository;

import java.util.ArrayList;

public interface IRepo<T> {
    ArrayList<T> getAll();
    void add(T t);
}
