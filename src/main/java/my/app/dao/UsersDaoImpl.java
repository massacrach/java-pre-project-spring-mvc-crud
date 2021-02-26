package my.app.dao;

import my.app.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsersDaoImpl implements UsersDao {
    private List<User> users = new ArrayList<>();

    public UsersDaoImpl() {
        users.add(new User(1, "Dude", "Qwe"));
        users.add(new User(2, "Dude1", "Qwe1"));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);

    }

    @Override
    public void createUser(User user) {
        user.setId(3);
        users.add(user);
    }

    @Override
    public void deleteUser(int id) {
        users = users.stream()
                .filter(u -> u.getId() != id)
                .collect(Collectors.toList());
    }

    @Override
    public void updateUser(User user) {
        users = users.stream()
                .map(u -> {
                    if (u.getId() == user.getId()) {
                        return user;
                    }

                    return u;
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
