package com.privateprojects.eurovisionjudge.converter;

import java.util.List;
import java.util.Set;

public interface IConverter<ENTITY, DTO> {
    DTO toDTO(ENTITY entity);
    ENTITY fromDTO(DTO dto);
    List<DTO> toDTOCollection(List<ENTITY> entityList);
    List<ENTITY> fromDTOCollection(List<DTO> dtoList);
    Set<DTO> toDTOCollection(Set<ENTITY> entitySet);
    Set<ENTITY> fromDTOCollection(Set<DTO> dtoSet);
}
