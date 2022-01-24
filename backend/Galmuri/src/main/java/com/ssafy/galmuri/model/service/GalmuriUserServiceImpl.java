package com.ssafy.galmuri.model.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.galmuri.model.dto.UserDto;
import com.ssafy.galmuri.model.mapper.UserMapper;

@Service
public class GalmuriUserServiceImpl implements GalmuriUserService {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int signUp(UserDto user) throws SQLException {
		return sqlSession.getMapper(UserMapper.class).signUp(user);
	}
	
	@Override
	public int insertOption(UserDto user) throws SQLException {
		return sqlSession.getMapper(UserMapper.class).insertOption(user);
	}

	@Override
	public UserDto userInfo(String userId, char domain) throws SQLException {
		return sqlSession.getMapper(UserMapper.class).userInfo(userId, domain);
	}

	@Override
	public int updateUser(UserDto user) throws SQLException {
		return sqlSession.getMapper(UserMapper.class).updateUser(user);
	}
	
	@Override
	public int updateOption(UserDto user) throws SQLException {
		return sqlSession.getMapper(UserMapper.class).updateOption(user);
	}

	@Override
	public int deleteUser(String userId, char domain) throws SQLException {
		return sqlSession.getMapper(UserMapper.class).deleteUser(userId, domain);
	}



}
