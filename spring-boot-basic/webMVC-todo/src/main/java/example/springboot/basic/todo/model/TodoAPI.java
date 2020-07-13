package example.springboot.basic.todo.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
@Slf4j
public class TodoAPI {
    private final TodoService todoService;
    private final TodoMapper todoMapper;

    @Autowired
    public TodoAPI(final TodoService todoService, final TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO>> findAll() {
        return ResponseEntity.ok(todoMapper.toTodoDTOs(todoService.findAll()));
    }

    @PostMapping
    public ResponseEntity<List<TodoDTO>> saveAll(@Valid @RequestBody List<TodoDTO> todoDTOs) {
        log.info(todoDTOs.toString());
        todoService.saveAll(todoMapper.toTodos(todoDTOs));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(todoDTOs);
    }
}
