package com.ssafy.galmuri.repository.trip;

import com.ssafy.galmuri.domain.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip,Long> {
}
