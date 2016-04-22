package kr.ac.jejunu.userdao;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        Long id = 1L;
        String name = "자바";
        String password = "11";

        User user = userDao.get(id);
        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(password, user.getPassword());
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        String name = "스프링";
        String password = "java";

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        Long id = userDao.add(user);

        User mUser = userDao.get(id);
        assertEquals(id, mUser.getId());
        assertEquals(name, mUser.getName());
        assertEquals(password, mUser.getPassword());
    }

}
