package com.ssafy.galmuri.dto;

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
public class TripCreateDto {
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String theme;
    private int maxMember;
    private String comment;
    private boolean done;

    public Trip toEntity(){
        return Trip.builder()
                .title(title)
                .startDate(startDate)
                .endDate(endDate)
                .theme(theme)
                .maxMember(maxMember)
                .comment(comment)
                .done(done).build();
    }
}
