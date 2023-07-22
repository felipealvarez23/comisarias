package commons.rabbit.protectionmeasure.associatecustomer.reply;

import commons.rabbit.commons.ErrorReply;
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
    private ErrorReply error;
}
