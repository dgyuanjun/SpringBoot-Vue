package com.yuanjun.mybatis.controller;

import com.yuanjun.mybatis.entity.Person;
import com.yuanjun.mybatis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("insertPerson")
    public String insertPerson(){
        Person person = new Person();
        person.setUsername("yuanjun");
        person.setPassword("123456");
        person.setAddress("shanghai");
        personService.insert(person);
        return "插入成功！";
    }
}
