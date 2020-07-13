package example.springboot.basic.todo.model;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    List<TodoDTO> toTodoDTOs(List<Todo> todos);
    TodoDTO toTodoDTO(Todo todo);
    Todo toTodo(TodoDTO todoDTO);
    List<Todo> toTodos(List<TodoDTO> todoDTOs);
}
