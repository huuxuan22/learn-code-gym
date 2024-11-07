package model.Interface;

public interface Isort {
    void sortByID(); // sắp xếp tăng dần theo id
    void sortByID(boolean reserve);// sắp xếp theo thằng reserve nếu là true thì nó sẽ giảm dần
                                    // ngược lại nếu false thì sẽ là giảm dần
}
