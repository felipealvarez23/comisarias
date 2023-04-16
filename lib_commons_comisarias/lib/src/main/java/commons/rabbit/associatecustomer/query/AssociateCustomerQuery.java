package commons.rabbit.associatecustomer.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AssociateCustomerQuery {
    private List<CustomerQuery> customerList;
}
