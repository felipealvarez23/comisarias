package co.com.efalvare.model.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ApiError extends Exception {
    private String title;
    private String code;
    private String description;
    public ApiError(String title, String code, String description) {
        super(description);
        this.description = description;
        this.title = title;
        this.code = code;
    }
}
