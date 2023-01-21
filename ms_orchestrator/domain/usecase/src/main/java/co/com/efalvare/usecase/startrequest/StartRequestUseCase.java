package co.com.efalvare.usecase.startrequest;

import co.com.efalvare.model.protectionmeasure.gateways.ProtectionMeasureRepository;
import co.com.efalvare.model.startrequest.request.StartRequestData;
import co.com.efalvare.model.startrequest.response.StartRequestDataResponse;
import co.com.efalvare.model.startrequest.response.StartRequestResponse;
import co.com.efalvare.model.step.gateways.StepRepository;
import commons.rabbit.createpm.query.CreatePMDataQuery;
import commons.rabbit.createpm.query.CreatePMQuery;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class StartRequestUseCase {

    private final ProtectionMeasureRepository pmRepository;

    private final StepRepository stepRepository;

    public Mono<StartRequestResponse> startRequest(StartRequestData data) {
        CreatePMQuery query = buildProMeasureQuery(data);
        return pmRepository.createProtectionMeasure(query)
                .map(pMReply -> StartRequestResponse.builder()
                        .data(StartRequestDataResponse.builder()
                                .nextStepUrl("")
                                .protectionMeasureId(pMReply.getData().getProtectionMeasureId())
                                .type(pMReply.getData().getType())
                                .build())
                        .build());
    }

    private CreatePMQuery buildProMeasureQuery(StartRequestData data) {
        return CreatePMQuery.builder()
                .data(CreatePMDataQuery.builder()
                        .documentNumber(data.getDocumentNumber())
                        .documentType(data.getDocumentType())
                        .ip("10.12.14.56")
                        .type(data.getType())
                        .build())
                .build();
    }

}
