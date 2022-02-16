package com.ssafy.galmuri.dto.flag;

import com.ssafy.galmuri.domain.flag.Flag;
import com.ssafy.galmuri.domain.trip.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlagDto {
    String countryCode;
    String url;
}
