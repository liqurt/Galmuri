package com.ssafy.galmuri.service;

import com.ssafy.galmuri.domain.trip.Schedule;
import com.ssafy.galmuri.domain.trip.ScheduleID;
import com.ssafy.galmuri.domain.trip.Trip;
import com.ssafy.galmuri.dto.trip.ScheduleCreateDto;
import com.ssafy.galmuri.dto.trip.ScheduleReadDto;
import com.ssafy.galmuri.dto.trip.ScheduleUpdateDto;
import com.ssafy.galmuri.repository.trip.ScheduleRepository;
import com.ssafy.galmuri.repository.trip.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final TripRepository tripRepository;
    @Transactional
    public ScheduleID save(ScheduleCreateDto createDto){
        Trip trip=tripRepository.findById(createDto.getTripId()).orElseThrow(()->new IllegalArgumentException("해당하는 여행이 없습니다."));

        return new ScheduleID(scheduleRepository.save(Schedule.builder()
                                                .trip(trip)
                                                .tripOrder(createDto.getTripOrder())
                                                .time(createDto.getTime())
                                                .location(createDto.getLocation())
                                                .country(createDto.getCountryCode())
                                                .longitude(createDto.getLongitude())
                                                .latitude(createDto.getLatitude())
                                            .build()));
    }
    @Transactional
    public ScheduleID update(Long tripId,int order,ScheduleUpdateDto updateDto){
        Schedule schedule=
                scheduleRepository.findById(new ScheduleID(tripId,order))
                .orElseThrow(()->new IllegalArgumentException("해당 스케쥴이 없습니다."));
        schedule.update(updateDto.getTime(), updateDto.getLocation()
                ,updateDto.getCountryCode(),updateDto.getLatitude(),updateDto.getLongitude());
        return new ScheduleID(schedule);
    }
    public ScheduleReadDto findByIdAndOrder(Long tripId, int order){
        Schedule schedule=scheduleRepository
                .findById(new ScheduleID(tripId,order))
                .orElseThrow(()->new IllegalArgumentException("해당 스케쥴이 없습니다."));
        return new ScheduleReadDto(schedule);
    }
    public List<Schedule> findAllByTripId(Long tripId) {
        Trip trip = tripRepository.findById(tripId).orElseThrow(() -> new IllegalArgumentException("해당하는 여행이 없습니다."));
        return scheduleRepository.findAllByTrip(trip);
    }

    @Transactional
    public ScheduleID deleteByIdAndOrder(Long tripId,int order){
        ScheduleID scheduleID=new ScheduleID(tripId,order);
        scheduleRepository.deleteById(scheduleID);
        return scheduleID;
    }

}
