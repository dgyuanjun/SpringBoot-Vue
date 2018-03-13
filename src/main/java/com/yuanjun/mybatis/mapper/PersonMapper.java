package com.yuanjun.mybatis.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yuanjun.mybatis.entity.Person;
import org.apache.ibatis.annotations.Param;

public interface PersonMapper extends BaseMapper<Person> {

    Person checkLogin(@Param("username") String username, @Param("password")String password);
}
