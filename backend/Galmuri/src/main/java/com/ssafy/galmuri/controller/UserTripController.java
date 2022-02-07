package com.ssafy.galmuri.controller;

import com.ssafy.galmuri.domain.usertrip.UserTripID;
import com.ssafy.galmuri.dto.usertrip.UserTripCreateDto;
import com.ssafy.galmuri.dto.usertrip.UserTripReadDto;
import com.ssafy.galmuri.dto.usertrip.UserTripUpdateDto;
import com.ssafy.galmuri.service.UserTripService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/userTrip")
public class UserTripController {
    private UserTripService userTripService;
    @PostMapping("/register")
    public UserTripID save(@RequestBody UserTripCreateDto createDto){
        return userTripService.save(createDto);
    }
    @GetMapping("/find/{userId}/{domain}/{tripId}")
    public UserTripReadDto findByIdAndDomain(@PathVariable String userId, @PathVariable Character domain, @PathVariable Long tripId){
        return userTripService.findByUserAndTrip(userId,domain,tripId);
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
