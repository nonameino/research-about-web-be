package example.springboot.basic.lombok;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Entity {
    private Integer id;
    private String name;
}
