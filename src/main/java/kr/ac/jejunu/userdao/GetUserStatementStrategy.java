package kr.ac.jejunu.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Kim on 2016-04-22.
 */
public class GetUserStatementStrategy implements StatementStrategy {

    private Long id;

    GetUserStatementStrategy(Long id){
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
