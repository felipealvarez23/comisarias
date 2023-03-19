package co.com.efalvare.mq.listener.createpm;

import co.com.efalvare.model.protectionmeasure.ProtectionMeasure;
import co.com.efalvare.mq.listener.createpm.mapper.ProtectionMeasureMapper;
import co.com.efalvare.usecase.protectionmeasure.ProtectionMeasureUseCase;
import commons.rabbit.createpm.query.CreatePMDataQuery;
import commons.rabbit.createpm.query.CreatePMQuery;
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
class CreatePMRabbitHandlerTest {

    @Mock
    ProtectionMeasureUseCase useCase;

    @Mock
    ProtectionMeasureMapper mapper;

    @InjectMocks
    CreatePMRabbitHandler handler;

    @Test
    @DisplayName("should create protection measure")
    void createPM() {
        CreatePMQuery query = CreatePMQuery.builder()
                .data(new CreatePMDataQuery())
                .build();
        when(mapper.mapperToProtectionMeasure(any())).thenReturn(new ProtectionMeasure());
        when(useCase.createProtectionMeasure(any())).thenReturn(Mono.just(new ProtectionMeasure()));
        when(mapper.mapperToResponse(any())).thenReturn(new CreatePMDataReply());
        Mono<CreatePMReply> reply = handler.createPM(query);
        StepVerifier.create(reply)
                .expectNextMatches(Objects::nonNull)
                .expectComplete()
                .verify();
    }
}