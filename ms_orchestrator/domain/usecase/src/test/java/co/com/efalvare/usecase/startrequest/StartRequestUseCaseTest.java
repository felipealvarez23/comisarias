package co.com.efalvare.usecase.startrequest;

import co.com.efalvare.model.protectionmeasure.gateways.ProtectionMeasureRepository;
import co.com.efalvare.model.startrequest.request.StartRequestData;
import co.com.efalvare.model.startrequest.response.StartRequestResponse;
import co.com.efalvare.model.step.Step;
import co.com.efalvare.model.step.gateways.StepRepository;
import commons.rabbit.createpm.reply.CreatePMDataReply;
import commons.rabbit.createpm.reply.CreatePMReply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StartRequestUseCaseTest {

    @Mock
    ProtectionMeasureRepository pmRepository;

    @Mock
    StepRepository stepRepository;

    @InjectMocks
    StartRequestUseCase useCase;

    @Test
    @DisplayName("should create protection measure")
    void startRequest() {
        StartRequestData requestData = new StartRequestData();
        when(pmRepository.createProtectionMeasure(any()))
                .thenReturn(Mono.just(CreatePMReply.builder()
                        .data(new CreatePMDataReply())
                        .build()));
        when(stepRepository.getStep(any())).thenReturn(Mono.just(Step.builder()
                .nextStepUrl("")
                .build()));
        Mono<StartRequestResponse> response = useCase.startRequest(requestData);
        StepVerifier.create(response)
                .expectNextMatches(Objects::nonNull)
                .expectComplete()
                .verify();
    }
}