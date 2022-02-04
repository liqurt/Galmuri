package com.ssafy.galmuri.domain.user;

import com.ssafy.galmuri.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Test
    public void userInsert(){
//        userRepository.save(User.builder()
//                        .userId("cdh6006@naver.com")
//                        .domain('n')
//                        .age(28)
//                        .gender(false)
//                        .nickName("cdh6006")
//                .build());
//        userRepository.save(User.builder()
//                .userId("cdh6006@gmail.com")
//                .domain('g')
//                .age(28)
//                .gender(false)
//                .nickName("cdh6006")
//                .build());
    }

}
