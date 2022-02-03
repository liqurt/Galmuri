package com.ssafy.galmuri.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@NoArgsConstructor
@Entity
@IdClass(UserID.class)
public class User {
    @Id
    @Column(nullable = false)
    private String userId;

    @Id
    @Column(nullable = false)
    private char domain;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private boolean gender;

    @Column(nullable = false)
    private String nickName;

    @Column
    private float totalScore;

    @Column
    private int totalVote;

    @Column(length = 3)
    private String favoriteCountry;

    @Column
    private String facebook;

    @Column
    private String instagram;

    @Column
    private String twitter;

    @Builder
    public User(String userId,char domain, int age,boolean gender,String nickName){
        this.userId=userId;
        this.domain=domain;
        this.age=age;
        this.gender=gender;
        this.nickName=nickName;
        this.totalScore=0.0f;
        this.totalVote=0;
    }
    @Builder
    public User(String userId,char domain, int age,boolean gender,String nickName,String favoriteCountry,String facebook,String instagram,String twitter){
        this(userId, domain, age, gender, nickName);
        this.favoriteCountry=favoriteCountry;
        this.facebook=facebook;
        this.instagram=instagram;
        this.twitter=twitter;
    }
}
