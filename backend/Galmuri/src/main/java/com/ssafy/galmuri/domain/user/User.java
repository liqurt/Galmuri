package com.ssafy.galmuri.domain.user;

import com.ssafy.galmuri.domain.BaseTimeEntity;
import com.ssafy.galmuri.domain.trip.Country;
import com.ssafy.galmuri.domain.trip.Trip;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@IdClass(UserID.class)
public class User extends BaseTimeEntity {
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

    @OneToOne
    @JoinColumn(name = "countryCode")
    private Country countryCode;

    @Column
    private String facebook;

    @Column
    private String instagram;

    @Column
    private String twitter;

    @Builder
    public User(String userId,char domain,int age,boolean gender
            ,String nickName,String countryCode,String facebook
            ,String instagram,String twitter){
        this.userId=userId;
        this.domain=domain;
        this.age=age;
        this.gender=gender;
        this.nickName=nickName;
        this.totalVote=0;
        this.totalScore=0.0f;
        this.countryCode=new Country(countryCode);
        this.facebook=facebook;
        this.instagram=instagram;
        this.twitter=twitter;
    }
    public void update(int age,boolean gender
            ,String nickName,int totalVote,float totalScore
            ,String countryCode,String facebook
            ,String instagram,String twitter){
        this.age=age;
        this.gender=gender;
        this.nickName=nickName;
        this.totalVote=totalVote;
        this.totalScore=totalScore;
        this.countryCode=new Country(countryCode);
        this.facebook=facebook;
        this.instagram=instagram;
        this.twitter=twitter;
    }

}
