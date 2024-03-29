package commons.rabbit.protectionmeasure.createpm.reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreatePMDataReply {
    private String protectionMeasureId;
    private String step;
    private String type;
}
