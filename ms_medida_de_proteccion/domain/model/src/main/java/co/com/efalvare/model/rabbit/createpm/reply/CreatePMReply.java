package co.com.efalvare.model.rabbit.createpm.reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreatePMReply {
    private CreatePMDataReply data;
}
