package com.ssafy.galmuri.domain.trip;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ScheduleID {
    @ManyToOne
    @JoinColumn(name = "tripId",referencedColumnName = "tripId",nullable = false)
    private Trip trip;

    @Column(nullable = false)
    private int tripOrder;
}
