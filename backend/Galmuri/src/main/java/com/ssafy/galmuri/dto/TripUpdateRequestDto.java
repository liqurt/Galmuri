package com.ssafy.galmuri.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TripUpdateRequestDto {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String theme;
    private int maxMember;
    private String comment;

    @Builder
    public TripUpdateRequestDto(String title,LocalDateTime startDate,LocalDateTime endDate,String theme,int maxMember,String comment){
        this.title=title;
        this.startDate=startDate;
        this.endDate=endDate;
        this.theme=theme;
        this.maxMember=maxMember;
        this.comment=comment;
    }
}
