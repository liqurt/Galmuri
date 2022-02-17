package com.ssafy.galmuri.service;

import com.ssafy.galmuri.domain.flag.Flag;
import com.ssafy.galmuri.domain.trip.Country;
import com.ssafy.galmuri.dto.flag.FlagDto;
import com.ssafy.galmuri.repository.flag.FlagRepository;
import com.ssafy.galmuri.repository.trip.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FlagService {
    private final FlagRepository flagRepository;
    private final CountryRepository countryRepository;

    @Transactional
    public String save(FlagDto flagDto){
        Country country=countryRepository.findById(flagDto.getCountryCode()).orElseThrow(()-> new IllegalArgumentException("해당하는 여행이 없습니다."));
        Flag flag=Flag.builder().country(country).url(flagDto.getUrl()).build();
        flagRepository.save(flag);
        return flag.getCountry().getCountryCode();
    }
    public FlagDto read(String countryCode){
        Flag flag=flagRepository.findById(countryCode).orElseThrow(()-> new IllegalArgumentException("해당하는 여행이 없습니다."));
        return FlagDto.builder().countryCode(flag.getCountry().getCountryCode()).url(flag.getUrl()).build();
    }
    @Transactional
    public String update(String countryCode,String url){
        Flag flag=flagRepository.findById(countryCode).orElseThrow(()-> new IllegalArgumentException("해당하는 여행이 없습니다."));
        flag.update(url);
        return flag.getCountry().getCountryCode();
    }
    @Transactional
    public String delete(String countryCode){
        Flag flag=flagRepository.findById(countryCode).orElseThrow(()-> new IllegalArgumentException("해당하는 여행이 없습니다."));
        flagRepository.delete(flag);
        return countryCode;
    }
}
