package com.ssafy.galmuri.dto;

import com.ssafy.galmuri.domain.trip.Trip;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TripSaveRequestDto {
    private String title;
    private String hostId;
    private char hostDomain;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String theme;
    private int maxMember;
    private String comment;

    @Builder
    public TripSaveRequestDto(String title,String hostId,char hostDomain,LocalDateTime startDate,LocalDateTime endDate,String theme,int maxMember,String comment){
        this.title=title;
        this.hostId=hostId;
        this.hostDomain=hostDomain;
        this.startDate=startDate;
        this.endDate=endDate;
        this.theme=theme;
        this.maxMember=maxMember;
        this.comment=comment;
    }
    public Trip toEntity(){
        return Trip.builder()
                .title(title)
                .hostId(hostId)
                .hostDomain(hostDomain)
                .startDate(startDate)
                .endDate(endDate)
                .theme(theme)
                .maxMember(maxMember)
                .comment(comment)
                .build();
    }

}
