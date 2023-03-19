package co.com.efalvare.api.orchestrator.handler;

import co.com.efalvare.api.orchestrator.mapper.StartRequestMapper;
import co.com.efalvare.api.orchestrator.model.request.StartRequestApiRest;
import co.com.efalvare.api.orchestrator.model.response.StartRequestRespApiRest;
import co.com.efalvare.model.exeption.OrchestratorException;
import co.com.efalvare.model.startrequest.request.StartRequest;
import co.com.efalvare.model.startrequest.request.StartRequestData;
import co.com.efalvare.usecase.startrequest.StartRequestUseCase;
import commons.rabbit.createpm.reply.ErrorReply;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

@Slf4j
@Component
@RequiredArgsConstructor
public class StartRequestHandler {

    private final StartRequestUseCase useCase;

    private final StartRequestMapper mapper;

    public Mono<ServerResponse> startRequest(ServerRequest request) {
        return setIp(request)
                .flatMap(useCase::startRequest)
                .map(mapper::mapperToResponse)
                .flatMap(response -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(response), StartRequestRespApiRest.class))
                .onErrorResume(OrchestratorException.class, e -> ServerResponse.badRequest()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(StartRequestRespApiRest.builder()
                                        .error(ErrorReply.builder()
                                                .code(e.getCode())
                                                .description(e.getDescription())
                                                .build())
                                .build()), StartRequestRespApiRest.class));
    }

    private Mono<StartRequestData> setIp(ServerRequest request) {
        String ip = request.remoteAddress()
                .map(InetSocketAddress::getHostString)
                .orElseGet(() -> "");
        return request.bodyToMono(StartRequestApiRest.class)
                .map(mapper::mapperToStartRequest)
                .map(StartRequest::getData)
                .map(startRequestData -> {
                    startRequestData.setIp(ip);
                    log.info("Start execution [start-request] operation: [{}]",startRequestData);
                    return startRequestData;
                });
    }


}
