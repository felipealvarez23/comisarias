package co.com.efalvare.mq.protectionmeasure;

import co.com.efalvare.model.protectionmeasure.gateways.ProtectionMeasureRepository;
import commons.rabbit.createpm.query.CreatePMQuery;
import commons.rabbit.createpm.reply.CreatePMReply;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.api.AsyncQuery;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static commons.constants.RabbitOperations.CREATE_PROTECTION_MEASURE;
import static commons.constants.RabbitOperations.PROTECTION_MEASURE;

@Service
@RequiredArgsConstructor
public class ProtectionMeasureSender implements ProtectionMeasureRepository {

    private final DirectAsyncGateway directAsyncGateway;

    @Override
    public Mono<CreatePMReply> createProtectionMeasure(CreatePMQuery query) {
        AsyncQuery<CreatePMQuery> asyncQuery = new AsyncQuery<>(CREATE_PROTECTION_MEASURE, query);
        return directAsyncGateway.requestReply(asyncQuery, PROTECTION_MEASURE, CreatePMReply.class);
    }
}
