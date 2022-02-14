package com.ssafy.galmuri.controller;

import com.ssafy.galmuri.domain.trip.TripAgeRange;
import com.ssafy.galmuri.domain.trip.TripAgeRangeID;
import com.ssafy.galmuri.dto.trip.TripAgeRangeCreateDto;
import com.ssafy.galmuri.dto.trip.TripAgeRangeReadDto;
import com.ssafy.galmuri.dto.trip.TripAgeRangeUpdateDto;
import com.ssafy.galmuri.service.TripAgeRangeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/tripAge")
public class TripAgeRangeController {
    private TripAgeRangeService service;
    @PostMapping("/register")
    public TripAgeRangeID save(@RequestBody TripAgeRangeCreateDto createDto){
        return service.save(createDto);
    }
    @GetMapping("/find/{tripId}/{ageRange}")
    public TripAgeRangeReadDto findByIdAndOrder(@PathVariable Long tripId, @PathVariable int ageRange){
        return service.findByTripAndRange(tripId,ageRange);
    }
    @GetMapping("/find/{tripId}")
    public List<TripAgeRangeReadDto> findAllByTripId(@PathVariable Long tripId){
        List<TripAgeRange> ageRangeList=service.findAllByTripId(tripId);
        List<TripAgeRangeReadDto> ageRangeReadDtoList=new ArrayList<>();
        for(TripAgeRange tripAgeRange:ageRangeList){
            ageRangeReadDtoList.add(new TripAgeRangeReadDto(tripAgeRange));
        }
        return ageRangeReadDtoList;
    }

//    @PutMapping("/update/{tripId}/{ageRange}")
//    public TripAgeRangeID update(@PathVariable Long tripId, @PathVariable int ageRange, @RequestBody TripAgeRangeUpdateDto updateDto){
//        return service.update(tripId,ageRange,updateDto);
//    }
    @DeleteMapping("/delete/{tripId}/{ageRange}")
    public TripAgeRangeID deleteByIdAndRange(@PathVariable Long tripId, @PathVariable int ageRange){
        return service.deleteByTripAndRange(tripId,ageRange);
    }
}
