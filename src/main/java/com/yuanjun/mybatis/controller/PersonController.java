package com.yuanjun.mybatis.controller;

import com.yuanjun.mybatis.entity.Person;
import com.yuanjun.mybatis.entity.RestResult;
import com.yuanjun.mybatis.service.PersonService;
import com.yuanjun.mybatis.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private  PersonService personService;
    @Autowired
    private  ResultGenerator resultGenerator;





    @RequestMapping("insertPerson")
    public String insertPerson(){
        Person person = new Person();
        person.setUsername("yuanjun");
        person.setPassword("123456");
        person.setAddress("shanghai");
        personService.insert(person);
        return "插入成功！";
    }

    /**
     * 匹配 /user/login 地址 ,限定POST方法
     * 。@NotNull 在字段前添加注解代表验证该字段，如果为空则报异常
     * @return 登陆成功则返回相关信息，否则返回错误提示
     */
    @RequestMapping(value = "/login" ,method=RequestMethod.POST)
    public RestResult login(@NotNull(message = "用户名不能为空") String username, @NotNull(message = "密码不能为空") String password, HttpSession session) {
        System.out.println(username+password);
        Person person = personService.checkLogin(username, password);
        if(person != null) {
            //储存到session中
            session.setAttribute("user",person);
            return resultGenerator.getSuccessResult("登陆成功",person);
        }
        return resultGenerator.getFailResult("用户名/密码错误");
    }

    /**
     * 为参数验证添加异常处理器
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public RestResult handleConstraintViolationException(ConstraintViolationException cve) {
        //这里简化处理了，cve.getConstraintViolations 会得到所有错误信息的迭代，可以酌情处理
        String errorMessage = cve.getConstraintViolations().iterator().next().getMessage();
        return resultGenerator.getFailResult(errorMessage);
    }
}
