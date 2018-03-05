package com.yuanjun.mybatis.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yuanjun.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User>{

    @Select("select id,age,name from user")
    List<User> getAll();

    User findByName(String name);


}
