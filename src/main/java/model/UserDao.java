package model;

import model.UserProfile;

public interface UserDao {

    void addUser(UserProfile user);

    UserProfile getUserById(long id);

    UserProfile getUserByLogin(String login);
}
