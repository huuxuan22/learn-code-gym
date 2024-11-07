package repo;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IUserRepo {
    public boolean insertUser(User user) throws SQLException;
    public User selectUser(int id);
    public List<User> selectAllUser() throws ClassNotFoundException;
    public boolean deleteUser(int id) throws SQLException;
    public boolean updateUser(User user) throws SQLException;
    public List<User> searchUserById(int id) throws SQLException;
    public List<User> selectByName(String name);
}
