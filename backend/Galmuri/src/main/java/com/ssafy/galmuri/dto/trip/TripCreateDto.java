package com.ssafy.galmuri.dto.trip;

import com.ssafy.galmuri.domain.trip.Trip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripCreateDto {
    private String title;
    private Long startDate;
    private Long endDate;
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
