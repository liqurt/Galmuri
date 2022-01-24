package com.ssafy.galmuri.model.dto;

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
public class ScheduleDto {
	@ApiModelProperty(value="여행계획 아이디", required = true, example = "1")
	private int tripId;
	@ApiModelProperty(value = "여행 국가",required = true, example="FRA")
	private String countryCode;
	@ApiModelProperty(value = "여행지",required = true,example = "Champ de Mars, 5 Av. Anatole France, 75007 Paris")
	private String locationName;
	@ApiModelProperty(value = "여행 순서",required = true, example = "1")
	private int tripOrder;
}
