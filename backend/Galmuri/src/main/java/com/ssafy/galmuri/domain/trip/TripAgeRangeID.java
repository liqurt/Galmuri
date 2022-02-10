package com.ssafy.galmuri.domain.trip;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TripAgeRangeID implements Serializable {
    private Long trip;
    private int ageRange;

    public TripAgeRangeID(TripAgeRange tripAgeRange){
        this.trip=tripAgeRange.getTrip().getTripId();
        this.ageRange=tripAgeRange.getAgeRange();
    }
}
