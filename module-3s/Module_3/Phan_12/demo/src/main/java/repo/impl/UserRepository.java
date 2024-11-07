package repo.impl;

import model.User;
import repo.BaseRepository;
import repo.IUserRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepo {
    private final String SELECT_ALL = "select * from users";
    private final String INSERT_INTO = "insert into users(id,`name`,email,country)\n" + "values (?,?,?,?)";
    private final String UPDATE_USERS = "update users \n" +
            "set country = ?,email = ?,`name`  = ? \n" +
            "where id = ?;";
    private final String DELETE_USER = "delete  from users where id = ?;";
    private final String SEARCH_BY_ID = "select * from users where id = ?";
    private final String SELECT_BY_NAME = "select * from users where `name` like concat('%',?,'%')";
    @Override
    public boolean insertUser(User user) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
//        connection.setAutoCommit(false);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getCountry());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e){
            return false;
        } finally {
            try {
                connection.close();
            }catch (SQLException e ){
                throw  new RuntimeException();
            }
        }
    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUser() throws ClassNotFoundException {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement statement = null;
        ResultSet resultset = null;
        if (connection != null) {
                try {
                statement = connection.prepareStatement(SELECT_ALL);
                resultset = statement.executeQuery();
                while (resultset.next()) {
                    int id = (resultset.getInt("id"));
                    String name = (resultset.getString("name"));
                    String email = (resultset.getString("email"));
                    String country = (resultset.getString("country"));
                        userList.add(new User(id,name,email,country));
                }
                return userList;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                   throw new RuntimeException();
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER)){
//            connection.setAutoCommit(false);
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS);) {
            connection.setAutoCommit(false);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getCountry());
            statement.setString(3, user.getName());
            statement.setInt(4,user.getId());
            rowUpdated = statement.executeUpdate() > 0;
            connection.commit();
        }
        return rowUpdated;
    }

    @Override
    public List<User> searchUserById(int id) throws SQLException {
        List<User> userList = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(SEARCH_BY_ID)){
//            connection.setAutoCommit(false);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int idUser  = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(idUser,name,email,country);
                userList.add(user);
            }
        }
        return userList;
    }

    @Override
    public List<User> selectByName(String name) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
      if (connection != null){
          try {
              statement = connection.prepareStatement(SELECT_BY_NAME);
              statement.setString(1,name);
              resultSet = statement.executeQuery();
              while (resultSet.next()){
                  int id = resultSet.getInt("id");
                  String names = resultSet.getString("name");
                  String email = resultSet.getString("email");
                  String country = resultSet.getString("country");

                  User user = new User(id,names,email,country);
                  userList.add(user);
              }
              return userList;
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }finally {
              try {
                  if (connection != null) {
                      connection.close();
                  }
                  if (statement != null) {
                      statement.close();
                  }
                  if (resultSet != null) {
                      resultSet.close();
                  }
              } catch (SQLException e) {
                  return null;
              }
          }
      }
      return null;
    }


}
