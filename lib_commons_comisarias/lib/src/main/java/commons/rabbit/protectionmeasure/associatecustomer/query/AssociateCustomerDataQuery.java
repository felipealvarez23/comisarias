package commons.rabbit.protectionmeasure.associatecustomer.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AssociateCustomerDataQuery {
    private UUID protectionMeasureId;
    private List<CustomerQuery> customerList;
}
