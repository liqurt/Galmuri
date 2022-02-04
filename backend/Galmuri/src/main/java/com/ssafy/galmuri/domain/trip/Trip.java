package com.ssafy.galmuri.domain.trip;

import com.ssafy.galmuri.domain.BaseTimeEntity;
import com.ssafy.galmuri.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trip extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripId;

    @Column(nullable = false)
    private String title;

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

}
