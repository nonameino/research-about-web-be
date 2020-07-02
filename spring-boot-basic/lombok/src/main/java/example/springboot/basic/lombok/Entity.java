package example.springboot.basic.lombok;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class Entity {
    @NonNull
    private Integer id;

    private String name;
}
