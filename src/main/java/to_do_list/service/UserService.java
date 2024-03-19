package to_do_list.service;

import to_do_list.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(int id);
    void saveUser(User user);
    void deleteUser(int id);
}
