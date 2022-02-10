package com.ssafy.galmuri.dto.usertrip;

import com.ssafy.galmuri.domain.usertrip.UserTrip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTripReadDto {
    private String userId;
    private char domain;
    private Long tripId;
    private boolean confirmed;
    private boolean own;

    public UserTripReadDto(UserTrip userTrip){
        this.userId=userTrip.getUser().getUserId();
        this.domain=userTrip.getUser().getDomain();
        this.tripId=userTrip.getTrip().getTripId();
        this.confirmed=userTrip.isConfirmed();
        this.own=userTrip.isOwn();
    }
}
