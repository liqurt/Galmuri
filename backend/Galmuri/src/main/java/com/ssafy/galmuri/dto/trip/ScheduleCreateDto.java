package com.ssafy.galmuri.dto.trip;

import com.ssafy.galmuri.domain.trip.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleCreateDto {
    private Long tripId;
    private int tripOrder;
    private Date time;
    private String countryCode;
    private String location;
    private float latitude;
    private float longitude;
}
