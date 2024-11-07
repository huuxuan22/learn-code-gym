package Repository.PersonRepository;

import Repository.InterfaceRepository.IEmployeeRepository;
import Util.DateTimeFurama;
import Util.WriteAndReadFile_txt;
import model.Person.Employee;

import java.time.LocalDate;
import java.util.*;

public class EmployeeRepository implements IEmployeeRepository<Employee> {
    private static final String EMPLOYEE_PATH_FILE = "D:\\Module_2\\Furama\\FuramaHotel\\src\\File\\Employee.TXT";

    @Override
    public List<Employee> getAll()  {
        List<String> stringList = new ArrayList<>();
        ArrayList<Employee> listEmployee = new ArrayList<>();
        stringList = WriteAndReadFile_txt.readFileTXT(EMPLOYEE_PATH_FILE);
        String [] array = null;
        for (String line: stringList){
            array = line.split(",");
            //String hoten, Date ngaySinh, String gioiTinh, String soCMND, String sdt, String email, String trinhDo, String viTri, int salary, String maNhanVien
            Employee employee = new Employee(array[0], array[1],array[2],array[3],array[4],array[5],array[6],(array[7]),Integer.parseInt(array[8]),array[9]);
            listEmployee.add(employee);
        }

        return listEmployee;

    }

    @Override
    public void add(Employee employee) {
        List<String> listString = new ArrayList<>();
        listString.add(employee.getInforEmployyeToTxT());
        WriteAndReadFile_txt.WriteArrayListToTXT(EMPLOYEE_PATH_FILE,listString,true);
    }

    @Override
    public void update(ArrayList<Employee> listEmployee) {
        ArrayList<String> listString = new ArrayList<>();
        for (Employee employee : listEmployee){
            listString.add(employee.getInforEmployyeToTxT());
        }
        WriteAndReadFile_txt.WriteArrayListToTXT(EMPLOYEE_PATH_FILE,listString,false);
    }

    @Override
    public void delete(String id) {
        ArrayList<String> listString = new ArrayList<>();
        List<Employee> listCustomer =  getAll();
        for (int i=0;i<listCustomer.size();i++){
            if (!(listCustomer.get(i).equals(id))){
                listString.add(listCustomer.get(i).getInforEmployyeToTxT());
            }
        }
        WriteAndReadFile_txt.WriteArrayListToTXT(EMPLOYEE_PATH_FILE,listString,false);
    }
}
