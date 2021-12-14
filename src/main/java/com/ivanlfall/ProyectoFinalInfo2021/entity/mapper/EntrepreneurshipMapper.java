package com.ivanlfall.ProyectoFinalInfo2021.entity.mapper;

import com.ivanlfall.ProyectoFinalInfo2021.dto.EntrepreneurshipDto;
import com.ivanlfall.ProyectoFinalInfo2021.entity.Entrepreneurship;

public class EntrepreneurshipMapper {
    public static Entrepreneurship mapToModel(EntrepreneurshipDto dto){
        Entrepreneurship entrepreneurship = new Entrepreneurship();
        entrepreneurship.setName(dto.getName());
        entrepreneurship.setDescription(dto.getDescription());
        entrepreneurship.setContent(dto.getContent());
        entrepreneurship.setTarget(dto.getTarget());
        entrepreneurship.setPublished(dto.isPublished());
        entrepreneurship.setUrl(dto.getUrls());
        entrepreneurship.setTags(dto.getTags());
        return entrepreneurship;
    }
}
