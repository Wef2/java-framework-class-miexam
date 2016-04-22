package kr.ac.jejunu.userdao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kim on 2016-04-22.
 */

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao(){
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker(){
        return new SimpleConnectionMaker();
    }
}
