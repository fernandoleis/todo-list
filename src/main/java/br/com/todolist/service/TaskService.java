package br.com.todolist.service;

import br.com.todolist.model.Task;
import br.com.todolist.model.TaskStatus;
import br.com.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public ResponseEntity<Page<Task>> listAllPageable(Pageable pageable) {
        return ResponseEntity.ok(taskRepository.findAll(pageable));
    }

    public ResponseEntity<List<Task>> listAllByUserAndEmail(String email) {
        return ResponseEntity.ok(taskRepository.findByUserAndEmail(email));
    }

    public ResponseEntity<Task> findByIdAndEmail(long id, String email) {
        Task task = taskRepository.findByIdAndEmail(id, email);
        if (!Objects.isNull(task)) {
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<Task>> listByStatusAndEmail(String status, String email) {
        List<Task> tasks = taskRepository.findByUserStatusAndEmail(status.toUpperCase(), email);
        if (!tasks.isEmpty()) {
            return ResponseEntity.ok(tasks);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> delete(long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            taskRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    public ResponseEntity<Task> save(Task task) {
        Task taskCreated = taskRepository.save(task);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(taskCreated.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(taskCreated);
    }

    public ResponseEntity<Task> update(Task task, String email) {
        Task taskSearched = taskRepository.findByIdAndEmail(task.getId(), email);
        if (!Objects.isNull(taskSearched)) {
            taskSearched.setDate(task.getDate());
            taskSearched.setDescription(task.getDescription());
            taskSearched.setStatus(TaskStatus.valueOf(task.getStatus().toString().toUpperCase()));
            taskSearched.setSummary(task.getSummary());
            taskRepository.save(taskSearched);
            return ResponseEntity.ok(taskSearched);
        }
        return ResponseEntity.notFound().build();
    }

}
