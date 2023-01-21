package co.com.efalvare.model.protectionmeasure.gateways;

import commons.rabbit.createpm.query.CreatePMQuery;
import commons.rabbit.createpm.reply.CreatePMReply;
import reactor.core.publisher.Mono;

public interface ProtectionMeasureRepository {

    Mono<CreatePMReply> createProtectionMeasure(CreatePMQuery query);
}
