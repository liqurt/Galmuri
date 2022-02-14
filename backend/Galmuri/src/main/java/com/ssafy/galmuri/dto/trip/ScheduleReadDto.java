package com.ssafy.galmuri.dto.trip;

import com.ssafy.galmuri.domain.trip.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class ScheduleReadDto {
    private Long tripId;
    private int tripOrder;
    private Date time;
    private String countryCode;
    private String location;
    private float latitude;
    private float longitude;

    public ScheduleReadDto(Schedule schedule){
        this.tripId=schedule.getTrip().getTripId();
        this.tripOrder=schedule.getTripOrder();
        this.time=schedule.getTime();
        this.countryCode=schedule.getCountry().getCountryCode();
        this.location=schedule.getLocation();
        this.latitude=schedule.getLatitude();
        this.longitude=schedule.getLongitude();
    }
}
