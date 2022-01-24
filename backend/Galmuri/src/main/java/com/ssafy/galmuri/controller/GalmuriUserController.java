package com.ssafy.galmuri.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
