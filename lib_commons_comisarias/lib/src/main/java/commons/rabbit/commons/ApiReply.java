package commons.rabbit.commons;

import commons.exception.ErrorReply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ApiReply<T>{
    private T data;
    private ErrorReply error;
}
