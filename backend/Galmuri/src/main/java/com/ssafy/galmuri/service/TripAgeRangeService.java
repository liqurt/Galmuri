package com.ssafy.galmuri.service;

import com.ssafy.galmuri.domain.trip.Trip;
import com.ssafy.galmuri.domain.trip.TripAgeRange;
import com.ssafy.galmuri.domain.trip.TripAgeRangeID;
import com.ssafy.galmuri.dto.trip.TripAgeRangeCreateDto;
import com.ssafy.galmuri.dto.trip.TripAgeRangeReadDto;
import com.ssafy.galmuri.dto.trip.TripAgeRangeUpdateDto;
import com.ssafy.galmuri.repository.trip.TripAgeRangeRepository;
import com.ssafy.galmuri.repository.trip.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TripAgeRangeService {
    private final TripAgeRangeRepository repository;
    private final TripRepository tripRepository;
    @Transactional
    public TripAgeRangeID save(TripAgeRangeCreateDto createDto){
        Trip trip=tripRepository.findById(createDto.getTripId()).orElseThrow(()->new IllegalArgumentException("해당하는 여행이 없습니다."));
        return new TripAgeRangeID(repository.save(new TripAgeRange(trip,createDto.getAgeRange())));
    }
    public TripAgeRangeReadDto findByTripAndRange(Long tripId,int ageRange){
        TripAgeRange tripAgeRange=repository.findById(new TripAgeRangeID(tripId,ageRange)).orElseThrow(()->new IllegalArgumentException("해당 연령제한이 없습니다."));
        return new TripAgeRangeReadDto(tripAgeRange);
    }
    public List<TripAgeRange> findAllByTripId(Long tripId){
        Trip trip=tripRepository.findById(tripId).orElseThrow(()->new IllegalArgumentException("해당하는 여행이 없습니다."));
        return repository.findAllByTrip(trip);
    }
    @Transactional
    public TripAgeRangeID update(Long tripId,int ageRange,TripAgeRangeUpdateDto updateDto){
        TripAgeRange tripAgeRange=repository.findById(new TripAgeRangeID(tripId,ageRange)).orElseThrow(()->new IllegalArgumentException("해당 연령제한이 없습니다."));
        tripAgeRange.update(updateDto.getAgeRange());
        return new TripAgeRangeID(tripAgeRange);
    }
    @Transactional
    public TripAgeRangeID deleteByTripAndRange(Long tripId,int ageRange){
        repository.deleteById(new TripAgeRangeID(tripId,ageRange));
        return new TripAgeRangeID(tripId, ageRange);
    }
}
