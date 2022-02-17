package com.ssafy.galmuri.dto.trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripUpdateDto {
    private String title;
    private Long startDate;
    private Long endDate;
    private String theme;
    private int maxMember;
    private int nowMember;
    private String comment;
    private boolean done;
}
