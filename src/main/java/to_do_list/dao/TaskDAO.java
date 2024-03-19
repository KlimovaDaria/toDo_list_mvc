package to_do_list.dao;


import to_do_list.entity.Task;

import java.util.List;

public interface TaskDAO {
    public List<Task> getAllTasks(int userId);
    public Task getTask(int id);
    public void saveTask(Task task, int userId);
    public void deleteTask(int id);
}
