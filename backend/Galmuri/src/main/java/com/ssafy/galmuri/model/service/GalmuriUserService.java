package com.ssafy.galmuri.model.service;

import java.sql.SQLException;

import com.ssafy.galmuri.model.dto.UserDto;

public interface GalmuriUserService {
	int signUp(UserDto user) throws SQLException;
	int insertOption(UserDto user) throws SQLException;
	UserDto userInfo(String userId, char domain) throws SQLException;
	int updateUser(UserDto user) throws SQLException;
	int updateOption(UserDto user) throws SQLException;
	int deleteUser(String userId, char domain) throws SQLException;
}
