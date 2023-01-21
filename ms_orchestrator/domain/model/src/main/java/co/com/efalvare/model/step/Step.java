package co.com.efalvare.model.step;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Step {
    private String name;
    private String nextStepUrl;
    private String state;
}
