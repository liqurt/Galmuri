package com.ssafy.galmuri.domain.user;

import com.ssafy.galmuri.domain.trip.Trip;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@IdClass(UserTripID.class)
@Entity
public class UserTrip {
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "userId"),
            @JoinColumn(name = "domain")
    })
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "tripId" )
    private Trip trip;

    @Column(nullable = false)
    private boolean isConfirmed;

    @Column(nullable = false)
    private boolean isOwn;
}
