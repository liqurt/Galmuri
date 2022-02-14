package com.ssafy.galmuri.dto.usertrip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTripUpdateDto {
    private boolean confirmed;
    private boolean own;
}
