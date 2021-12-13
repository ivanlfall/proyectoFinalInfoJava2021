package com.ivanlfall.ProyectoFinalInfo2021.entity.mapper;

import com.ivanlfall.ProyectoFinalInfo2021.dto.EventDto;
import com.ivanlfall.ProyectoFinalInfo2021.entity.Event;

public class EventMapper {
    public static Event mapToModel(EventDto dto){
        Event event = new Event();
        event.setDetails(dto.getDetails());
        event.setCloseDate(dto.getCloseDate());
        event.setPrize(dto.getPrize());
        event.setState(dto.getState());
        return event;
    }
}
