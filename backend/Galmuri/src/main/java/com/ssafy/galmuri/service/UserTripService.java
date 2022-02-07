package com.ssafy.galmuri.service;

import com.ssafy.galmuri.domain.usertrip.UserTrip;
import com.ssafy.galmuri.domain.usertrip.UserTripID;
import com.ssafy.galmuri.dto.usertrip.UserTripCreateDto;
import com.ssafy.galmuri.dto.usertrip.UserTripReadDto;
import com.ssafy.galmuri.dto.usertrip.UserTripUpdateDto;
import com.ssafy.galmuri.repository.usertrip.UserTripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserTripService {
    private final UserTripRepository userTripRepository;
    @Transactional
    public UserTripID save(UserTripCreateDto createDto){
        UserTrip userTrip=userTripRepository.save(createDto.toEntity());
        return new UserTripID(userTrip.getUser().getUserId(),userTrip.getUser().getDomain(), userTrip.getTripId().getTripId());
    }
    @Transactional
    public UserTripID update(String userId, Character domain, Long tripId, UserTripUpdateDto updateDto){
        UserTripID userTripID= new UserTripID(userId,domain,tripId);
        UserTrip userTrip=userTripRepository.findById(userTripID).orElseThrow(()->new IllegalArgumentException("존재하지 않습니다."));
        userTrip.update(updateDto.isConfirmed(),updateDto.isOwn());
        return userTripID;
    }
    public UserTripReadDto findByUserAndTrip(String userId,Character domain,Long tripId){
        UserTrip userTrip=userTripRepository
                .findById(new UserTripID(userId,domain,tripId))
                .orElseThrow(()->new IllegalArgumentException("존재하지 않습니다."));
        return new UserTripReadDto(userTrip);
    }
    @Transactional
    public UserTripID deleteByUserAndTrip(String userId,Character domain,Long tripId){
        UserTripID userTripID= new UserTripID(userId,domain,tripId);
        userTripRepository.deleteById(userTripID);
        return userTripID;
    }
}
