package com.ssafy.galmuri.dto.user;

import com.ssafy.galmuri.domain.user.User;
import lombok.Getter;

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
    private String comment;
    private Long birth;
    private String photoUrl;

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
        this.comment=user.getComment();
        this.birth=user.getBirth();
        this.photoUrl=user.getPhotoUrl();
    }
}
