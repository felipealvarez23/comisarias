package commons.rabbit.customers.createcustomers.query;

import commons.rabbit.protectionmeasure.associatecustomer.query.CustomerQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreateCustomersDataQuery {
    private List<CustomerQuery> customers;
}
