package my.app.dao;

import my.app.models.User;

import java.util.List;

public interface UsersDao {
    public List<User> getUsers();
    public User getUser(int id);
    public void createUser(User user);
    public void deleteUser(int id);
    public void updateUser(User user);
}
