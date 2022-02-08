package com.ssafy.galmuri.domain.trip;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TripAgeRangeID implements Serializable {
    private Long tripId;
    private int ageRange;

    public TripAgeRangeID(TripAgeRange tripAgeRange){
        this.tripId=tripAgeRange.getTripId().getTripId();
        this.ageRange=tripAgeRange.getAgeRange();
    }
}
