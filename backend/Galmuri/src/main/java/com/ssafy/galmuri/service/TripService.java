package com.ssafy.galmuri.service;

import com.ssafy.galmuri.domain.trip.Trip;
import com.ssafy.galmuri.dto.TripCreateDto;
import com.ssafy.galmuri.dto.TripReadDto;
import com.ssafy.galmuri.dto.TripUpdateDto;
import com.ssafy.galmuri.repository.trip.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TripService {
    private final TripRepository tripRepository;

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
    @Transactional
    public Long deleteById(Long tripId){
        tripRepository.deleteById(tripId);
        return tripId;
    }

}
