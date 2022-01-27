package com.ssafy.galmuri.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.galmuri.model.dto.ScheduleDto;
import com.ssafy.galmuri.model.dto.TripDto;


public interface GalmuriTripService {
	int insertTrip(TripDto tripDto) throws SQLException;
	int insertSchedule(List<ScheduleDto> schedule) throws SQLException;
	TripDto tripInfo(int tripId) throws SQLException;
	List<TripDto> findByUserId(String hostId, char hostDomain) throws SQLException;
	List<ScheduleDto> scheduleList(int TripId) throws SQLException;
	int updateTrip(TripDto tripDto) throws SQLException; 
	int updateSchedule(ScheduleDto scheduleDto) throws SQLException;
	int deleteTrip(int tripId) throws SQLException;
	int deleteAllSchedule(int tripId) throws SQLException;
	int deleteSchedule(int tripId,int tripOrder) throws SQLException;
}
