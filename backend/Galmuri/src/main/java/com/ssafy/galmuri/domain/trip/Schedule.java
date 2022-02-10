package com.ssafy.galmuri.domain.trip;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@IdClass(ScheduleID.class)
@Entity
public class Schedule {
    @Id
    @ManyToOne
    @JoinColumn(name = "tripId", referencedColumnName = "tripId")
    private Trip trip;

    @Id
    private int tripOrder;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date time;

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
    public Schedule(Trip trip,int tripOrder,Date time,
                    String location,String country,float latitude, float longitude){
        this.trip=trip;
        this.tripOrder=tripOrder;
        this.time=time;
        this.location=location;
        this.country=new Country(country);
        this.latitude=latitude;
        this.longitude=longitude;
    }
    public void update(Date time,String location,String country,float latitude, float longitude){
        this.time=time;
        this.location=location;
        this.country=new Country(country);
        this.latitude=latitude;
        this.longitude=longitude;
    }

}
