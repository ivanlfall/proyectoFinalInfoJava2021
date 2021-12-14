package com.ivanlfall.ProyectoFinalInfo2021.viewModel.mapper;

import com.ivanlfall.ProyectoFinalInfo2021.entity.Entrepreneurship;
import com.ivanlfall.ProyectoFinalInfo2021.viewModel.EntrepreneurshipVM;

public class EntrepreneurshipVMMapper {
    public static EntrepreneurshipVM mapToModel(Entrepreneurship entrepreneurship){
        EntrepreneurshipVM entrepreneurshipVM = new EntrepreneurshipVM();
        entrepreneurshipVM.setId(entrepreneurship.getId());
        entrepreneurshipVM.setName(entrepreneurship.getName());
        entrepreneurshipVM.setDescription(entrepreneurship.getDescription());
        entrepreneurshipVM.setContent(entrepreneurship.getContent());
        entrepreneurshipVM.setDischargeDate(entrepreneurship.getDischargeDate());
        entrepreneurshipVM.setTarget(entrepreneurship.getTarget());
        entrepreneurshipVM.setUrls(entrepreneurship.getUrl());
        entrepreneurshipVM.setTags(entrepreneurship.getTags());
        if (entrepreneurship.getEvent() == null){
            entrepreneurshipVM.setEvent("No event");
        }else{
            entrepreneurshipVM.setEvent(entrepreneurship.getEvent().getDetails());
        }
        entrepreneurshipVM.setVotes(entrepreneurship.getVotes().size());

        return entrepreneurshipVM;
    }

}
