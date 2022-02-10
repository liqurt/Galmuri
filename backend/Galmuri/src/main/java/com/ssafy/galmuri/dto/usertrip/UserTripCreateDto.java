package com.ssafy.galmuri.dto.usertrip;

import com.ssafy.galmuri.domain.usertrip.UserTrip;
import com.ssafy.galmuri.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTripCreateDto {
    private String userId;
    private char domain;
    private Long tripId;
    private boolean confirmed;
    private boolean own;

    public UserTrip toEntity(){
        return new UserTrip(userId,domain,tripId,confirmed,own);
    }
}
