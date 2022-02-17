package com.ssafy.galmuri.controller;

import com.ssafy.galmuri.domain.trip.Schedule;
import com.ssafy.galmuri.domain.trip.ScheduleID;
import com.ssafy.galmuri.dto.trip.ScheduleCreateDto;
import com.ssafy.galmuri.dto.trip.ScheduleReadDto;
import com.ssafy.galmuri.dto.trip.ScheduleUpdateDto;
import com.ssafy.galmuri.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private ScheduleService scheduleService;
    @PostMapping("/register")
    public ScheduleID save(@RequestBody ScheduleCreateDto scheduleCreateDto){
        return scheduleService.save(scheduleCreateDto);
    }
    @GetMapping("/find/{tripId}/{tripOrder}")
    public ScheduleReadDto findByIdAndOrder(@PathVariable Long tripId, @PathVariable int tripOrder){
        return scheduleService.findByIdAndOrder(tripId,tripOrder);
    }
    @GetMapping("/find/{tripId}")
    public List<ScheduleReadDto> findAllByTripId(@PathVariable Long tripId){
        List<Schedule> scheduleList=scheduleService.findAllByTripId(tripId);
        List<ScheduleReadDto> scheduleReadDtoList=new ArrayList<>();
        for(Schedule schedule:scheduleList){
            scheduleReadDtoList.add(new ScheduleReadDto(schedule));
        }
        return scheduleReadDtoList;
    }
    @PutMapping("/update/{tripId}/{tripOrder}")
    public ScheduleID update(@PathVariable Long tripId, @PathVariable int tripOrder, @RequestBody ScheduleUpdateDto updateDto){
        return scheduleService.update(tripId,tripOrder,updateDto);
    }
    @DeleteMapping("/delete/{tripId}/{tripOrder}")
    public ScheduleID deleteByIdAndOrder(@PathVariable Long tripId, @PathVariable int tripOrder){
        return scheduleService.deleteByIdAndOrder(tripId,tripOrder);
    }
    @DeleteMapping("/delete/{tripId}")
    public int deleteAllById(@PathVariable Long tripId){
        return scheduleService.deleteAllById(tripId);
    }
}
