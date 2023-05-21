package commons.rabbit.customers.createcustomers.reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreateCustomersReply {
    private CreateCustomersDataReply data;
}
