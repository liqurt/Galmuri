package com.ssafy.galmuri.domain.trip;

import com.ssafy.galmuri.repository.trip.TripRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripRepositoryTest {
    @Autowired
    TripRepository tripRepository;
//    @After
//    public void cleanup(){tripRepository.deleteAll();}
    @Test
    public void tripInsert(){
//        tripRepository.save(Trip.builder()
//                        .title("유럽여행")
//                        .hostId("cdh6006@gmail.com")
//                        .hostDomain('g')
//                        .startDate(LocalDateTime.now())
//                        .endDate(LocalDateTime.now().plusDays(1))
//                        .theme("관광 명소 여행")
//                        .maxMember(3)
//                        .comment("안녕하세요. 첫번째 글입니다.")
//                .build());
//        tripRepository.save(Trip.builder()
//                .title("유럽여행")
//                .hostId("cdh6006@naver.com")
//                .hostDomain('n')
//                .startDate(LocalDateTime.now())
//                .endDate(LocalDateTime.now().plusDays(1))
//                .theme("관광 명소 여행2")
//                .maxMember(3)
//                .comment("안녕하세요. 두번째 글입니다.")
//                .build());
//        tripRepository.save(Trip.builder()
//                .title("유럽여행")
//                .hostId("cdh6006@naver.com")
//                .hostDomain('g')
//                .startDate(LocalDateTime.now())
//                .endDate(LocalDateTime.now().plusDays(1))
//                .theme("관광 명소 여행3")
//                .maxMember(3)
//                .comment("안녕하세요. 세번째 글입니다.")
//                .build());
//        tripRepository.save(Trip.builder()
//                .title("유럽여행")
//                .hostId("cdh6006@google.com")
//                .hostDomain('n')
//                .startDate(LocalDateTime.now())
//                .endDate(LocalDateTime.now().plusDays(1))
//                .theme("관광 명소 여행4")
//                .maxMember(3)
//                .comment("안녕하세요. 네번째 글입니다.")
//                .build());
    }
}
