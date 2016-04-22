package kr.ac.jejunu.userdao;

/**
 * Created by Kim on 2016-04-22.
 */
public class DaoFactory {

    public UserDao getUserDao(){
        UserDao userDao = new UserDao(new SimpleConnectionMaker());
        return userDao;
    }
}
