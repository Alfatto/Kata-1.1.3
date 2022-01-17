package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDaoJDBCImpl implements UserDao {
    public static Logger logger = Logger.getLogger(UserDao.class.getName());

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {//сoздать таблицу пользователей
        logger.info("метод createUsersTable(); вызван");
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS user1.user(\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `lastName` VARCHAR(45) NULL,\n" +
                    "  `age` TINYINT(3) NULL,\n" +
                    "  PRIMARY KEY (`id`))");
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("метод createUsersTable(); завершил работу");
    }

    public void dropUsersTable() {//удалить таблицу пользователей
        logger.info("метод dropUsersTable(); вызван");
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS user1.user");
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("метод dropUsersTable(); завершил работу");
    }

    public void saveUser(String name, String lastName, byte age) {//сохранить пользователя
        logger.info("метод saveUser(); вызван");
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO user1.user (name,lastName, age) VALUES (?,?,?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("метод saveUser(); завершил работу");
    }

    public void removeUserById(long id) {//удалить пользователя
        logger.info("removeUserById(); вызван");
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM user1.user WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("User удален");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("метод removeUserById(); завершил работу");
    }

    public List<User> getAllUsers() {//получить всех user  из БД
        logger.info("метод getAllUsers(); вызван");
        List<User> allUsers = new ArrayList<>();
        try (Connection connection = Util.getConnection();
             ResultSet resultSet = connection.createStatement()
                     .executeQuery("SELECT id, name, lastName, age FROM user1.user")) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                allUsers.add(user);
            }
            System.out.println("Пользователи получены :");
            for (User allUser : allUsers) {
                System.out.println(allUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        logger.info("метод getAllUsers(); завершил работу");
        return allUsers;
    }

    public void cleanUsersTable() {//очистить таблицу пользователя
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("TRUNCATE TABLE user1.user");
            System.out.println("Таблица очищена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
