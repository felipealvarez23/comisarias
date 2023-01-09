package co.com.efalvare.config;

import co.com.efalvare.model.rabbit.createpm.query.CreatePMQuery;
import co.com.efalvare.mq.listener.createpm.CreatePMRabbitHandler;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ListenerConfig {


    private final CreatePMRabbitHandler createPMRabbitHandler;

    @Bean
    public HandlerRegistry handlerRegistry(){
        return HandlerRegistry.register()
                .serveQuery("medida_de_proteccion_backend.create", createPMRabbitHandler::createPM, CreatePMQuery.class);
    }

}
