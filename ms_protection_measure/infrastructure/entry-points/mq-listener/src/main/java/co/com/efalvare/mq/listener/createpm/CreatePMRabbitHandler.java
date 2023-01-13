package co.com.efalvare.mq.listener.createpm;

import co.com.efalvare.usecase.protectionmeasure.ProtectionMeasureUseCase;
import commons.rabbit.createpm.query.CreatePMQuery;
import commons.rabbit.createpm.reply.CreatePMReply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreatePMRabbitHandler {

    private final ProtectionMeasureUseCase useCase;

    public Mono<CreatePMReply> createPM(CreatePMQuery query) {
        return Mono.empty();
    }

}
