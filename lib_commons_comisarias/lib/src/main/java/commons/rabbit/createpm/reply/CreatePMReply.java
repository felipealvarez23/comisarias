package commons.rabbit.createpm.reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreatePMReply {
    private CreatePMDataReply data;
    private ErrorReply error;
}
