package com.ssafy.galmuri.domain.trip;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@IdClass(ScheduleID.class)
@Entity
public class Schedule {
    @Id
    @ManyToOne
    @JoinColumn(name = "tripId", referencedColumnName = "tripId")
    private Trip tripId;

    @Id
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

    @Builder
    public Schedule(Long tripId,int tripOrder,LocalDateTime time,
            String location,String country,float latitude, float longitude){
        this.tripId=new Trip(tripId);
        this.tripOrder=tripOrder;
        this.time=time;
        this.location=location;
        this.country=new Country(country);
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public void update(LocalDateTime time,String location,String country,float latitude, float longitude){
        this.time=time;
        this.location=location;
        this.country=new Country(country);
        this.latitude=latitude;
        this.longitude=longitude;
    }

}
