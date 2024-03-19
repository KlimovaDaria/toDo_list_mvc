package to_do_list.controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import to_do_list.entity.Task;
import to_do_list.entity.User;
import to_do_list.service.TaskService;
import to_do_list.service.UserService;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @RequestMapping("/")
    public String getAllUsers(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model){
        User user = new User();
        String name = user.getName();
        model.addAttribute("user", user);
        model.addAttribute("userName", name);
        return "user-info";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute(name = "user") User user,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return  "user-info";
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam(name = "userId") int id, Model model){
        User user = userService.getUser(id);
        String name = user.getName();
        model.addAttribute("user", user);
        model.addAttribute("userName", name);
        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam(name = "userId") int id, Model model){
        userService.deleteUser(id);
        return "redirect:/";
    }

    @RequestMapping("/allTasksByUser")
    public String getAllTasksByUser(@RequestParam(name = "userId") int id,
                                    @RequestParam(name = "userName") String name,
                                    Model model) {
        List<Task> allTasks = taskService.getAllTasks(id);
        model.addAttribute("allTasks", allTasks);
        model.addAttribute("userId", id);
        model.addAttribute("userName", name);
        return "all-tasks-by-user";
    }

    @RequestMapping("/addNewTaskByUser")
    public String addNewTaskByUser(@RequestParam(name = "userId") int id,
                                   @RequestParam(name = "userName") String name,
                                   Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("userId", id);
        model.addAttribute("userName", name);
        return "task-info";
    }

    @RequestMapping("/saveTask")
    public String saveTask(@ModelAttribute(name = "task") Task task,
                           @RequestParam(name = "userId") int id,
                           @RequestParam(name = "userName") String name,
                           Model model) {
        taskService.saveTask(task, id);
        return getAllTasksByUser(id, name, model);
    }

    @RequestMapping("/deleteTask")
    public String deleteTask(@RequestParam(name = "taskId") int id,
                             @RequestParam(name = "userId") int userId,
                             @RequestParam(name = "userName") String name,
                             Model model){
        taskService.deleteTask(id);
        return getAllTasksByUser(userId, name, model);
    }

    @RequestMapping("/updateTask")
    public String updateTask(@RequestParam(name = "taskId") int id,
                             @RequestParam(name = "userId") int userId,
                             @RequestParam(name = "userName") String name,
                             Model model){
        Task task = taskService.getTask(id);
        model.addAttribute("task", task);
        model.addAttribute("userId", userId);
        model.addAttribute("userName", name);
        return "task-info";
    }
}
