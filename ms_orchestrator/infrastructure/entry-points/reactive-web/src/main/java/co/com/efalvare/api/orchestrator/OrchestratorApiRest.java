package co.com.efalvare.api.orchestrator;

import co.com.efalvare.api.orchestrator.mapper.StartRequestMapper;
import co.com.efalvare.api.orchestrator.model.request.StartRequestApiRest;
import co.com.efalvare.api.orchestrator.model.response.StartRequestRespApiRest;
import co.com.efalvare.model.startrequest.request.StartRequest;
import co.com.efalvare.usecase.startrequest.StartRequestUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrchestratorApiRest {

    private final StartRequestUseCase useCase;

    private final StartRequestMapper mapper;

    @PostMapping(path = "/start-request")
    public Mono<StartRequestRespApiRest> startRequest(@Valid @RequestBody Mono<StartRequestApiRest> request) {
        log.info("Start request");
        return request.map(mapper::mapperToStartRequest)
                .map(StartRequest::getData)
                .flatMap(useCase::startRequest)
                .map(mapper::mapperToResponse);
    }
}
