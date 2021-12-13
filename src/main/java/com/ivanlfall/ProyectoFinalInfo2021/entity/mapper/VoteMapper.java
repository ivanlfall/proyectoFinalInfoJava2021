package com.ivanlfall.ProyectoFinalInfo2021.entity.mapper;

import com.ivanlfall.ProyectoFinalInfo2021.dto.VoteDto;
import com.ivanlfall.ProyectoFinalInfo2021.entity.Vote;

public class VoteMapper {
    public static Vote mapToModel(VoteDto dto){
        Vote vote = new Vote();
        vote.setGeneratedBy(dto.getGeneratedBy());
        return vote;
    }
}
