package com.ivanlfall.ProyectoFinalInfo2021.viewModel.mapper;

import com.ivanlfall.ProyectoFinalInfo2021.entity.Vote;
import com.ivanlfall.ProyectoFinalInfo2021.viewModel.VoteVM;

public class VoteVMMapper {
    public static VoteVM mapToModel(Vote vote){
        VoteVM voteVM = new VoteVM();
        voteVM.setId(vote.getId());
        voteVM.setGeneratedBy(vote.getGeneratedBy());
        voteVM.setUserId(vote.getUser().getId());
        voteVM.setEntrepreneurshipId(vote.getEntrepreneurship().getId());
        voteVM.setDischargeDate(vote.getDischargeDate());

        return voteVM;
    }
}
