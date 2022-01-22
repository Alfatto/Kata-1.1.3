package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    //private UserDao userDaoMy = new UserDaoJDBCImpl();
    private  UserDao userDaoMy = new UserDaoHibernateImpl();

    public void createUsersTable() throws SQLException {
        userDaoMy.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoMy.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoMy.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoMy.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoMy.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoMy.cleanUsersTable();
    }
}
