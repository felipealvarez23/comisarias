package commons.rabbit.protectionmeasure.getstep.reply;

import commons.rabbit.commons.ErrorReply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class GetStepReply {
    private GetStepDataReplay data;
    private ErrorReply error;
}
