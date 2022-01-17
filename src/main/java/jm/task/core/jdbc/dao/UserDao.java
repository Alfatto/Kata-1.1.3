package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //сoздать таблицу пользователей
    void createUsersTable() throws SQLException;

    void dropUsersTable();//удалить таблицу пользователей

    void saveUser(String name, String lastName, byte age);//сохранить пользователя

    void removeUserById(long id);//удалить пользователя

    List<User> getAllUsers();//получить всех user  из БД

    void cleanUsersTable();//очистить таблицу пользователя
}
