package com.privateprojects.eurovisionjudge.converter;

import java.util.List;

public interface IConverter<ENTITY, DTO> {
    DTO toDTO(ENTITY entity);
    ENTITY fromDTO(DTO dto);
    List<DTO> toDTOCollection(List<ENTITY> entityList);
    List<ENTITY> fromDTOCollection(List<DTO> dtoList);
}
