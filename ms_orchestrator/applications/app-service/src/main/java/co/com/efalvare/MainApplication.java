package co.com.efalvare;

import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDirectAsyncGateway
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
