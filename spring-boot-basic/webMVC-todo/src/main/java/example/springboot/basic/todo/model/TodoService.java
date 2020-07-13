package example.springboot.basic.todo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findAll() {
        return this.todoRepository.findAll();
    }

    public List<Todo> saveAll(List<Todo> todos) {
        return this.todoRepository.saveAll(todos);
    }
}
