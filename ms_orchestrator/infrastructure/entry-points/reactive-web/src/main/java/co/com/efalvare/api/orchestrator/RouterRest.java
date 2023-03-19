package co.com.efalvare.api.orchestrator;

import co.com.efalvare.api.orchestrator.handler.StartRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {

    @Bean
    public RouterFunction<ServerResponse> routerFunctionStartRequest(StartRequestHandler handler) {
        return route().path("/comisarias/api/v1", builder -> builder
                        .GET("/health", request -> ServerResponse.ok().body(Mono.just("OK"), String.class))
                        .POST("/start-request", handler::startRequest)
                ).build();
    }

}
