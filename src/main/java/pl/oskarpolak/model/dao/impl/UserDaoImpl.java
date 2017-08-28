package pl.oskarpolak.model.dao.impl;

import pl.oskarpolak.Connector;
import pl.oskarpolak.model.User;
import pl.oskarpolak.model.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        return null;
    }

    @Override
    public boolean deleteUser(String name) {
        return false;
    }

    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public boolean isUserExist(String name) {
        return false;
    }
}
