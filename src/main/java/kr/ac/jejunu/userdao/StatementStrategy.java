package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Kim on 2016-04-22.
 */
public interface StatementStrategy {

    PreparedStatement makeStatement(Connection connection) throws SQLException;
}
