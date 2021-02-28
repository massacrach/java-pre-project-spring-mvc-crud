package my.app.dao;

import my.app.models.User;

import java.util.List;

public interface UsersDao {
    public List<User> getUsers();
    public User getUser(long id);
    public void createUser(User user);
    public void deleteUser(long id);
    public void updateUser(User user);
}
