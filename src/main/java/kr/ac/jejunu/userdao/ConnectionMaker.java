package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Kim on 2016-04-22.
 */
public interface ConnectionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}
