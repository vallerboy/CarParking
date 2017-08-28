package pl.oskarpolak.model.dao.impl;

import pl.oskarpolak.Connector;
import pl.oskarpolak.model.User;
import pl.oskarpolak.model.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenovo on 28.08.2017.
 */
public class UserDaoImpl implements UserDao{

    private Connector connector = Connector.getInstance();

    @Override
    public boolean saveUser(User user) {
        PreparedStatement preparedStatement = connector.getNewPreparedStatement(
                "UPDATE user SET password = ?, lastname = ?, email = ?, number = ? WHERE name = ?;"
        );
        try {
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getNumber());
            preparedStatement.setString(5, user.getName());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUserByName(String name) {
        PreparedStatement preparedStatement = connector.getNewPreparedStatement(
                "SELECT * FROM user WHERE name = ?"
        );
        User user = new User();
        try {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            user.setEmail(resultSet.getString("email"));
            user.setName(name);
            user.setLastname(resultSet.getString("lastname"));
            user.setNumber(resultSet.getString("number"));
            user.setPassword(resultSet.getString("password"));

            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteUser(String name) {
        PreparedStatement preparedStatement = connector.getNewPreparedStatement(
                "DELETE FROM user WHERE name = ?"
        );
        try {
            preparedStatement.setString(1, name);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean createUser(User user) {
        PreparedStatement preparedStatement = connector.getNewPreparedStatement(
                "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?)"
        );
        try {
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getLastname());
            preparedStatement.setString(5, user.getNumber());
            preparedStatement.setString(6, user.getEmail());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isUserExist(String name) {
        PreparedStatement preparedStatement = connector.getNewPreparedStatement(
                "SELECT id FROM user WHERE name = ?"
        );
        try {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
