package co.com.efalvare.usecase.startrequest;

import co.com.efalvare.model.protectionmeasure.gateways.ProtectionMeasureRepository;
import co.com.efalvare.model.startrequest.request.StartRequestData;
import co.com.efalvare.model.startrequest.response.StartRequestDataResponse;
import co.com.efalvare.model.startrequest.response.StartRequestResponse;
import co.com.efalvare.model.step.gateways.StepRepository;
import commons.rabbit.createpm.query.CreatePMDataQuery;
import commons.rabbit.createpm.query.CreatePMQuery;
import commons.rabbit.createpm.reply.CreatePMDataReply;
import commons.rabbit.createpm.reply.CreatePMReply;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.function.TupleUtils;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;


@RequiredArgsConstructor
public class StartRequestUseCase {

    private final ProtectionMeasureRepository pmRepository;

    private final StepRepository stepRepository;

    public Mono<StartRequestResponse> startRequest(StartRequestData data) {
        CreatePMQuery query = buildProMeasureQuery(data);
        return pmRepository.createProtectionMeasure(query)
                .flatMap(this::getNextStep)
                .map(TupleUtils.function((step, pmInfo) -> StartRequestResponse.builder()
                        .data(StartRequestDataResponse.builder()
                                .nextStepUrl(step)
                                .protectionMeasureId(pmInfo.getProtectionMeasureId())
                                .type(pmInfo.getType())
                                .build())
                        .build()));
    }

    private Mono<Tuple2<String, CreatePMDataReply>> getNextStep(CreatePMReply reply) {
        CreatePMDataReply data = reply.getData();
        return stepRepository.getStep(data.getStep())
                .map(step -> Tuples.of(step.getNextStepUrl(), reply.getData()));
    }

    private CreatePMQuery buildProMeasureQuery(StartRequestData data) {
        return CreatePMQuery.builder()
                .data(CreatePMDataQuery.builder()
                        .documentNumber(data.getDocumentNumber())
                        .documentType(data.getDocumentType())
                        .ip(data.getIp())
                        .type(data.getType())
                        .build())
                .build();
    }

}
