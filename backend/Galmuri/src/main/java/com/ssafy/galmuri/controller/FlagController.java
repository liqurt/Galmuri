package com.ssafy.galmuri.controller;

import com.ssafy.galmuri.domain.trip.ScheduleID;
import com.ssafy.galmuri.dto.flag.FlagDto;
import com.ssafy.galmuri.service.FlagService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/flag")
public class FlagController {
    private FlagService flagService;
    @PostMapping("/save")
    public String save(@RequestBody FlagDto flagDto){
        return flagService.save(flagDto);
    }
    @GetMapping("/read/{countryCode}")
    public FlagDto read(@PathVariable String countryCode){
        return flagService.read(countryCode);
    }
    @PutMapping("/update/{countryCode}")
    public String update(@PathVariable String countryCode, @RequestBody String url){
        return flagService.update(countryCode,url);
    }
    @DeleteMapping("/delete/{countryCode}")
    public String deleteByIdAndOrder(@PathVariable String countryCode){
        return flagService.delete(countryCode);
    }
}
