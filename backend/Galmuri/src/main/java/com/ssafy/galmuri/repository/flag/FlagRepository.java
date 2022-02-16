package com.ssafy.galmuri.repository.flag;

import com.ssafy.galmuri.domain.flag.Flag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlagRepository extends JpaRepository<Flag,String> {
}
