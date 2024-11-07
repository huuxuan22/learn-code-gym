package service.impl;

import model.User;
import repo.IUserRepo;
import repo.impl.UserRepository;
import service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    private IUserRepo userDAO = new UserRepository();
    @Override
    public List<User> findAll() {
        try {
            return userDAO.selectAllUser();
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Override
    public boolean insertUser(User user) {
        try {
            return userDAO.insertUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean userUpdate(User user) {

        try {
            return userDAO.updateUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUser(int user) {
        try {
            return userDAO.deleteUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> searchUserById(int id) {
        try {
            return userDAO.searchUserById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> searchByName(String name) {
        return userDAO.selectByName(name);
    }

}
