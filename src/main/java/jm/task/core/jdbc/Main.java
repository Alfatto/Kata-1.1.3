package jm.task.core.jdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;

public class Main {
    private static final UserService user = new UserServiceImpl();
    public static void main(String[] args) throws SQLException {








        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        user.saveUser("Альфат1", "Им", (byte) 39);
        user.saveUser("Альфат2", "Имa", (byte) 15);
        user.saveUser("Альфат3", "Иsм", (byte) 20);
        user.saveUser("Альфат4", "Имx", (byte) 30);
        userDaoJDBC.getAllUsers();
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();







          /*  try {
                driver = new FabricMySQLDriver();
            } catch (SQLException ex){
                System.out.println("произошла ошибка при создании драйвера ");
                return;
            }

            try {
                DriverManager.registerDriver(driver);
            } catch (SQLException ex){
                System.out.println("не удалось зарегистрировать драйвер ");
                return;
            }


            try {
                connection = DriverManager.getConnection(URL,USER,PASS);
                System.out.println("cod......");
                Statement statement = connection.createStatement();
                //1. создаем таблицу
                //!! если создана то выдает ошибку!!!!
                statement.executeUpdate(CREATE_TABLE_QUERY);
                logger.info("таблицу создали....");

                //2. добавляем 4 пользователя
                //Пока только один добавляется
                //int s = statement.executeUpdate("update user1.userscopy set username   value (василий)");
                int s = statement.executeUpdate("INSERT INTO userscopy(username)" + " VALUES('Aleks')");
                logger.info("добавили " + s);

                //3 получение всех user-ов из БД и вывод в консоль
                //работает
                String SQL = "SELECT * FROM userscopy";
                ResultSet resultSet = statement.executeQuery(SQL);

                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String  username = resultSet.getString(2);


                    System.out.println("id: " + id);
                    System.out.println("Name: " + username);
                    System.out.println("===================\n");
                }


                //4 и 5 Работает
                //4. очистка таблици
                String QQERTY = "TRUNCATE TABLE user1.userscopy";
                statement.executeUpdate(QQERTY);
                logger.info("очистили...");

                //5. удаление таблицы !!! выдает исключение если базы нет
                String SQLdel = "DROP TABLE user1.animal";
                statement.executeUpdate(SQLdel);
                logger.info("Table successfully removed...");

                //6. удалить пользователя

                int rows = statement.executeUpdate("DELETE FROM user1.address WHERE id=3");
                System.out.printf("%d row(s) deleted", rows);




            } catch (SQLException ex){
                System.out.println("не сконеутилось " + ex);
                return;
            }

            finally {
                if (connection != null){
                    connection.close();
                }
            }*/
        // реализуйте алгоритм здесь
            /*
        User представляет из себя сущность с полями:

Long id
String name
String lastName
Byte age

Требования к классам приложения:

 Классы dao/service должны реализовывать соответствующие интерфейсы
 Класс dao должен иметь конструктор пустой/по умолчанию
 Все поля должны быть private
 service переиспользует методы dao
 Обработка всех исключений, связанных с работой с базой данных должна находиться в dao
 Класс Util должен содержать логику настройки соединения с базой данных

Необходимые операции:

 Создание таблицы для User(ов) – не должно приводить к исключению, если такая таблица уже существует
 Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует
 Очистка содержания таблицы
 Добавление User в таблицу
 Удаление User из таблицы ( по id )
 Получение всех User(ов) из таблицы

Алгоритм работы приложения:

         В методе main класса Main должны происходить следующие операции:

 Создание таблицы User(ов)
 Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
 Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
 Очистка таблицы User(ов)
 Удаление таблицы
         */

    }
}
