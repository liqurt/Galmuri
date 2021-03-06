package com.ssafy.galmuri.domain.user;

import com.ssafy.galmuri.domain.BaseTimeEntity;
import com.ssafy.galmuri.domain.trip.Country;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@NoArgsConstructor
@Entity
@IdClass(UserID.class)
public class User extends BaseTimeEntity {
    @Id
    @Column(name = "userId")
    private String userId;

    @Id
    @Column(name = "domain")
    private Character domain;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private boolean gender;

    @Column(nullable = false)
    private String nickName;

    @Column
    private Float totalScore;

    @Column
    private Integer totalVote;

    @OneToOne
    @JoinColumn(name = "countryCode")
    private Country countryCode;

    @Column
    private String facebook;

    @Column
    private String instagram;

    @Column
    private String twitter;

    @Column(length = 1000)
    private String comment;

    @Column
    private Long birth;

    @Column(length = 1000)
    private String photoUrl;

    @Builder
    public User(String userId,Character domain,int age,boolean gender
            ,String nickName,String countryCode,String facebook
            ,String instagram,String twitter,String comment,Long birth,String photoUrl){
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
        this.comment=comment;
        this.birth=birth;
        this.photoUrl=photoUrl;
    }
    public void update(int age,boolean gender
            ,String nickName,int totalVote,float totalScore
            ,String countryCode,String facebook
            ,String instagram,String twitter,String comment,Long birth,String photoUrl){
        this.age=age;
        this.gender=gender;
        this.nickName=nickName;
        this.totalVote=totalVote;
        this.totalScore=totalScore;
        this.countryCode=new Country(countryCode);
        this.facebook=facebook;
        this.instagram=instagram;
        this.twitter=twitter;
        this.comment=comment;
        this.birth=birth;
        this.photoUrl=photoUrl;
    }
    public Character getDomain(){
        return domain;
    }

}
