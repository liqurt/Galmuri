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
public class TripAgeRangeCreateDto {
    private Long tripId;
    private int ageRange;
    public TripAgeRange toEntity(){
        return new TripAgeRange(tripId,ageRange);
    }
}
