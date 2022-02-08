package com.ssafy.galmuri.service;

import com.ssafy.galmuri.domain.trip.TripAgeRange;
import com.ssafy.galmuri.domain.trip.TripAgeRangeID;
import com.ssafy.galmuri.dto.trip.TripAgeRangeCreateDto;
import com.ssafy.galmuri.dto.trip.TripAgeRangeReadDto;
import com.ssafy.galmuri.dto.trip.TripAgeRangeUpdateDto;
import com.ssafy.galmuri.repository.trip.TripAgeRangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TripAgeRangeService {
    private final TripAgeRangeRepository repository;
    @Transactional
    public TripAgeRangeID save(TripAgeRangeCreateDto createDto){
        return new TripAgeRangeID(repository.save(createDto.toEntity()));
    }
    public TripAgeRangeReadDto findByTripAndRange(Long tripId,int ageRange){
        TripAgeRange tripAgeRange=repository.findById(new TripAgeRangeID(tripId,ageRange)).orElseThrow(()->new IllegalArgumentException("해당 연령제한이 없습니다."));
        return new TripAgeRangeReadDto(tripAgeRange);
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
