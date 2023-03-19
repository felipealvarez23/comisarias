package co.com.efalvare.model.startrequest.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class StartRequestData {
    private String type;
    private String documentType;
    private String documentNumber;
    private String ip;
}
