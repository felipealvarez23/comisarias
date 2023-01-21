package co.com.efalvare.dynamodb.step.model;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@DynamoDbBean
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class StepData {

    @Getter(AccessLevel.NONE)
    private String name;

    @Getter(AccessLevel.NONE)
    private String nextStepUrl;

    @Getter(AccessLevel.NONE)
    private String status;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("name")
    public String getName(){
      return name;
    }

    @DynamoDbAttribute("nextStepUrl")
    public String getNextStepUrl() {
        return nextStepUrl;
    }

    @DynamoDbAttribute("status")
    public String getStatus() {
        return status;
    }
}
