package com.ssafy.galmuri.domain.trip;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "tripId",referencedColumnName = "tripId",nullable = false)
    private Trip trip;

    @Column(nullable = false)
    private int tripOrder;

    @Column(nullable = false)
    private LocalDateTime time;

    @OneToOne
    @JoinColumn(name = "countryCode")
    private Country country;

    @Column(nullable = false)
    private String location;

    @Column
    private float latitude;

    @Column
    private float longitude;


}
