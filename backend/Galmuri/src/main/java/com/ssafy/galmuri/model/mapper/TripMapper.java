package com.ssafy.galmuri.model.mapper;

import java.util.List;

import com.ssafy.galmuri.model.dto.ScheduleDto;
import com.ssafy.galmuri.model.dto.TripDto;

public interface TripMapper {
	int insertTrip(TripDto tripDto);
	int insertSchedule(List<ScheduleDto> schedule);
	TripDto TripInfo(int tripId);
	List<TripDto> findByUserId(String hostId, char hostDomain);
	List<ScheduleDto> scheduleList(int TripId);
	int updateTrip(TripDto tripDto);
	int updateSchedule(ScheduleDto scheduleDto);
	int deleteTrip(int tripId);
	int deleteAllSchedule(int tripId);
	int deleteSchedule(int tripId,int tripOrder);
}
