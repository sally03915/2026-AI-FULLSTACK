package com.the703.dao;

import org.apache.ibatis.annotations.Mapper;

import com.the703.dto.AppUserAuthDto;
import com.the703.dto.AppUserDto;
import com.the703.dto.AuthDto; 

@Mapper
public interface AppUserDao {
   /*      멤버관리         */
   public   int   insertAppUser(AppUserDto  dto); 
   public   AppUserAuthDto   readAuthByEmail(AppUserDto dto); //로그인
   public   AppUserDto       findByEmail(AppUserDto   dto);  //마이페이지
   public   int    iddoubleByEmail(AppUserDto   dto);   //아이디중복
   public   int    updateAppUser(AppUserDto  dto);
   public   int    deleteAppUser(AppUserDto  dto); 
   /*       권한관련         */
   public int   insertAuth(AuthDto dto);
   public int   deleteAuth(AuthDto dto);
} 