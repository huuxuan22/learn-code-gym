package ArrayList;

import java.util.Scanner;

public class MyLinkedList<E> {
    private Node head;
    private int numNode;

    public MyLinkedList() {
        this.numNode = 0;
    }

    public void add(int index, E element){ // thêm phần tử tại vị trí bất kì
        Node temp = head;
        Node holder;
        for (int i=0;i<index && temp.next != null;i++){
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNode++;
    }
    // thêm phần tử vào đầu danh sách
    public void addFirst(E element){
        Node temp = new Node(element);
        if (head == null){
            head = temp;
        }else {
            temp.next = head;
            head = temp;
        }
        numNode++;
    }

    // xóa phần tử tại vị trí nhất định
    public E remove(int index){
        Node temp = head;
        for (int i=0;i<index && temp.next != null;i++){
            temp = temp.next;
        }
        temp = temp.next.next;
        return (E) head;
    }

    // nhập vào 1 phần tử và duyệt có phần tử trong danh sách hay không sau đó xóa
    public boolean remove(Object element){
        if (head == null){
            return false;
        }
        Node temp = head;
        Node previous = null;
        while (temp != null && !temp.data.equals(element)){
            previous = temp;
            temp = temp.next;
        }
        // không tìm thấy đối tượng
        if (temp == null){
            return false;
        }
        //tìm thấy đối tượng ở đầu danh sách
        if (previous == null){
            head = head.next;
        }else {
            previous.next = temp.next;
        }
        numNode--;
        return true;
    }

    // kích thước của danh sách
    public int size(){
        Node temp = head;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    // thêm phần tử vào cuối
    public void addLast(E element){
        Node temp= head;
        while(temp != null){
            temp = temp.next;
        }
        Node tempLast = new Node(element);
        tempLast.next = null;
        temp.next = tempLast;
        numNode++;
    }

    // sao chép 1 danh sách giống y chang
    public MyLinkedList<E> clone(){
        if (head == null){
            return  new MyLinkedList<E>();
        }
        MyLinkedList<E> copyList = new MyLinkedList<E>();
        Node temp = head;
        copyList.head = new Node(temp.data);
        Node tmp = copyList.head;
        while (temp!= null){
            temp=temp.next;
            tmp.next = new Node(temp.data);
            tmp = tmp.next;
        }
        return  copyList;
    }

    // duyệt xem có phần tử trong danh sách hay không
    public boolean contains(E element) {
        Node temp = head;
        while (temp != null){
            if (temp.data.equals(element)){
                return true;
            }
        }
        return false;
    }

    // trả về vị trí xuất hiện của phần tử nhập vào
    public int indexOf(E o){
        Node temp = head;
        for (int i=0;i<numNode && temp != null;i++){
            if(temp.data.equals(o)){
                return i;
            }
            temp = temp.next;
        }

        return 0;
    }

    // trả về phần tử thứ i
    public E get(int i){
        Node temp = head;
        MyLinkedList<E> List = new MyLinkedList<E>();
        if (i > numNode || i < 0){
            return (E) List;
        }
        for (int j=0;j<=i;j++){
            temp = temp.next;
            if (j == i){
                List.head = new Node(temp.data);
            }
        }
        return (E) List;
    }

    // trả về phần tử đầu tiên trong danh sách
    public E getFisrt(){
        MyLinkedList<E> listFisrt = new MyLinkedList<E>();
        Node temp = head;
        listFisrt.head = new Node(temp.data);
        return (E) listFisrt;
    }

    // trả về phần tử cuối cùng trong danh sách
    public E getlast(){
        MyLinkedList<E> listLast = new MyLinkedList<>();
        Node temp = head;
        while(temp != null){
            temp = temp.next;
        }
        listLast.head = new Node(temp.data);
        return (E) listLast;
    }

    // xóa danh sách liên kết
    public void clear(){
        head.next = null;
    }
    private class Node{
        private Node next;
        private Object data;
        public Node(Object data){

            this.data = data;
        }
        public Object getData(){

            return data;
        }
    }

    // hiển thị danh sách
    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.getData() + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        MyLinkedList<Integer> danhSach = new MyLinkedList<>();
        Scanner sc = new Scanner(System.in);

        int luaChon;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Thêm phần tử tại một chỉ số cụ thể");
            System.out.println("2. Thêm phần tử vào đầu danh sách");
            System.out.println("3. Xóa phần tử tại một chỉ số cụ thể");
            System.out.println("4. Xóa phần tử");
            System.out.println("5. Hiển thị danh sách");
            System.out.println("6. Sao chép danh sách");
            System.out.println("7. Kiểm tra sự tồn tại của một phần tử");
            System.out.println("8. Lấy vị trí của một phần tử");
            System.out.println("9. Lấy phần tử tại một chỉ số cụ thể");
            System.out.println("10. Lấy phần tử đầu tiên");
            System.out.println("11. Lấy phần tử cuối cùng");
            System.out.println("12. Hiển thị kích thước của danh sách");
            System.out.println("13. Thêm phần tử vào cuối danh sách");
            System.out.println("14. Xóa toàn bộ danh sách");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = sc.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập chỉ số: ");
                    int chiSo = sc.nextInt();
                    System.out.print("Nhập phần tử: ");
                    int phanTu = sc.nextInt();
                    danhSach.add(chiSo, phanTu);
                    break;
                case 2:
                    System.out.print("Nhập phần tử để thêm vào đầu danh sách: ");
                    int phanTuThemVaoDau = sc.nextInt();
                    danhSach.addFirst(phanTuThemVaoDau);
                    break;
                case 3:
                    System.out.print("Nhập chỉ số để xóa: ");
                    int chiSoXoa = sc.nextInt();
                    danhSach.remove(chiSoXoa);
                    break;
                case 4:
                    System.out.print("Nhập phần tử để xóa: ");
                    int phanTuXoa = sc.nextInt();
                    danhSach.remove(phanTuXoa);
                    break;
                case 5:
                    System.out.println("Hiển thị danh sách:");
                    danhSach.display();
                    break;
                case 6:
                    MyLinkedList<Integer> danhSachSaoChep = danhSach.clone();
                    System.out.println("Danh sách sao chép:");
                    danhSachSaoChep.display();
                    break;
                case 7:
                    System.out.print("Nhập phần tử để kiểm tra: ");
                    int phanTuKiemTra = sc.nextInt();
                    System.out.println("Phần tử tồn tại: " + danhSach.contains(phanTuKiemTra));
                    break;
                case 8:
                    System.out.print("Nhập phần tử để lấy vị trí: ");
                    int phanTuLayViTri = sc.nextInt();
                    System.out.println("Vị trí: " + danhSach.indexOf(phanTuLayViTri));
                    break;
                case 9:
                    System.out.print("Nhập chỉ số để lấy phần tử: ");
                    int chiSoLayPhanTu = sc.nextInt();
                    System.out.println("Phần tử: " + danhSach.get(chiSoLayPhanTu));
                    break;
                case 10:
                    System.out.println("Phần tử đầu tiên: " + danhSach.getFisrt());
                    break;
                case 11:
                    System.out.println("Phần tử cuối cùng: " + danhSach.getlast());
                    break;
                case 12:
                    System.out.println("Kích thước của danh sách: " + danhSach.size());
                    break;
                case 13:
                    System.out.print("Nhập phần tử để thêm vào cuối danh sách: ");
                    int phanTuThemVaoCuoi = sc.nextInt();
                    danhSach.addLast(phanTuThemVaoCuoi);
                    break;
                case 14:
                    danhSach.clear();
                    System.out.println("Danh sách đã được xóa.");
                    break;
            }
        } while (luaChon != 0);
    }
}
