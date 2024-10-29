package com.maxlvshv.eventshare.mapper;

import com.maxlvshv.eventshare.dto.EventScrollDto;
import com.maxlvshv.eventshare.entity.Event;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EventScrollMapper {
    Event toEntity(EventScrollDto eventScrollDto);

    EventScrollDto toDto(Event event);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Event partialUpdate(EventScrollDto eventScrollDto, @MappingTarget Event event);
}