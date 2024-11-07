package service;

import model.User;

import java.util.List;

public interface IUserService {
    public List<User> findAll();
    public boolean  insertUser(User user);

    boolean userUpdate(User user);

    public boolean deleteUser(int id);
    public List<User> searchUserById(int id);
    public List<User> searchByName(String name);
}
