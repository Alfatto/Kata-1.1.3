package jm.task.core.jdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    private static final UserService user = new UserServiceImpl();
    public static void main(String[] args) throws SQLException {


        User[] users = {new User("Ivan", "Ivanov", (byte)23),
                new User("Alex", "Petrov", (byte)20),
                new User("Victor", "Sergeev", (byte)42),
                new User("Sergei", "Victorov", (byte)15)};
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        for (User user : users ) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.printf("User с именем – %s добавлен в базу данных\n",user.getName());

        }
        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.shutdown();


        /*UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Альфат1", "Им1", (byte) 49);
        userService.saveUser("Альфат2", "Им2", (byte) 30);
        userService.saveUser("Альфат3", "Им3", (byte) 20);
        userService.saveUser("Альфат4", "Им4", (byte) 15);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.createUsersTable();*/

       /* UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Альфат1", "Им1", (byte) 49);
        userDaoHibernate.saveUser("Альфат2", "Им2", (byte) 30);
        userDaoHibernate.saveUser("Альфат3", "Им3", (byte) 20);
        userDaoHibernate.saveUser("Альфат4", "Им4", (byte) 15);
        userDaoHibernate.getAllUsers();
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();*/


/*

        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        user.saveUser("Альфат1", "Им", (byte) 39);
        user.saveUser("Альфат2", "Имa", (byte) 15);
        user.saveUser("Альфат3", "Иsм", (byte) 20);
        user.saveUser("Альфат4", "Имx", (byte) 30);
        userDaoJDBC.getAllUsers();
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();*/
    }
}
