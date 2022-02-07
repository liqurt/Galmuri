package com.ssafy.galmuri.repository.trip;

import com.ssafy.galmuri.domain.trip.TripAgeRange;
import com.ssafy.galmuri.domain.trip.TripAgeRangeID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripAgeRepository extends JpaRepository<TripAgeRange, TripAgeRangeID> {
}
