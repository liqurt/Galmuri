package com.ssafy.galmuri.domain.trip;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Country {
    @Id
    @Column(length = 3)
    private String countryCode;

    @Column(nullable = false)
    private String countryName;

    @Column(nullable = false)
    private String continent;
}
