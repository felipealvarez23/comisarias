package commons.rabbit.protectionmeasure.getstep.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class GetStepQuery {
    private GetStepDataQuery data;
}
