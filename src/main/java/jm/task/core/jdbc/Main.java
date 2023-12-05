package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserDao userDao = new UserDaoHibernateImpl();


        userDao.createUsersTable();


        userDao.saveUser("A", "B", (byte) 1);
        userDao.saveUser("B", "B", (byte) 2);
        userDao.saveUser("C", "C", (byte) 3);
        userDao.saveUser("D", "D", (byte) 4);


        List<User> userList = userDao.getAllUsers();
        for (User u : userList) {
            System.out.println("User c именем " + u.getName() + " добавлен в базу данных");
        }


        userDao.cleanUsersTable();


        userDao.dropUsersTable();
    }
}
