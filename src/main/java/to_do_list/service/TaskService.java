package to_do_list.service;


import to_do_list.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks(int userId);
    Task getTask(int id);
    void saveTask(Task task, int userId);
    void deleteTask(int id);
}
