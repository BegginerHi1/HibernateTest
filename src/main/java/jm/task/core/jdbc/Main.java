package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


import java.util.List;

public class Main {

    private static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {


        userService.createUsersTable();


        List<User> userList = List.of(new User("A", "B", (byte) 1),
                new User("B", "B", (byte) 2),
                new User("C", "C", (byte) 3),
                new User("D", "D", (byte) 4));
        for (User u : userList) {
            userService.saveUser(u.getName(),u.getLastName(),u.getAge());
            System.out.println("User c именем " + u.getName() + " добавлен в базу данных");
        }


        List<User> userList1 = userService.getAllUsers();
        for (User u : userList1) {
            System.out.println(u);
        }


        userService.cleanUsersTable();


        userService.dropUsersTable();


        Util.closeSessionFactory();
    }
}
