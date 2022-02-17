package com.ssafy.galmuri.controller;

import com.ssafy.galmuri.domain.trip.Trip;
import com.ssafy.galmuri.dto.trip.TripCreateDto;
import com.ssafy.galmuri.dto.trip.TripReadDto;
import com.ssafy.galmuri.dto.trip.TripUpdateDto;
import com.ssafy.galmuri.service.TripService;
import com.ssafy.galmuri.service.UserTripService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/trip")
public class TripController {
    private TripService tripService;
    @PostMapping("/register")
    public Long save(@RequestBody TripCreateDto createDto){
        return tripService.save(createDto);
    }
    @GetMapping("/find")
    public List<TripReadDto> findAll(){
        List<Trip> trips=tripService.findAllTrip();
        List<TripReadDto> list=new ArrayList<>();
        for(Trip trip:trips){
            list.add(new TripReadDto(trip));
        }
        return list;
    }
    @GetMapping("/find/{tripId}")
    public TripReadDto findById(@PathVariable Long tripId){
        return tripService.findById(tripId);
    }
    @GetMapping("/continent/{continent}")
    public List<TripReadDto> findByContinent(@PathVariable String continent){
        List<Trip> trips=tripService.findAllTripByContinent(continent);
        List<TripReadDto> list=new ArrayList<>();
        for(Trip trip:trips){
            list.add(new TripReadDto(trip));
        }
        return list;
    }
    @PutMapping("/update/{tripId}")
    public Long update(@PathVariable Long tripId,@RequestBody TripUpdateDto updateDto){
        return tripService.update(tripId,updateDto);
    }
    @DeleteMapping("/delete/{tripId}")
    public Long deleteById(@PathVariable Long tripId){
        return tripService.deleteById(tripId);
    }
}
