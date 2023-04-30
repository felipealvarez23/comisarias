package commons.rabbit.getstep.reply;

import commons.rabbit.commons.ErrorReply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStepReply {
    private GetStepDataReplay data;
    private ErrorReply error;
}
