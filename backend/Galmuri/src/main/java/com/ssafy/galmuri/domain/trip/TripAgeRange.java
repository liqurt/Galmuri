package com.ssafy.galmuri.domain.trip;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@IdClass(TripAgeRangeID.class)
@Entity
public class TripAgeRange {
    @Id
    @ManyToOne
    @JoinColumn(name="tripId", referencedColumnName = "tripId")
    private Trip trip;

    @Id
    private int ageRange;

    public TripAgeRange(Trip trip,int ageRange){
        this.trip=trip;
        this.ageRange=ageRange;
    }
    public void update(int ageRange){
        this.ageRange=ageRange;
    }
}
