package br.com.todolist.controller;

import br.com.todolist.model.Task;
import br.com.todolist.service.MyUserDetailService;
import br.com.todolist.service.TaskService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("tasks")
@Log4j2
@RequiredArgsConstructor
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @ApiOperation(value = "Listar todas as tarefas do sistema com opção de paginação - Somente o administrador do sistema tem esse poder.")
    @Secured({"ROLE_ADMIN"})
    @GetMapping
    public ResponseEntity<Page<Task>> listAllPageable(Pageable pageable) {
        return taskService.listAllPageable(pageable);
    }

    @ApiOperation(value = "Lista todas as tarefas de um usuário observando o perfil do mesmo.")
    @Secured({"ROLE_ADMIN", "ROLE_DEFAULT"})
    @GetMapping(path = "/all")
    public ResponseEntity<List<Task>> listAllByUser() {
        return taskService.listAllByUserAndEmail(getEmail());
    }

    @ApiOperation(value = "Busca tarefa de um usuário usando o id da tarefa como filtro observando o perfil do mesmo.")
    @Secured({"ROLE_ADMIN", "ROLE_DEFAULT"})
    @GetMapping(path = "/{id}")
    public ResponseEntity<Task> findById(@PathVariable long id) {
        return taskService.findByIdAndEmail(id, getEmail());
    }

    @ApiOperation(value = "Lista todas as tarefas de um usuário usando o status como filtro e observando o perfil do mesmo.")
    @Secured({"ROLE_ADMIN", "ROLE_DEFAULT"})
    @GetMapping(path = "/status/{status}")
    public ResponseEntity<List<Task>> listByStatus(@PathVariable String status) {
        return taskService.listByStatusAndEmail(status, getEmail());
    }


    @ApiOperation(value = "Deletar a tarefa pelo id da tarefa - Somente o administrador do sistema tem esse poder.")
    @Secured({"ROLE_ADMIN"})
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        return taskService.delete(id);
    }

    @ApiOperation(value = "Inserir uma tarefa nova.")
    @Secured({"ROLE_ADMIN", "ROLE_DEFAULT"})
    @PostMapping
    public ResponseEntity<Task> save(@RequestBody @Valid Task task) {
        return taskService.save(task);
    }

    @ApiOperation(value = "Atualizar a própria tarefa.")
    @Secured({"ROLE_ADMIN", "ROLE_DEFAULT"})
    @PutMapping
    public ResponseEntity<Task> update(@RequestBody @Valid Task task) {
        return taskService.update(task, getEmail());
    }

    private String getEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetailService.UserRepositoryDetail userRepositoryDetail = (MyUserDetailService.UserRepositoryDetail) authentication.getPrincipal();
        String email = userRepositoryDetail.getUsername();
        return email;
    }

}
