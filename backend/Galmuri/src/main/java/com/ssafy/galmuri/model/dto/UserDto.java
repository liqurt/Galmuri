package com.ssafy.galmuri.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
	@ApiModelProperty(value = "회원 아이디", required = true, example = "cdh6006@gmail.com")
	private String userId;
	@ApiModelProperty(value = "소셜 로그인 종류", required = true, example = "g")
	private char domain;
	@ApiModelProperty(value = "나이", required = true, example = "28")
	private int age;
	@ApiModelProperty(value = "성별 (false=남성, true=여성)", required = true, example = "false")
	private boolean gender;	
	@ApiModelProperty(value = "별명(이름)", required = true, example = "최대호")
	private String nickname;
	@ApiModelProperty(value = "총 별점의 합", required = false, example = "50.0")
	private float totalScore;
	@ApiModelProperty(value = "별점준 사람의 수", required = false, example = "10")
	private int totalVote;
	@ApiModelProperty(value = "관심국가", required = false, example = "KOR")
	private String favoriteCountry;
	@ApiModelProperty(value = "페이스북 아이디", required = false, example = "cdh6006@gmail.com")
	private String facebook;
	@ApiModelProperty(value = "트위터 아이디", required = false, example = "cdh6006@gmail.com")
	private String twitter;
	@ApiModelProperty(value = "인스타그램 아이디", required = false, example = "cdh6006@gmail.com")
	private String instagram;
	
}
