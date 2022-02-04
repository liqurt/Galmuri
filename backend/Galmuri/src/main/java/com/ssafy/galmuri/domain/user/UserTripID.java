package com.ssafy.galmuri.domain.user;

import com.ssafy.galmuri.domain.trip.Trip;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserTripID implements Serializable {
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "userId"),
            @JoinColumn(name = "domain")
    })
    private User user;

    @ManyToOne
    @JoinColumn(name = "tripId")
    private Trip trip;
}
