package com.ssafy.galmuri.domain.trip;

import com.ssafy.galmuri.domain.user.UserID;
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
    @JoinColumn(name="tripId")
    private Trip trip;

    @Id
    private int ageRange;

}
