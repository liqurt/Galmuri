package com.ssafy.galmuri.domain.usertrip;

import com.ssafy.galmuri.domain.trip.Trip;
import com.ssafy.galmuri.domain.user.User;
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
            @JoinColumn(name = "domain"),
            @JoinColumn(name = "userId")
    })
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "tripId", referencedColumnName = "tripId")
    private Trip tripId;

    @Column(nullable = false)
    private boolean confirmed;

    @Column(nullable = false)
    private boolean own;


    public UserTrip(String userId,Character domain,Long tripId,boolean confirmed,boolean own){
        this.user=new User(userId,domain);
        this.tripId=new Trip(tripId);
        this.confirmed=confirmed;
        this.own=own;
    }
    public void update(boolean confirmed,boolean own){
        this.confirmed=confirmed;
        this.own=own;
    }
}
