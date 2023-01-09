package co.com.efalvare.model.rabbit.createpm.reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreatePMDataReply {
    private UUID protectionMeasureId;
    private String type;
}
