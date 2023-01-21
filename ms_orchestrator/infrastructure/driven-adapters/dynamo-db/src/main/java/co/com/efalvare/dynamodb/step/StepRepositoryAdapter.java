package co.com.efalvare.dynamodb.step;

import co.com.efalvare.dynamodb.helper.TemplateAdapterOperations;
import co.com.efalvare.dynamodb.step.model.StepData;
import co.com.efalvare.model.step.Step;
import co.com.efalvare.model.step.gateways.StepRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;


@Repository
public class StepRepositoryAdapter extends TemplateAdapterOperations<Step,String,StepData> implements StepRepository {

    protected StepRepositoryAdapter(DynamoDbEnhancedAsyncClient connectionFactory, ObjectMapper mapper) {
        super(connectionFactory, mapper, d-> mapper.map(d, Step.class), "tbl-mp-steps");
    }

    @Override
    public Mono<Step> getStep(String name) {
        return getById(name);
    }
}
