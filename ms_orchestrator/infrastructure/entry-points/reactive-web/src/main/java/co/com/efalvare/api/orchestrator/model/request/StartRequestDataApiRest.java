package co.com.efalvare.api.orchestrator.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class StartRequestDataApiRest {
    @NotEmpty(message = "El campo type no fue suministrado")
    private String type;

    @NotEmpty(message = "El campo documentType no fue suministrado")
    private String documentType;

    @NotEmpty(message = "El campo documentNumber no fue suministrado")
    private String documentNumber;
}
