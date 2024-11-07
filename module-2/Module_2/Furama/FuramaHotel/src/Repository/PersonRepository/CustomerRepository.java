package Repository.PersonRepository;

import Repository.InterfaceRepository.ICustomerRepository;
import Util.DateTimeFurama;
import Util.WriteAndReadFile_txt;
import model.Person.Customer;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository<Customer> {

    private static final String CUSTOMER_PATH_FILE = "D:\\Module_2\\Furama\\FuramaHotel\\src\\File\\Customer.TXT";


    @Override
    public ArrayList<Customer> getAll() {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<Customer> listCustomer = new ArrayList<>();
        stringList=  WriteAndReadFile_txt.readFileTXT(CUSTOMER_PATH_FILE);
        String [] array = null;
        for (String line: stringList){
            array = line.split(",");
            //String hoten, Date ngaySinh, String gioiTinh, String soCMND, String sdt, String email, String trinhDo, String viTri, int salary, String maKhachHang
            Customer customer = new Customer(array[0], array[1],array[2],array[3],array[4],array[5],array[6],(array[7]),Integer.parseInt(array[8]),array[9]);
            listCustomer.add(customer);
        }

        return listCustomer;
    }


    @Override
    public void add(Customer customer) {
        List<String> listString = new ArrayList<>();
        listString.add(customer.getInforCustomerToTxt());
        WriteAndReadFile_txt.WriteArrayListToTXT(CUSTOMER_PATH_FILE,listString,true);
    }



    @Override
    public void update(ArrayList<Customer> listCustomer) {
        List<String> listString = new ArrayList<>();
        for (Customer customer : listCustomer){
            listString.add(customer.getInforCustomerToTxt());
        }
        WriteAndReadFile_txt.WriteArrayListToTXT(CUSTOMER_PATH_FILE,listString,false);
    }

    @Override
    public void delete(String id) throws ParseException {
        List<String> listString = new ArrayList<>();
        List<Customer> listCustomer = (ArrayList<Customer>) getAll();
        for (int i=0;i<listCustomer.size();i++){
            if (!(listCustomer.get(i).equals(id))){
                listString.add(listCustomer.get(i).getInforCustomerToTxt());
            }
        }
        WriteAndReadFile_txt.WriteArrayListToTXT(CUSTOMER_PATH_FILE,listString,false);
    }
}
