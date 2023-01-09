package co.com.efalvare.model.rabbit.createpm.query;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreatePMDataQuery {
    private String ip;
    private String documentType;
    private String documentNumber;
    private String type;
}
