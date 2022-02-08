package com.ssafy.galmuri.repository.usertrip;

import com.ssafy.galmuri.domain.usertrip.UserTrip;
import com.ssafy.galmuri.domain.usertrip.UserTripID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTripRepository extends JpaRepository<UserTrip, UserTripID> {
}
