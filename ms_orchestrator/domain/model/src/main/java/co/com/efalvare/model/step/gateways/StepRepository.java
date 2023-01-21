package co.com.efalvare.model.step.gateways;

import co.com.efalvare.model.step.Step;
import reactor.core.publisher.Mono;

public interface StepRepository {
    Mono<Step> getStep(String name);
}
