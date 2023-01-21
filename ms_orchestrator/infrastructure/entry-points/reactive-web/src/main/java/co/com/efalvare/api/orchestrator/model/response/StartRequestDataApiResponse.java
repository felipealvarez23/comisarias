package co.com.efalvare.api.orchestrator.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class StartRequestDataApiResponse {
    private String protectionMeasureId;
    private String type;
    private String nextStepUrl;
}
