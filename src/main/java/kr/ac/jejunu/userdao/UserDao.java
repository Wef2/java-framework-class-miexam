package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public void setConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public User get(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = connectionMaker.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if(resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public Long add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Long id = null;
        try {
            connection = connectionMaker.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO user(name, password) values(?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
            id = getLastInsertId(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
           throw e;
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }

    private Long getLastInsertId(Connection connection) throws SQLException {
        PreparedStatement preparedStatement2 = null;
        ResultSet resultSet = null;
        Long id = null;
        try {
            preparedStatement2 = connection.prepareStatement("SELECT last_insert_id()");
            resultSet = preparedStatement2.executeQuery();
            resultSet.next();
            id = resultSet.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if(resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement2 != null) {
                    preparedStatement2.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }


}
