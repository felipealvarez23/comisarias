package co.com.efalvare.api.orchestrator.model.response;

import co.com.efalvare.model.startrequest.response.StartRequestDataResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class StartRequestRespApiRest {
    private StartRequestDataResponse data;
}
