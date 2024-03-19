package to_do_list.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import to_do_list.entity.Task;
import to_do_list.entity.User;
import to_do_list.service.TaskService;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private TaskService taskService;
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> allUsers = session.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }

    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(user);
    }

    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<Task> tasks = session.get(User.class, id).getTasks();
        if (tasks!=null){
            for (Task task: tasks){
                taskService.deleteTask(task.getId());
            }
        }
        Query<User> query = session.createQuery("delete from User where id=:userID");
        query.setParameter("userID", id);
        query.executeUpdate();
    }
}
