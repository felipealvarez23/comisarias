package co.com.efalvare.mq.listener.createpm;

import co.com.efalvare.model.exception.ProtectionMeasureException;
import co.com.efalvare.mq.listener.createpm.mapper.ProtectionMeasureMapper;
import co.com.efalvare.usecase.protectionmeasure.ProtectionMeasureUseCase;
import commons.rabbit.createpm.query.CreatePMQuery;
import commons.rabbit.createpm.reply.CreatePMReply;
import commons.rabbit.createpm.reply.ErrorReply;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreatePMRabbitHandler {

    private final ProtectionMeasureUseCase useCase;

    private final ProtectionMeasureMapper mapper;

    public Mono<CreatePMReply> createPM(CreatePMQuery query) {
        log.info("Rabbit request operation [createPM] received");
        return Mono.just(query)
                .map(CreatePMQuery::getData)
                .map(mapper::mapperToProtectionMeasure)
                .flatMap(useCase::createProtectionMeasure)
                .map(mapper::mapperToResponse)
                .map(data -> CreatePMReply.builder().data(data).build())
                .onErrorResume(ProtectionMeasureException.class, this::buildErrorResponse);
    }

    public Mono<CreatePMReply> buildErrorResponse(ProtectionMeasureException error) {
        return Mono.just(CreatePMReply.builder()
                .error(ErrorReply.builder()
                        .code(error.getCode())
                        .description(error.getDescription())
                        .build())
                .build());
    }

}
