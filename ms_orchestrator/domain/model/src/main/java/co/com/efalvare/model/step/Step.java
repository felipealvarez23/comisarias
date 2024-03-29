package co.com.efalvare.model.step;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Step {
    private String name;
    private String nextStepUrl;
    private String state;
}
