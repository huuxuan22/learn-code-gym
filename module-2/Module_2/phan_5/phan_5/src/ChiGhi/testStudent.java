package ChiGhi;

public class testStudent {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("tran duong huu xuan");
        student.setClasses("V01");
        System.out.println("Ho va ten: "+ student.getName());
        System.out.println("Lop: "+ student.getClasses());
    }
}
