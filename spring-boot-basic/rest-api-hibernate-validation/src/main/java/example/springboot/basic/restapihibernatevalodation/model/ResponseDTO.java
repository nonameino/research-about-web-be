package example.springboot.basic.restapihibernatevalodation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO<T> {
    private  String status;

    @Builder.Default
    private String message = "Success!";

    private T body;
}
