package pai.STM.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pai.STM.model.Status;
import pai.STM.model.Task;
import pai.STM.model.Type;
import pai.STM.model.User;
import pai.STM.repository.TaskRepository;

import java.util.List;

@Service
public class TaskDao {
    @Autowired
    TaskRepository repo;

    UserDao userDao;

    public Task save(Task task) {
        return repo.save(task);
    }

    public List<Task> findAll() {
        return repo.findAll();
    }

    public Task findOne(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Task> findAll(String title) {
        return repo.findAllByTitle(title);
    }

    public List<Task> findAll(Status status) {
        return repo.findAllByStatus(status);
    }

    public List<Task> findAll(Type type) {
        return repo.findAllByType(type);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

    public List<Task> findAllSortedByDate() {
        return repo.findAllByOrderByDateAddedDesc();
    }

    public void changeStatus(int id) {
        Task task = repo.getOne(id);
        switch (task.getStatus()) {
            case NEW:
                task.setStatus(Status.INPROGRESS);
                break;
            case INPROGRESS:
                task.setStatus(Status.DONE);
                break;
            case DONE:
                task.setStatus(Status.NEW);
                break;
        }
        repo.save(task);
    }

    public void deleteByUser(User user) {
        repo.deleteByUser(user);
    }


}
