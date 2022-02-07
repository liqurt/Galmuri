package com.ssafy.galmuri.repository.trip;

import com.ssafy.galmuri.domain.trip.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
