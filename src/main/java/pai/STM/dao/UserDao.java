package pai.STM.dao;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pai.STM.model.User;
import pai.STM.repository.TaskRepository;
import pai.STM.repository.UserRepository;

import java.util.List;

@Service
public class UserDao {
    @Autowired
    UserRepository repo;
    @Autowired
    TaskDao taskDao;

    // a
    public User save(User user) {
        return repo.save(user);
    }

    // b
    public List<User> findAll() {
        return repo.findAll();
    }

    // c
    public User findOne(int id) {
        return repo.findById(id).orElse(null);
    }

    // c
    public User findOne(String email) {
        return repo.findFirstByEmail(email).orElse(null);
    }

    // d
    public User changeStatus(int id) {
        User user = repo.getOne(id);
        user.setStatus(!user.isStatus());
        return repo.save(user);
    }

    // e
    public void deleteById(int id) {
        taskDao.deleteByUser(findOne(id));
        repo.deleteById(id);
    }
}

