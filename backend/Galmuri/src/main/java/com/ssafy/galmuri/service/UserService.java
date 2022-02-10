package com.ssafy.galmuri.service;

import com.ssafy.galmuri.domain.user.User;
import com.ssafy.galmuri.domain.user.UserID;
import com.ssafy.galmuri.dto.user.UserCreateDto;
import com.ssafy.galmuri.dto.user.UserReadDto;
import com.ssafy.galmuri.dto.user.UserUpdateDto;
import com.ssafy.galmuri.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public String save(UserCreateDto createDto){
        return userRepository.save(createDto.toEntity()).getUserId();
    }

    @Transactional
    public String update(String userId, char domain, UserUpdateDto updateDto){
        User user=userRepository.findById(new UserID(userId,domain))
                .orElseThrow(()->new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        user.update(updateDto.getAge(), updateDto.isGender(), updateDto.getNickName()
                ,updateDto.getTotalVote(), updateDto.getTotalScore(), updateDto.getCountryCode()
                ,updateDto.getFacebook(), updateDto.getInstagram(), updateDto.getTwitter());
        return user.getUserId();
    }

    public UserReadDto findByIdAndDomain(String userId, char domain){
        User user=userRepository.findById(new UserID(userId,domain))
                .orElseThrow(()->new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        return new UserReadDto(user);
    }
    public User findUserByIdAndDomain(String userId, char domain){
        User user=userRepository.findById(new UserID(userId,domain))
                .orElseThrow(()->new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        return user;
    }
    @Transactional
    public String deleteByIdAndDomain(String userId, char domain){
        userRepository.deleteById(new UserID(userId,domain));
        return userId;
    }

}
