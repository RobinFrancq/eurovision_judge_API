package com.privateprojects.eurovisionjudge.converter.impl;

import com.privateprojects.eurovisionjudge.converter.IConverter;
import com.privateprojects.eurovisionjudge.model.dto.AbstractDTO;
import com.privateprojects.eurovisionjudge.model.entity.AbstractEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractConverter<ENTITY extends AbstractEntity, DTO extends AbstractDTO> implements IConverter<ENTITY, DTO> {
    @Override
    public DTO toDTO(ENTITY entity) {
        return null;
    }
    @Override
    public ENTITY fromDTO(DTO dto) {
        return null;
    }
    @Override
    public List<DTO> toDTOCollection(List<ENTITY> entityList) {
        List<DTO> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(toDTO(entity)));
        return dtoList;
    }
    @Override
    public List<ENTITY> fromDTOCollection(List<DTO> dtoList) {
        List<ENTITY> entityList = new ArrayList<>();
        dtoList.forEach(dto -> entityList.add(fromDTO(dto)));
        return entityList;
    }
    @Override
    public Set<DTO> toDTOCollection(Set<ENTITY> entitySet) {
        Set<DTO> dtoSet = new HashSet<>();
        entitySet.forEach(entity -> dtoSet.add(toDTO(entity)));
        return dtoSet;
    }
    @Override
    public Set<ENTITY> fromDTOCollection(Set<DTO> dtoSet) {
        Set<ENTITY> entityList = new HashSet<>();
        dtoSet.forEach(dto -> entityList.add(fromDTO(dto)));
        return entityList;
    }
}