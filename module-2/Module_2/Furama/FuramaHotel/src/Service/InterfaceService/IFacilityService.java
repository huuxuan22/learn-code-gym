package Service.InterfaceService;

import model.Facility.Facility;
import model.Facility.House;
import model.Facility.Room;
import model.Facility.Villa;

import java.util.ArrayList;
import java.util.List;

public interface IFacilityService<T> extends Service{
    void display();
    void addNewHouse();
    void addNewVilla();
    void addNewRoom();
}
