package my.app.services;

import my.app.dao.UsersDao;
import my.app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao;

    @Autowired
    @Qualifier("UsersDaoMysqlImpl")
    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public List<User> getUsers() {
        return usersDao.getUsers();
    }

    @Override
    public User getUser(long id) {
        return usersDao.getUser(id);
    }

    @Override
    public void createUser(User user) {
        usersDao.createUser(user);
    }

    @Override
    public void deleteUser(long id) {
        usersDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        usersDao.updateUser(user);
    }
}
