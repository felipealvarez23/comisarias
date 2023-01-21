package co.com.efalvare.api.orchestrator.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class StartRequestApiRest {
    @Valid
    @NotNull
    private StartRequestDataApiRest data;
}
