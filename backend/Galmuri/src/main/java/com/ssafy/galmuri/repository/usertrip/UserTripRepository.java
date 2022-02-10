package com.ssafy.galmuri.repository.usertrip;

import com.ssafy.galmuri.domain.trip.Trip;
import com.ssafy.galmuri.domain.user.User;
import com.ssafy.galmuri.domain.usertrip.UserTrip;
import com.ssafy.galmuri.domain.usertrip.UserTripID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTripRepository extends JpaRepository<UserTrip, UserTripID> {
        List<UserTrip> findAllByUser(User user);
        List<UserTrip> findAllByTrip(Trip trip);
}
