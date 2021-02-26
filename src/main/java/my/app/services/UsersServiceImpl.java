package my.app.services;

import my.app.dao.UsersDao;
import my.app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao;

    @Autowired
    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public List<User> getUsers() {
        return usersDao.getUsers();
    }

    @Override
    public User getUser(int id) {
        return usersDao.getUser(id);
    }

    @Override
    public void createUser(User user) {
        usersDao.createUser(user);
    }

    @Override
    public void deleteUser(int id) {
        usersDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        usersDao.updateUser(user);
    }
}
