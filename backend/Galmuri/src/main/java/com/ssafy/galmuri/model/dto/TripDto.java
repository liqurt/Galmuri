package com.ssafy.galmuri.model.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TripDto {
	@ApiModelProperty(value="여행계획 아이디. DB에 의해서 자동으로 생성됨", required = false, example = "1")
	private int tripid;
	@ApiModelProperty(value="제목",required = true,example = "유럽 여행 계획")
	private String title;
	@ApiModelProperty(value="작성자 아이디",required = true,example = "cdh6006@gmail.com")
	private String hostId;
	@ApiModelProperty(value="작성자 도메인",required = true,example = "g")
	private char hostDomain;
	@ApiModelProperty(value="작성 일자. DB에 의해서 자동으로 생성된다.",required = false,example = "2022-01-24 14:48:10")
	private Timestamp uploadDate;
	@ApiModelProperty(value="여행 출발 일자",required = true,example = "2022-02-20")
	private Date startDate;
	@ApiModelProperty(value="여행 종료 일자",required = true,example = "2022-02-21")
	private Date endDate;
	@ApiModelProperty(value="여행 테마",required = true,example = "유럽 여행")
	private String theme;
	@ApiModelProperty(value="최대 인원수",required = true,example = "3")
	private int maxMember;
	@ApiModelProperty(value="현재 인원수. DB에 의해서 자동으로 1로 생성된다.",required = false, example = "1")
	private int nowMember;
	@ApiModelProperty(value="내용",required = true,example = "제가 2022년에 유럽에 있었을 때....")
	private String comment;
	@ApiModelProperty(value="종료 여부(f/t)",required = true,example = "false")
	private boolean isDone;
	@ApiModelProperty(value="스케쥴(여행 순서) 목록",required = true)
	private List<ScheduleDto> schedule;
}
