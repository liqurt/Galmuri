package com.ssafy.galmuri.service;

import com.ssafy.galmuri.domain.trip.Schedule;
import com.ssafy.galmuri.domain.trip.Trip;
import com.ssafy.galmuri.domain.user.User;
import com.ssafy.galmuri.domain.usertrip.UserTrip;
import com.ssafy.galmuri.dto.trip.TripCreateDto;
import com.ssafy.galmuri.dto.trip.TripReadDto;
import com.ssafy.galmuri.dto.trip.TripUpdateDto;
import com.ssafy.galmuri.repository.trip.CountryRepository;
import com.ssafy.galmuri.repository.trip.TripRepository;
import com.ssafy.galmuri.repository.usertrip.UserTripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TripService {
    private final TripRepository tripRepository;
    private final CountryRepository countryRepository;

    @Transactional
    public Long save(TripCreateDto createDto){
        return tripRepository.save(createDto.toEntity()).getTripId();
    }
    @Transactional
    public Long update(Long tripId, TripUpdateDto tripUpdateDto){
        Trip trip=tripRepository.findById(tripId)
                .orElseThrow(()->new IllegalArgumentException("해당 여행 계획이 존재하지 않습니다."));
        trip.update(tripUpdateDto.getTitle(),tripUpdateDto.getStartDate(),tripUpdateDto.getEndDate()
                    ,tripUpdateDto.getTheme(),tripUpdateDto.getMaxMember(),tripUpdateDto.getNowMember()
                    , tripUpdateDto.getComment(), tripUpdateDto.isDone());
        return trip.getTripId();
    }
    public TripReadDto findById(Long tripId){
        Trip trip=tripRepository.findById(tripId)
                .orElseThrow(()->new IllegalArgumentException("해당 여행 계획이 존재하지 않습니다."));
        return new TripReadDto(trip);
    }
    public Trip findTripById(Long tripId){
        Trip trip=tripRepository.findById(tripId)
                .orElseThrow(()->new IllegalArgumentException("해당 여행 계획이 존재하지 않습니다."));
        return trip;
    }
    public List<Trip> findAllTrip(){
        List<Trip> trips=tripRepository.findAll();
        return trips;
    }
    public List<Trip> findAllTripByContinent(String continent){
        List<Trip> trips=tripRepository.findAll();
        List<Trip> savingTrips=new ArrayList<>();
        for(Trip trip:trips){
            List<Schedule> schedules=trip.getSchedules();
            for(int i=0;i<schedules.size();i++){
                if(schedules.get(i).getTripOrder()==1) {
                    if(continent.equals(schedules.get(i).getCountry().getContinent())) savingTrips.add(trip);
                    break;
                }
            }
        }
        return savingTrips;
    }
    @Transactional
    public Long deleteById(Long tripId){
        tripRepository.deleteById(tripId);
        return tripId;
    }

}
