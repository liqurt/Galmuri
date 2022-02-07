package com.ssafy.galmuri.repository.trip;

import com.ssafy.galmuri.domain.trip.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,String> {
}
