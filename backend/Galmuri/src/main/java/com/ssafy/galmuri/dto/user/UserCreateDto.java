package com.ssafy.galmuri.dto.user;

import com.ssafy.galmuri.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDto {
    private String userId;
    private char domain;
    private int age;
    private boolean gender;
    private String nickName;
    private String countryCode;
    private String facebook;
    private String instagram;
    private String twitter;

    public User toEntity(){
        return User.builder()
                .userId(userId)
                .domain(domain)
                .age(age)
                .gender(gender)
                .nickName(nickName)
                .countryCode(countryCode)
                .facebook(facebook)
                .instagram(instagram)
                .twitter(twitter)
                .build();
    }

}
