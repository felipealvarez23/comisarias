package co.com.efalvare.model.rabbit.createpm.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreatePMQuery {
    private CreatePMDataQuery data;
}
