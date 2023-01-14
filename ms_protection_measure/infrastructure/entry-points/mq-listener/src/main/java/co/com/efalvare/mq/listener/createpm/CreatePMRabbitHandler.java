package co.com.efalvare.mq.listener.createpm;

import co.com.efalvare.usecase.protectionmeasure.ProtectionMeasureUseCase;
import commons.rabbit.createpm.query.CreatePMQuery;
import commons.rabbit.createpm.reply.CreatePMReply;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreatePMRabbitHandler {

    private final ProtectionMeasureUseCase useCase;

    public Mono<CreatePMReply> createPM(CreatePMQuery query) {
        log.info("Rabbit request operation [create-protection_measure] received");
        return Mono.empty();
    }

}
