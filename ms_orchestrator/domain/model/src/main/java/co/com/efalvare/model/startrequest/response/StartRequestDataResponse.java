package co.com.efalvare.model.startrequest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class StartRequestDataResponse {
    private String protectionMeasureId;
    private String type;
    private String nextStepUrl;
}
