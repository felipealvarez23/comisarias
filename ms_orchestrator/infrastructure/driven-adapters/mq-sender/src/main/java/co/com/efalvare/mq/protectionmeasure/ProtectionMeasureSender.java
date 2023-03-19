package co.com.efalvare.mq.protectionmeasure;

import co.com.efalvare.model.exeption.OrchestratorException;
import co.com.efalvare.model.protectionmeasure.gateways.ProtectionMeasureRepository;
import commons.rabbit.createpm.query.CreatePMQuery;
import commons.rabbit.createpm.reply.CreatePMReply;
import commons.rabbit.createpm.reply.ErrorReply;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivecommons.async.api.AsyncQuery;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static commons.constants.RabbitOperations.CREATE_PROTECTION_MEASURE;
import static commons.constants.RabbitOperations.PROTECTION_MEASURE;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProtectionMeasureSender implements ProtectionMeasureRepository {

    private final DirectAsyncGateway directAsyncGateway;

    @Override
    public Mono<CreatePMReply> createProtectionMeasure(CreatePMQuery query) {
        AsyncQuery<CreatePMQuery> asyncQuery = new AsyncQuery<>(CREATE_PROTECTION_MEASURE, query);
        log.info("Consume [create-pm] operation: [{}]", query);
        return directAsyncGateway.requestReply(asyncQuery, PROTECTION_MEASURE, CreatePMReply.class)
                .flatMap(this::checkResponse);
    }

    /**
     * Method that checks the response of creating a PM (Protection Measure)
     *
     * @param reply The response of creating the PM
     * @return A Mono that contains the PM response if it was created successfully,
     *         or an error if it was not created successfully
     */
    private Mono<CreatePMReply> checkResponse(CreatePMReply reply) {
        if(reply.getData() != null && reply.getError() == null) {
            log.info("Success consume [create-pm] operation: [{}]", reply.getData());
            return Mono.just(reply);
        } else {
            log.error("Error consume [create-pm] operation: [{}]", reply.getError());
            ErrorReply error = reply.getError();
            return Mono.error(() -> new OrchestratorException(error.getCode(),error.getDescription()));
        }
    }
}
