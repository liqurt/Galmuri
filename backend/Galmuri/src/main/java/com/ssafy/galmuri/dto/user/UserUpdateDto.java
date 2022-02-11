package com.ssafy.galmuri.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateDto {
    private int age;
    private boolean gender;
    private String nickName;
    private String countryCode;
    private int totalVote;
    private float totalScore;
    private String facebook;
    private String instagram;
    private String twitter;
    private String comment;
    private Long birth;
    private String photoUrl;
}
