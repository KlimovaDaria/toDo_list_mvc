package to_do_list.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import to_do_list.dao.TaskDAO;
import to_do_list.entity.Task;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskDAO taskDAO;

    @Override
    @Transactional
    public List<Task> getAllTasks(int userId) {
        return taskDAO.getAllTasks(userId);
    }

    @Override
    @Transactional
    public Task getTask(int id) {
        return taskDAO.getTask(id);
    }

    @Override
    @Transactional
    public void saveTask(Task task, int userId) {
        taskDAO.saveTask(task, userId);
    }

    @Override
    @Transactional
    public void deleteTask(int id) {
        taskDAO.deleteTask(id);
    }
}
