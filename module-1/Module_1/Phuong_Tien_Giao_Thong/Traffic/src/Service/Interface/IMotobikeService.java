package Service.Interface;

import java.util.ArrayList;

public interface IMotobikeService<T> extends IVehicleService<T>{
    public void add();
    public void display();
    public void delete(String controlPlate);
    public boolean checkMotobike(String id);
}
