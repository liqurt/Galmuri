package com.ssafy.galmuri.domain.usertrip;

import com.ssafy.galmuri.domain.user.UserID;
import lombok.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class UserTripID implements Serializable {
    private UserID user;
    private Long tripId;

    public UserTripID(String userId,Character domain,Long tripId){
        this.user=new UserID(userId,domain);
        this.tripId=tripId;
    }

}
