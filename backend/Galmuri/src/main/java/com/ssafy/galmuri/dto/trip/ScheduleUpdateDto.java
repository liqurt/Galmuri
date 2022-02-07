package com.ssafy.galmuri.dto.trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleUpdateDto {
    private LocalDateTime time;
    private String countryCode;
    private String location;
    private float latitude;
    private float longitude;
}
