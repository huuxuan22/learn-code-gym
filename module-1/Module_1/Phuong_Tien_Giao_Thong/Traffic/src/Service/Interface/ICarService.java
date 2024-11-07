package Service.Interface;

import Repo.InterfaceRepository.IVehicleRepo;

import java.util.ArrayList;

public interface ICarService<T>  extends IVehicleRepo<T> {
    public void add();
    public void display();
    public void delete(String controlPlate);
    public boolean checkCar(String id);
}
