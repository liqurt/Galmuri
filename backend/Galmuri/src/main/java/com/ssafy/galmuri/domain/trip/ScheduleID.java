package com.ssafy.galmuri.domain.trip;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class ScheduleID implements Serializable {
    private Long trip;
    private int tripOrder;

    public ScheduleID(Schedule schedule){
        this.trip=schedule.getTrip().getTripId();
        this.tripOrder=schedule.getTripOrder();
    }
    public ScheduleID(Long tripId,int tripOrder){
        this.trip=tripId;
        this.tripOrder=tripOrder;
    }
}
