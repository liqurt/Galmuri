package com.ssafy.galmuri.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//C
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
			if(result!=0) {resultMap.put("message","success");}
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
	
	//R
	@ApiOperation(value = "여행 상세 정보 검색", notes="여행의 상세정보와 스케쥴을 가져옵니다.")
	@GetMapping("/searchTrip/tripId={tripId}")
	public ResponseEntity<Map<String, Object>> searchTrip(@PathVariable int tripId){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			TripDto result=galmuriTripService.tripInfo(tripId);
			if(result!=null) {
				result.setSchedule(galmuriTripService.scheduleList(tripId));
				System.out.println(result);
				resultMap.put("tripInfo", result);
				resultMap.put("message","success");
			}
			else resultMap.put("message", "fail");
			status=HttpStatus.ACCEPTED;
		}
		catch(Exception e) {
			resultMap.put("message",e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	@ApiOperation(value = "스케쥴 정보 검색", notes="여행계획 아이디를 기준으로 스케쥴을 가져옵니다.")
	@GetMapping("/searchSchedule/tripId={tripId}")
	public ResponseEntity<Map<String, Object>> searchSchedule(@PathVariable int tripId){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			List<ScheduleDto> result=galmuriTripService.scheduleList(tripId);
			if(result!=null) {
				resultMap.put("tripInfo", result);
				resultMap.put("message","success");
			}
			else resultMap.put("message", "fail");
			status=HttpStatus.ACCEPTED;
		}
		catch(Exception e) {
			resultMap.put("message",e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "아이디별 여행계획 검색", notes="사용자 아이디를 기준으로 검색해서 리스트로 반환")
	@GetMapping("/searchTrip/userId={userId}&userDomain={userDomain}")
	public ResponseEntity<Map<String, Object>> searchTripbyUserName(@PathVariable String userId,@PathVariable char userDomain){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			List<TripDto> result=galmuriTripService.findByUserId(userId, userDomain);
			if(result!=null) {
				resultMap.put("tripList", result);
				resultMap.put("message","success");
			}
			else resultMap.put("message", "fail");
			status=HttpStatus.ACCEPTED;
		}
		catch(Exception e) {
			resultMap.put("message",e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	//U
	@ApiOperation(value = "여행계획 수정",notes = "TripDto의 tripId를 기준으로 여행계획을 수정한다. ")
	@PutMapping("/updateTrip")
	public ResponseEntity<Map<String, Object>> updateTrip(@RequestBody TripDto tripDto){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			int result=galmuriTripService.updateTrip(tripDto);
			if(result!=0) resultMap.put("message","success");
			else resultMap.put("message", "fail");
			status=HttpStatus.ACCEPTED;
		}
		catch(Exception e) {
			resultMap.put("message",e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	@ApiOperation(value = "스케쥴 수정",notes = "ScheduleDto의 tripId와 order를 기준으로 스케쥴을 수정한다.")
	@PutMapping("/updateSchedule")
	public ResponseEntity<Map<String, Object>> updateSchedule(@RequestBody ScheduleDto scheduleDto){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			int result=galmuriTripService.updateSchedule(scheduleDto);
			if(result!=0) resultMap.put("message","success");
			else resultMap.put("message", "fail");
			status=HttpStatus.ACCEPTED;
		}
		catch(Exception e) {
			resultMap.put("message",e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	@ApiOperation(value="여행계획 삭제",notes="여행계획을 삭제한다. 스케쥴도 DB CASCADE옵션으로 인해 같이 삭제된다.")
	@DeleteMapping("/deleteTrip/tripId={tripId}")
	public ResponseEntity<Map<String,Object>> deleteTrip(@PathVariable int tripId){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			int result=galmuriTripService.deleteTrip(tripId);
			if(result!=0) resultMap.put("message","success");
			else resultMap.put("message", "fail");
			status=HttpStatus.ACCEPTED;
		}
		catch(Exception e) {
			resultMap.put("message",e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	@ApiOperation(value="모든 스케쥴 삭제",notes="여행계획의 tripId를 기준으로 모든 스케쥴을 삭제한다.")
	@DeleteMapping("/deleteAllSchedule/tripId={tripId}")
	public ResponseEntity<Map<String,Object>> deleteAllSchedule(@PathVariable int tripId){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			int result=galmuriTripService.deleteAllSchedule(tripId);
			if(result!=0) resultMap.put("message","success");
			else resultMap.put("message", "fail");
			status=HttpStatus.ACCEPTED;
		}
		catch(Exception e) {
			resultMap.put("message",e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	@ApiOperation(value="스케쥴 삭제",notes="tripId와 tripOrder 기준으로 모든 스케쥴을 삭제한다.")
	@DeleteMapping("/deleteSchedule/tripId={tripId}&tripOrder={tripOrder}")
	public ResponseEntity<Map<String,Object>> deleteSchedule(@PathVariable int tripId,@PathVariable int tripOrder){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			int result=galmuriTripService.deleteSchedule(tripId, tripOrder);
			if(result!=0) resultMap.put("message","success");
			else resultMap.put("message", "fail");
			status=HttpStatus.ACCEPTED;
		}
		catch(Exception e) {
			resultMap.put("message",e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
}
