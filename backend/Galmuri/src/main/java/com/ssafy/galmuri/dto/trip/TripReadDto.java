package com.ssafy.galmuri.dto.trip;

import com.ssafy.galmuri.domain.trip.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class TripReadDto {
    private Long tripId;
    private String title;
    private Long startDate;
    private Long endDate;
    private String theme;
    private int maxMember;
    private int nowMember;
    private String comment;
    private boolean done;

    public TripReadDto(Trip trip){
        this.tripId=trip.getTripId();
        this.title=trip.getTitle();
        this.startDate=trip.getStartDate();
        this.endDate=trip.getEndDate();
        this.theme=trip.getTheme();
        this.maxMember=trip.getMaxMember();
        this.nowMember=trip.getNowMember();
        this.comment=trip.getComment();
        this.done= trip.isDone();
    }
}
