package com.ssafy.galmuri.dto;

import com.ssafy.galmuri.domain.trip.Country;
import com.ssafy.galmuri.domain.user.User;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
public class UserReadDto {
    private String userId;
    private char domain;
    private int age;
    private boolean gender;
    private String nickName;
    private float totalScore;
    private int totalVote;
    private String countryCode;
    private String facebook;
    private String instagram;
    private String twitter;

    public UserReadDto(User user){
        this.userId=user.getUserId();
        this.domain=user.getDomain();
        this.age=user.getAge();
        this.gender=user.isGender();
        this.nickName=user.getNickName();
        this.totalScore=user.getTotalScore();
        this.totalVote=user.getTotalVote();
        this.countryCode=user.getCountryCode().getCountryCode();
        this.facebook=user.getFacebook();
        this.instagram=user.getInstagram();
        this.twitter=user.getTwitter();
    }
}
