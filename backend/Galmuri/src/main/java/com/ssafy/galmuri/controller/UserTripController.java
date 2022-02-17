package com.ssafy.galmuri.controller;

import com.ssafy.galmuri.domain.trip.Trip;
import com.ssafy.galmuri.domain.user.User;
import com.ssafy.galmuri.domain.usertrip.UserTrip;
import com.ssafy.galmuri.domain.usertrip.UserTripID;
import com.ssafy.galmuri.dto.trip.TripReadDto;
import com.ssafy.galmuri.dto.user.UserReadDto;
import com.ssafy.galmuri.dto.usertrip.UserTripCreateDto;
import com.ssafy.galmuri.dto.usertrip.UserTripReadDto;
import com.ssafy.galmuri.dto.usertrip.UserTripUpdateDto;
import com.ssafy.galmuri.service.TripService;
import com.ssafy.galmuri.service.UserService;
import com.ssafy.galmuri.service.UserTripService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/userTrip")
public class UserTripController {
    private UserTripService userTripService;
    private UserService userService;
    private TripService tripService;
    @PostMapping("/register")
    public UserTripID save(@RequestBody UserTripCreateDto createDto){
        User user=userService.findUserByIdAndDomain(createDto.getUserId(), createDto.getDomain());
        Trip trip=tripService.findTripById(createDto.getTripId());
        return userTripService.save(createDto,user,trip);
    }
    @GetMapping("/find/{userId}/{domain}/{tripId}")
    public UserTripReadDto findByIdAndDomain(@PathVariable String userId, @PathVariable Character domain, @PathVariable Long tripId){
        return userTripService.findByUserAndTrip(userId,domain,tripId);
    }
    @GetMapping("/find/{userId}/{domain}")
    public List<TripReadDto> findByUser(@PathVariable String userId, @PathVariable Character domain){
        List<UserTrip> userTripList=userTripService.findAllByUser(userId,domain);
        List<TripReadDto> tripList=new ArrayList<>();
        for(UserTrip userTrip:userTripList){
            tripList.add(new TripReadDto(userTrip.getTrip()));
        }
        return tripList;
    }
    @GetMapping("/find/{tripId}")
    public List<UserReadDto> findByTrip(@PathVariable Long tripId){
        List<UserTrip> userTripList=userTripService.findAllByTrip(tripId);
        List<UserReadDto> userList=new ArrayList<>();
        for(UserTrip userTrip:userTripList){
            userList.add(new UserReadDto(userTrip.getUser()));
        }
        return userList;
    }
    @GetMapping("/own/{userId}/{domain}/{tripId}")
    public Boolean isOwn(@PathVariable String userId, @PathVariable Character domain, @PathVariable Long tripId){
        return userTripService.findByUserAndTrip(userId,domain,tripId).isOwn();
    }
    @PutMapping("/update/{userId}/{domain}/{tripId}")
    public UserTripID update(@PathVariable String userId,@PathVariable Character domain,@PathVariable Long tripId, @RequestBody UserTripUpdateDto updateDto){
        return userTripService.update(userId,domain,tripId,updateDto);
    }
    @DeleteMapping("/delete/{userId}/{domain}/{tripId}")
    public UserTripID deleteByIdAndDomain(@PathVariable String userId,@PathVariable Character domain,@PathVariable Long tripId){
        return userTripService.deleteByUserAndTrip(userId,domain,tripId);
    }
}
