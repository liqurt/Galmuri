package com.ssafy.galmuri.domain.trip;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class ScheduleID implements Serializable {
    private Long tripId;
    private int tripOrder;

    public ScheduleID(Schedule schedule){
        this.tripId=schedule.getTripId().getTripId();
        this.tripOrder=schedule.getTripOrder();
    }
    public ScheduleID(Long tripId,int tripOrder){
        this.tripId=tripId;
        this.tripOrder=tripOrder;
    }
}
