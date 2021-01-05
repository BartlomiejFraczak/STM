package pai.STM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pai.STM.model.Status;
import pai.STM.model.Task;
import pai.STM.model.Type;
import pai.STM.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findAllByOrderByDateAddedDesc();

    List<Task> findAllByTitle(String title);

    List<Task> findAllByStatus(Status status);

    List<Task> findAllByType(Type type);

    @Transactional
    @Modifying
    @Query("delete from Task t where t.user=:user")
    void deleteByUser(@Param("user") User user);
}
