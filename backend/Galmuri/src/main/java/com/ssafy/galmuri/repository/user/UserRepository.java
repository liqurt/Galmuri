package com.ssafy.galmuri.repository.user;

import com.ssafy.galmuri.domain.user.User;
import com.ssafy.galmuri.domain.user.UserID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UserID> {
}
