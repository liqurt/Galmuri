package com.ssafy.galmuri.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.ssafy.galmuri.model.dto.UserDto;
import com.ssafy.galmuri.model.service.GalmuriUserService;


import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class GalmuriUserController {
	@Autowired
	private GalmuriUserService galmuriUserService;
	
	//C
	@ApiOperation(value = "회원 가입", notes="회원 가입을 한다.")
	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> signUp(@RequestBody UserDto userDto){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			int result1=galmuriUserService.signUp(userDto);
			int result2=galmuriUserService.insertOption(userDto);
			if(result1+result2!=0) resultMap.put("message","success");
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
	@ApiOperation(value = "회원 정보", notes="아이디와 도메인으로 회원 정보를 반환한다.")
	@GetMapping("/info/{userId}/{domain}")
	public ResponseEntity<Map<String, Object>> getUserInfo(@PathVariable String userId, @PathVariable String domain, HttpServletRequest request){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		UserDto result=null;
		try {
			result=galmuriUserService.userInfo(userId,domain.charAt(0));
			if(result!=null) {
				resultMap.put("userInfo", result);
				resultMap.put("message","success");
			}
			else resultMap.put("message", "fail");
			status=HttpStatus.ACCEPTED;
		}
		catch(Exception e){
			resultMap.put("message",e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		System.out.println(result);
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	//U
	@PutMapping("/updateUser")
	@ApiOperation(value = "회원 정보 변경", notes="옵션을 제외하고 회원 정보를 변경한다.")
	public ResponseEntity<Map<String, Object>> updateUser(@RequestBody UserDto userDto){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			int result=galmuriUserService.updateUser(userDto);
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
	@PutMapping("/updateOption")
	@ApiOperation(value = "회원 정보 변경", notes="회원 옵션 정보를 변경한다.")
	public ResponseEntity<Map<String, Object>> updateOption(@RequestBody UserDto userDto){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			int result=galmuriUserService.updateOption(userDto);
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
	
	//D
	@DeleteMapping("/deleteUser/{userId}/{domain}")
	public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable String userId, @PathVariable String domain, HttpServletRequest request){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		HttpStatus status=null;
		try {
			int result=galmuriUserService.deleteUser(userId, domain.charAt(0));
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
	
}
