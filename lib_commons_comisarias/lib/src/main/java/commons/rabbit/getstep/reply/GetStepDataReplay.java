package commons.rabbit.getstep.reply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStepDataReplay {
    private String status;
    private String step;
    private String type;
}
