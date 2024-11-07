package Service.Interface;

import Repo.InterfaceRepository.IVehicleRepo;
import model.Struck;

import java.util.ArrayList;

public interface IStruckService<T> extends IVehicleService<T> {
    public void add();
    public void display();
    public void delete(String controlPlate);
    public boolean checkStruck(String id);
}
