package com.ssafy.galmuri.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.galmuri.model.dto.ScheduleDto;
import com.ssafy.galmuri.model.dto.TripDto;
import com.ssafy.galmuri.model.mapper.TripMapper;

@Service
public class GalmuriTripServiceImpl implements GalmuriTripService {
	@Autowired
	private SqlSession sqlsession;
	@Override
	public int insertTrip(TripDto tripDto) throws SQLException {
		return sqlsession.getMapper(TripMapper.class).insertTrip(tripDto);
	}

	@Override
	public int insertSchedule(List<ScheduleDto> schedule) throws SQLException {
		return sqlsession.getMapper(TripMapper.class).insertSchedule(schedule);
	}

	@Override
	public TripDto tripInfo(int tripId) throws SQLException {
		return sqlsession.getMapper(TripMapper.class).tripInfo(tripId);
	}

	@Override
	public List<TripDto> findByUserId(String hostId, char hostDomain) throws SQLException {
		return sqlsession.getMapper(TripMapper.class).findByUserId(hostId, hostDomain);
	}

	@Override
	public List<ScheduleDto> scheduleList(int tripId) throws SQLException {
		return sqlsession.getMapper(TripMapper.class).scheduleList(tripId);
	}

	@Override
	public int updateTrip(TripDto tripDto) throws SQLException {
		return sqlsession.getMapper(TripMapper.class).updateTrip(tripDto);
	}

	@Override
	public int updateSchedule(ScheduleDto scheduleDto) throws SQLException {
		return sqlsession.getMapper(TripMapper.class).updateSchedule(scheduleDto);
	}

	@Override
	public int deleteTrip(int tripId) throws SQLException {
		return sqlsession.getMapper(TripMapper.class).deleteTrip(tripId);
	}

	@Override
	public int deleteAllSchedule(int tripId) throws SQLException {
		return sqlsession.getMapper(TripMapper.class).deleteAllSchedule(tripId);
	}

	@Override
	public int deleteSchedule(int tripId, int tripOrder) throws SQLException {
		return sqlsession.getMapper(TripMapper.class).deleteSchedule(tripId,tripOrder);
	}

}
