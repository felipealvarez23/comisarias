package commons.rabbit.protectionmeasure.associatecustomer.reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AssociateCustomerReply {
    private AssociateCustomerDataReply data;
}
