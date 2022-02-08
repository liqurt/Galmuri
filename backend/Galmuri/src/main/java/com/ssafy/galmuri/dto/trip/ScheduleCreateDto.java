package com.ssafy.galmuri.dto.trip;

import com.ssafy.galmuri.domain.trip.Country;
import com.ssafy.galmuri.domain.trip.Schedule;
import com.ssafy.galmuri.domain.trip.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleCreateDto {
    private Long tripId;
    private int tripOrder;
    private LocalDateTime time;
    private String countryCode;
    private String location;
    private float latitude;
    private float longitude;

    public Schedule toEntity(){
        return Schedule.builder()
                .tripId(tripId)
                .tripOrder(tripOrder)
                .time(time)
                .country(countryCode)
                .location(location)
                .latitude(latitude)
                .longitude(longitude).build();
    }
}
