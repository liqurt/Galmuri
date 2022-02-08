package com.ssafy.galmuri.controller;

import com.ssafy.galmuri.dto.trip.TripCreateDto;
import com.ssafy.galmuri.dto.trip.TripReadDto;
import com.ssafy.galmuri.dto.trip.TripUpdateDto;
import com.ssafy.galmuri.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/trip")
public class TripController {
    private TripService tripService;
    @PostMapping("/register")
    public Long save(@RequestBody TripCreateDto createDto){
        return tripService.save(createDto);
    }
    @GetMapping("/find/{tripId}")
    public TripReadDto findByIdAndDomain(@PathVariable Long tripId){
        return tripService.findById(tripId);
    }
    @PutMapping("/update/{tripId}")
    public Long update(@PathVariable Long tripId,@RequestBody TripUpdateDto updateDto){
        return tripService.update(tripId,updateDto);
    }
    @DeleteMapping("/delete/{tripId}")
    public Long deleteByIdAndDomain(@PathVariable Long tripId){
        return tripService.deleteById(tripId);
    }
}
