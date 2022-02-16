package com.ssafy.galmuri.domain.flag;

import com.ssafy.galmuri.domain.trip.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Flag{
    @Id
    @Column
    private String countryCode;

    @OneToOne
    @MapsId
    @JoinColumn(name="countryCode")
    private Country country;

    @Column(nullable = false,length = 1000)
    private String url;

    public void update(String url){
        this.url=url;
    }
}
