package com.ssafy.galmuri.domain.trip;

import com.ssafy.galmuri.domain.user.UserID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@IdClass(UserID.class)
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String hostId;

    @Column(nullable = false)
    private char hostDomain;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private String theme;

    @Column(nullable = false)
    private int maxMember;

    @Column(nullable = false)
    private int nowMember;

    @Column
    private String comment;

    @Column(nullable = false)
    private boolean isDone;

    @Builder
    public Trip(String title,String hostId,char hostDomain,LocalDateTime startDate,LocalDateTime endDate,String theme,int maxMember,String comment){
        this.title=title;
        this.hostId=hostId;
        this.hostDomain=hostDomain;
        this.startDate=startDate;
        this.endDate=endDate;
        this.theme=theme;
        this.maxMember=maxMember;
        this.nowMember=1;
        this.comment=comment;
        this.isDone=false;
    }

}
