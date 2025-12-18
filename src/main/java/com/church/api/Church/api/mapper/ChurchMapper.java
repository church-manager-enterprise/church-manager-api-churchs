package com.church.api.Church.api.mapper;

import com.church.api.Church.api.model.dto.ChurchDTO;
import com.church.api.Church.api.model.entities.Church;
import com.church.api.Church.api.model.request.ChurchRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ChurchMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Church toEntity(ChurchRequest request);

    ChurchDTO toDTO(Church church);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromRequest(ChurchRequest request, @MappingTarget Church entity);
}
