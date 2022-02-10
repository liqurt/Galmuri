package com.ssafy.galmuri.domain.usertrip;

import com.ssafy.galmuri.domain.trip.Trip;
import com.ssafy.galmuri.domain.user.User;
import lombok.Builder;
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
    private Trip trip;

    @Column(nullable = false)
    private boolean confirmed;

    @Column(nullable = false)
    private boolean own;

    @Builder
    public UserTrip(User user,Trip trip,boolean confirmed,boolean own){
        this.user=user;
        this.trip=trip;
        this.confirmed=confirmed;
        this.own=own;
    }
    @Builder
    public UserTrip(String userId,Character domain,Long tripId,boolean confirmed,boolean own){
        this.user=new User(userId,domain);
        this.trip=new Trip(tripId);
        this.confirmed=confirmed;
        this.own=own;
    }
    public void update(boolean confirmed,boolean own){
        this.confirmed=confirmed;
        this.own=own;
    }
    @Override
    public String toString(){
        return user+" tripId : "+trip+" confirmed : "+confirmed+" own : "+own;
    }

}
