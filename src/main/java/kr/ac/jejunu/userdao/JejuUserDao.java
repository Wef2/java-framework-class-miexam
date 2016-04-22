package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Kim on 2016-04-22.
 */
public class JejuUserDao extends UserDao {
    @Override
    Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root123");
    }
}
