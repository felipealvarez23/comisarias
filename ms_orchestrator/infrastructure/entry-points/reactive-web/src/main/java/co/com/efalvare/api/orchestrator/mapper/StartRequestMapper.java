package co.com.efalvare.api.orchestrator.mapper;

import co.com.efalvare.api.orchestrator.model.request.StartRequestApiRest;
import co.com.efalvare.api.orchestrator.model.response.StartRequestRespApiRest;
import co.com.efalvare.model.startrequest.request.StartRequest;
import co.com.efalvare.model.startrequest.response.StartRequestResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StartRequestMapper {

    StartRequest mapperToStartRequest(StartRequestApiRest requestApiRest);

    StartRequestRespApiRest mapperToResponse(StartRequestResponse response);

}
