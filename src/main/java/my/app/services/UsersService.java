package my.app.services;

import my.app.models.User;

import java.util.List;

public interface UsersService {
    public List<User> getUsers();
    public User getUser(int id);
    public void createUser(User user);
    public void deleteUser(int id);
    public void updateUser(User user);
}
