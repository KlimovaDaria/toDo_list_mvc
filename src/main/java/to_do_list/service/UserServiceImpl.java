package to_do_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import to_do_list.dao.UserDAO;
import to_do_list.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
