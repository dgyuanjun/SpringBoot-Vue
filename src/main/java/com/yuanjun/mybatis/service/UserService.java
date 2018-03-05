package com.yuanjun.mybatis.service;


import com.baomidou.mybatisplus.service.IService;
import com.yuanjun.mybatis.entity.User;

import java.util.List;

public interface UserService extends IService<User>{

     List<User> getAll();

     User findByName(String name);
}
