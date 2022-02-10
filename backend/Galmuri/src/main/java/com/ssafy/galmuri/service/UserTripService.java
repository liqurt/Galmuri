package com.ssafy.galmuri.service;

import com.ssafy.galmuri.domain.trip.Trip;
import com.ssafy.galmuri.domain.user.User;
import com.ssafy.galmuri.domain.user.UserID;
import com.ssafy.galmuri.domain.usertrip.UserTrip;
import com.ssafy.galmuri.domain.usertrip.UserTripID;
import com.ssafy.galmuri.dto.usertrip.UserTripCreateDto;
import com.ssafy.galmuri.dto.usertrip.UserTripReadDto;
import com.ssafy.galmuri.dto.usertrip.UserTripUpdateDto;
import com.ssafy.galmuri.repository.trip.TripRepository;
import com.ssafy.galmuri.repository.user.UserRepository;
import com.ssafy.galmuri.repository.usertrip.UserTripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserTripService {
    private final UserRepository userRepository;
    private final TripRepository tripRepository;
    private final UserTripRepository userTripRepository;
    @Transactional
    public UserTripID save(UserTripCreateDto createDto, User user, Trip trip){
        UserTrip userTrip=new UserTrip(user,trip,createDto.isConfirmed(),createDto.isOwn());
        userTripRepository.save(userTrip);
        return new UserTripID(userTrip.getUser().getUserId(),userTrip.getUser().getDomain(), userTrip.getTrip().getTripId());
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
    public List<UserTrip> findAllByUser(String userId, Character domain){
        User user=userRepository.findById(new UserID(userId,domain)).orElseThrow(()->new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        List<UserTrip> userTrips=userTripRepository.findAllByUser(user);
        return userTrips;
    }
    public List<UserTrip> findAllByTrip(Long tripId){
        Trip trip=tripRepository.findById(tripId).orElseThrow(()->new IllegalArgumentException("해당하는 여행이 존재하지 않습니다."));
        List<UserTrip> userTrips=userTripRepository.findAllByTrip(trip);
        return userTrips;
    }

    @Transactional
    public UserTripID deleteByUserAndTrip(String userId,Character domain,Long tripId){
        UserTripID userTripID= new UserTripID(userId,domain,tripId);
        userTripRepository.deleteById(userTripID);
        return userTripID;
    }
}
