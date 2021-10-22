package com.privateprojects.eurovisionjudge.converter.impl;

import com.privateprojects.eurovisionjudge.converter.IConverter;
import com.privateprojects.eurovisionjudge.dto.AbstractDTO;
import com.privateprojects.eurovisionjudge.model.AbstractModel;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<ENTITY extends AbstractModel, DTO extends AbstractDTO> implements IConverter<ENTITY, DTO> {
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
}