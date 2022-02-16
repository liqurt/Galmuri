package com.ssafy.galmuri.domain.trip;

import com.ssafy.galmuri.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Trip extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long startDate;

    @Column(nullable = false)
    private Long endDate;

    @Column(nullable = false)
    private String theme;

    @Column(nullable = false)
    private int maxMember;

    @Column(nullable = false)
    private int nowMember;

    @Column
    private String comment;

    @Column(nullable = false)
    private boolean done;

    @OneToMany(mappedBy = "trip")
    private List<Schedule> schedules=new ArrayList<>();

    public Trip(Long tripId){
        this.tripId=tripId;
    }
    @Builder
    public Trip(String title,Long startDate
            ,Long endDate,String theme, int maxMember
                ,String comment,boolean done){
        this.title=title;
        this.startDate=startDate;
        this.endDate=endDate;
        this.theme=theme;
        this.maxMember=maxMember;
        this.nowMember=1;
        this.comment=comment;
        this.done=done;
    }

    public void update(String title,Long startDate,Long endDate
            ,String theme, int maxMember, int nowMember
            ,String comment,boolean done){
        this.title=title;
        this.startDate=startDate;
        this.endDate=endDate;
        this.theme=theme;
        this.maxMember=maxMember;
        this.nowMember=nowMember;
        this.comment=comment;
        this.done=done;
    }

}
