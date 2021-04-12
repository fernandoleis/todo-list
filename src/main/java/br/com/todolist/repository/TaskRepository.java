package br.com.todolist.repository;

import br.com.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("select t from Task t where t.id = :id and t.user.id = (select u.id from User u where u.email like concat('%', :email ,'%') ) order by t.status desc")
    Task findByIdAndEmail(@Param("id") Long id, @Param("email") String email);

    @Query("select t from Task t where t.user.id = (select u.id from User u where u.email like concat('%', :email ,'%') ) and t.status like concat('%', :status ,'%') order by t.status desc")
    List<Task> findByUserStatusAndEmail(@Param("status") String status, @Param("email") String email);

    @Query("select t from Task t where t.user.id = (select u.id from User u where u.email like concat('%', :email ,'%') ) order by t.status desc")
    List<Task> findByUserAndEmail(@Param("email") String email);

}
