package com.ssafy.galmuri.dto.trip;

import com.ssafy.galmuri.domain.trip.TripAgeRange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripAgeRangeReadDto {
    private Long tripId;
    private int ageRange;
    public TripAgeRangeReadDto(TripAgeRange tripAgeRange){
        this.tripId=tripAgeRange.getTrip().getTripId();
        this.ageRange=tripAgeRange.getAgeRange();
    }
}
