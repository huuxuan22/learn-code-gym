package ArrayListt;

import java.util.Scanner;

public class MyList<E> {
    protected int size = 0;
    static final int Default_CAPACITY = 10;
    protected Object[] element;

    MyList() {
        this.size = 0;
        element = new Object[Default_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity > element.length)
            element = new Object[capacity];
    }

    void add(int index, E e) {
        if (size == element.length) {
            Object[] newArray = new Object[element.length * 2];
            for (int i = 0; i < element.length; i++) {
                newArray[i] = element[i];
            }
            element = newArray;
        }

        for (int i = size - 1; i >= index; i--) {
            element[i + 1] = element[i];
        }
        element[index] = e;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        E removedElement = (E) element[index];

        for (int i = index; i < size - 1; i++) {
            element[i] = element[i + 1];
        }

        element[size - 1] = null;
        size--;

        return removedElement;
    }

    public int size() {
        return size;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (element[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (element[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        add(size, e);
        return element[size - 1].equals(e);
    }

    public E get(int i) {
        return (E) element[i];
    }

    public void clear() {
        element = new Object[Default_CAPACITY];
        size = 0;
    }

    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();

        // Thêm phần tử vào danh sách
        myList.add(10);
        myList.add(20);
        myList.add(30);

        // In danh sách
        System.out.println("Danh sach sau khi them phan tu:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // Kiểm tra và in kích thước danh sách
        System.out.println("Kich thuoc danh sach: " + myList.size());

        // Kiểm tra xem danh sách có chứa phần tử 20 không
        System.out.println("Danh sach co chua 20: " + myList.contains(20));

        // Xóa phần tử tại vị trí 1
        myList.remove(1);

        // In danh sách sau khi xóa
        System.out.println("Danh sach sau khi xoa phan tu:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // Kiểm tra và in kích thước danh sách sau khi xóa
        System.out.println("Kich thuoc danh sach sau khi xoa: " + myList.size());

        // Kiểm tra xem danh sách có chứa phần tử 20 sau khi xóa không
        System.out.println("Danh sach co chua 20 sau khi xoa: " + myList.contains(20));

        // Xóa tất cả phần tử và in danh sách
        myList.clear();
        System.out.println("Danh sach sau khi clear:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
}
