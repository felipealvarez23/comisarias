package co.com.efalvare.api.orchestrator.model.response;

import co.com.efalvare.model.startrequest.response.StartRequestDataResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import commons.rabbit.createpm.reply.ErrorReply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StartRequestRespApiRest {
    private StartRequestDataResponse data;
    private ErrorReply error;
}
