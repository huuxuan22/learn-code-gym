package ChiGhi;

public class Student {
    private String name;
    private String classes;
    Student(){
        this.name = "John";
        this.classes = "C02";
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setClasses(String classes){
        this.classes = classes;
    }
    public String getClasses(){
        return classes;
    }
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("tran duong huu xuan");
        student.setClasses("V01");
        System.out.println("Ho va ten: "+ student.getName());
        System.out.println("Lop: "+ student.getClasses());
    }
}
