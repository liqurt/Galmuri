package com.ssafy.galmuri.repository;

import com.ssafy.galmuri.domain.user.UserTrip;
import com.ssafy.galmuri.domain.user.UserTripID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTripRepository extends JpaRepository<UserTrip, UserTripID> {
}
