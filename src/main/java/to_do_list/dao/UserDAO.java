package to_do_list.dao;

import to_do_list.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getUser(int id);
    public void saveUser(User user);
    public void deleteUser(int id);
}
