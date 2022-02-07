package com.ssafy.galmuri.domain.trip;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TripAgeRangeID implements Serializable {
    @ManyToOne
    @JoinColumn(name="tripId")
    private Trip trip;
    private int ageRange;
}
