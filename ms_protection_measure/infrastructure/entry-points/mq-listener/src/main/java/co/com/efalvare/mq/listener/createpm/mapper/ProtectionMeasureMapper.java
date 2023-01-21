package co.com.efalvare.mq.listener.createpm.mapper;

import co.com.efalvare.model.protectionmeasure.ProtectionMeasure;
import commons.rabbit.createpm.query.CreatePMDataQuery;
import commons.rabbit.createpm.reply.CreatePMDataReply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProtectionMeasureMapper {
    ProtectionMeasure mapperToProtectionMeasure(CreatePMDataQuery data);

    @Mapping(target = "protectionMeasureId", expression = "java(protectionMeasure.getRequestId().toString())")
    CreatePMDataReply mapperToResponse(ProtectionMeasure protectionMeasure);
}
