package com.ssafy.galmuri.domain.user;

import com.ssafy.galmuri.domain.usertrip.UserTrip;
import com.ssafy.galmuri.repository.user.UserRepository;
import com.ssafy.galmuri.repository.usertrip.UserTripRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserTripRepository userTripRepository;
    @Test
    public void userInsert(){
        User user=userRepository.findById(new UserID("cdh6006@gmail.com",'G')).orElseThrow(()->new IllegalArgumentException("그런 사람은 없다."));
        System.out.println(user);
        List<User> list=userRepository.findAll();
        List<UserTrip> list2=userTripRepository.findAllByUser(user);
        System.out.println(list2);
    }

}
