package co.com.efalvare.config;

import co.com.efalvare.mq.listener.createpm.CreatePMRabbitHandler;
import commons.rabbit.createpm.query.CreatePMQuery;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static commons.constants.RabbitOperations.CREATE_PROTECTION_MEASURE;

@Configuration
@RequiredArgsConstructor
public class ListenerConfig {

    private final CreatePMRabbitHandler createPMRabbitHandler;

    @Bean
    public HandlerRegistry handlerRegistry(){
        return HandlerRegistry.register()
                .serveQuery(CREATE_PROTECTION_MEASURE, createPMRabbitHandler::createPM, CreatePMQuery.class);
    }

}
