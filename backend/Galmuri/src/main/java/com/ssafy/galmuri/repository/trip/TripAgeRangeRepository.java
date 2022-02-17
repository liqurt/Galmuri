package com.ssafy.galmuri.repository.trip;

import com.ssafy.galmuri.domain.trip.Trip;
import com.ssafy.galmuri.domain.trip.TripAgeRange;
import com.ssafy.galmuri.domain.trip.TripAgeRangeID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripAgeRangeRepository extends JpaRepository<TripAgeRange, TripAgeRangeID> {
    List<TripAgeRange> findAllByTrip(Trip trip);
}
