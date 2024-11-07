package Repository.InterfaceRepository;

import model.Facility.Facility;

import java.util.LinkedHashMap;

public interface IFacilityRepository<T> extends Repository<T> {
    LinkedHashMap<Facility,Integer> getAllLinkedHashMap();
}
