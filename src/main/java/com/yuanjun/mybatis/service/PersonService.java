package com.yuanjun.mybatis.service;

import com.baomidou.mybatisplus.service.IService;
import com.yuanjun.mybatis.entity.Person;

public interface PersonService extends IService<Person> {

    Person checkLogin(String username,String password);
}
