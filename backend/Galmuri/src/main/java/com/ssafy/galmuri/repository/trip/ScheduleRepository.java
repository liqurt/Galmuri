package com.ssafy.galmuri.repository.trip;

import com.ssafy.galmuri.domain.trip.Schedule;
import com.ssafy.galmuri.domain.trip.ScheduleID;
import com.ssafy.galmuri.domain.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, ScheduleID> {
    List<Schedule> findAllByTrip(Trip trip);
}
