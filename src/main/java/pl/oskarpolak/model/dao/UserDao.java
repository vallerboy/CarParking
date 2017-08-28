package pl.oskarpolak.model.dao;

import pl.oskarpolak.model.User;

/**
 * Created by Lenovo on 28.08.2017.
 */
public interface UserDao {
    boolean saveUser(User user);
    User getUserByName(String name);
    boolean deleteUser(String name);
    boolean createUser(User user);
    boolean isUserExist(String name);
}
