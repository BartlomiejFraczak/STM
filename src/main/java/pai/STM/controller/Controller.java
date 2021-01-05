package pai.STM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pai.STM.dao.TaskDao;
import pai.STM.dao.UserDao;
import pai.STM.model.Status;
import pai.STM.model.Task;
import pai.STM.model.Type;
import pai.STM.model.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {
    @Autowired
    UserDao userDao;
    @Autowired
    TaskDao taskDao;

    // a
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public User addUser(@RequestParam String name,
                        @RequestParam String lastName,
                        @RequestParam String email,
                        @RequestParam String password) {
        return userDao.save(new User(name, lastName, email, password));
    }

    // b
    @RequestMapping(value = "/user/get/all", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    // c
    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public User getUser(@RequestParam String idOrEmail) {
        User user = userDao.findOne(idOrEmail);
        if (user == null) user = userDao.findOne(Integer.parseInt(idOrEmail));
        return user;
    }

    // d
    @RequestMapping(value = "/user/changestatus", method = RequestMethod.PATCH)
    public User changeUserStatus(@RequestParam int id) {
        return userDao.changeStatus(id);
    }

    // e
    @RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam int id) {
        userDao.deleteById(id);
    }

    // f
    @RequestMapping(value = "/task/add", method = RequestMethod.POST) // petla jakas sie tworzy ??
    public Task addTask(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("type") Type type,
            @RequestParam("status") Status status,
            @RequestParam("user") User user) {
        return taskDao.save(new Task(title, description, type, status, user));
    }

    // g
    @RequestMapping(value = "/task/get/sorted", method = RequestMethod.GET)
    public List<Task> getTasksSorted() {
        return taskDao.findAllSortedByDate();
    }

    // h
    @RequestMapping(value = "/task/get", method = RequestMethod.GET)
    public List<Task> getTasksBy(@RequestParam String titleStatusType) {
        List<Task> tasks = taskDao.findAll(titleStatusType);
        if (tasks.isEmpty()) {
            // czy istnieje taki status enum:
            if (Arrays.stream(Status.values()).anyMatch((s) -> s.name().equals(titleStatusType))) {
                tasks = taskDao.findAll(Status.valueOf(titleStatusType));
            } else {
                // czy istnieje taki type enum:
                if (Arrays.stream(Type.values()).anyMatch((t) -> t.name().equals(titleStatusType))) {
                    tasks = taskDao.findAll(Type.valueOf(titleStatusType));
                }
            }
        }
        return tasks;
    }

    // i
    @RequestMapping(value = "/task/changestatus", method = RequestMethod.PATCH)
    public void changeTaskStatus(@RequestParam int id) {
        taskDao.changeStatus(id);
    }

    // j
    @RequestMapping(value = "/task/delete", method = RequestMethod.DELETE)
    public void deleteTask(@RequestParam int id) {
        taskDao.deleteById(id);
    }

}