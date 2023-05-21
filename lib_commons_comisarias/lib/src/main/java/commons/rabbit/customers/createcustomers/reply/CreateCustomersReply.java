package commons.rabbit.customers.createcustomers.reply;

import commons.rabbit.customers.createcustomers.query.CreateCustomersDataQuery;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreateCustomersReply {
    private CreateCustomersDataQuery data;
}
