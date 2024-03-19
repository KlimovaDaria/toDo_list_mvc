package to_do_list.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import to_do_list.entity.Task;
import to_do_list.entity.User;
import to_do_list.service.UserService;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserService userService;

    @Override
    public List<Task> getAllTasks(int userId) {
        Session session = sessionFactory.getCurrentSession();
        User user = userService.getUser(userId);
        return user.getTasks();
    }

    @Override
    public Task getTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Task.class, id);
    }

    @Override
    public void saveTask(Task task, int userId) {
        Session session = sessionFactory.getCurrentSession();
        User user = userService.getUser(userId);
        user.addTaskToUser(task);
        session.merge(task);
    }

    @Override
    public void deleteTask(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Task> query = session.createQuery("delete from Task where id = :taskId");
        query.setParameter("taskId", id);
        query.executeUpdate();
    }
}
