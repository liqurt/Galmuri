package com.ssafy.galmuri.domain.user;

import lombok.*;

import java.io.Serializable;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class UserID implements Serializable {
    private String userId;
    private Character domain;
}
