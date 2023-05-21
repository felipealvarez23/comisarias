package commons.rabbit.customers.createcustomers.reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreateCustomersDataReply {
    private List<CustomerReply> customers;
}
