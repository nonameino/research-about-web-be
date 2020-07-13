package example.springboot.basic.todo.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TodoDTO {

    @NotNull
    @Size(min = 2, max = 100)
    private String title;

    private boolean completed;
}
