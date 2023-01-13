package co.com.efalvare.mq.listener.createpm;

/*import co.com.efalvare.model.protectionmeasure.ProtectionMeasure;
import co.com.efalvare.model.rabbit.createpm.query.CreatePMDataQuery;
import co.com.efalvare.model.rabbit.createpm.query.CreatePMQuery;
import co.com.efalvare.model.rabbit.createpm.reply.CreatePMDataReply;
import co.com.efalvare.model.rabbit.createpm.reply.CreatePMReply;*/
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


/*    public Mono<CreatePMReply> createPM(CreatePMQuery query) {
        CreatePMDataQuery data = query.getData();
        return useCase.createProtectionMeasure(ProtectionMeasure.builder()
                .documentType(data.getDocumentType())
                .documentNumber(data.getDocumentNumber())
                .type(data.getType())
                .ip("10.12.23.15")
                .build())
                .map(protectionMeasure -> CreatePMReply.builder()
                        .data(CreatePMDataReply.builder()
                                .protectionMeasureId(protectionMeasure.getRequestId())
                                .type(protectionMeasure.getType())
                                .build())
                        .build());
    }*/

}
