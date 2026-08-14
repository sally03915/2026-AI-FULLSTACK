package com.thejoa703.mapper;
import java.util.List; 
import org.apache.ibatis.annotations.Mapper; 
import com.thejoa703.domain.DeptUser;

@Mapper
public interface DeptUserMapper {
	List<DeptUser>  findByNameKeyword(String keyword);
}
