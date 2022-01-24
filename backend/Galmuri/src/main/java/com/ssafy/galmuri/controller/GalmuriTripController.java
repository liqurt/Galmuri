package com.ssafy.galmuri.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.galmuri.model.dto.ScheduleDto;
import com.ssafy.galmuri.model.dto.TripDto;
import com.ssafy.galmuri.model.service.GalmuriTripService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/trip")
public class GalmuriTripController {
	@Autowired
	GalmuriTripService galmuriTripService;
	
	@ApiOperation(value = "여행 등록", notes="여행을 등록합니다.")
	@PostMapping("/insertTrip")
	public ResponseEntity<Map<String, Object>> insertTrip(@RequestBody TripDto tripDto){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			int result=galmuriTripService.insertTrip(tripDto);
			if(result!=0) resultMap.put("message","success");
			else resultMap.put("message", "fail");
			status=HttpStatus.ACCEPTED;
		}
		catch(Exception e){
			resultMap.put("message",e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	@ApiOperation(value = "스케쥴 등록", notes="스케쥴을 등록합니다.")
	@PostMapping("/insertSchedule")
	public ResponseEntity<Map<String, Object>> insertSchedule(@RequestBody List<ScheduleDto> schedule){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			int result=galmuriTripService.insertSchedule(schedule);
			if(result!=0) resultMap.put("message","success");
			else resultMap.put("message", "fail");
			status=HttpStatus.ACCEPTED;
		}
		catch(Exception e){
			resultMap.put("message",e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	@ApiOperation(value = "여행과 스케쥴 등록", notes="여행과 스케쥴을 등록합니다.")
	@PostMapping("/insertAll")
	public ResponseEntity<Map<String, Object>> insertAll(@RequestBody TripDto tripDto){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			int result1=galmuriTripService.insertTrip(tripDto);
			int result2=galmuriTripService.insertSchedule(tripDto.getSchedule());
			if(result1!=0&&result2!=0) resultMap.put("message","success");
			else resultMap.put("message", "fail");
			status=HttpStatus.ACCEPTED;
		}
		catch(Exception e){
			resultMap.put("message",e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	
}
