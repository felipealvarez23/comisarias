package commons.rabbit.getstep.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStepDataQuery {
    private UUID protectionMeasureId;
}
