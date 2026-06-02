package com.the703.dao;

import java.util.List;

import com.the703.dto.UserInfoDto;
//userinfo-mapper.xml
//1. com.the703.dto  > lombok이용해서   UserInfoDto 만들기
//2. mybatis-config.xml
@Mapper
public interface UserInfoMapper {
	  public int insert(UserInfoDto dto);
	  public List<UserInfoDto> selectAll();
	  public UserInfoDto select(int no);
	  public int update(UserInfoDto dto);
	  public int delete(int no);
}
