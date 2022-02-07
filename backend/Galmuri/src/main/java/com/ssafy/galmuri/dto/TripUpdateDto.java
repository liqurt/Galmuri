package com.ssafy.galmuri.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripUpdateDto {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String theme;
    private int maxMember;
    private int nowMember;
    private String comment;
    private boolean done;
}
