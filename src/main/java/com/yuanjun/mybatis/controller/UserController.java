package com.yuanjun.mybatis.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.yuanjun.mybatis.entity.User;
import com.yuanjun.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.Oneway;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("all")
    public List<User> getAll(){
        List<User> list = userService.getAll();
        for (int i = 0; i <list.size() ; i++) {
            System.out.printf(list.get(i).toString());
        }
        return userService.getAll();
    }
    @ResponseBody
    @RequestMapping("/save")
    public ModelAndView home() {
        System.out.println("beelt测试");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("email", "apk2sf@163.com");
        modelAndView.setViewName("add");
        return modelAndView;
    }
    @RequestMapping("findByName")
    public User findByName(){
        return userService.findByName("yuanjun");
    }

    /**
     * 条件的拼接构造器
     * 1.new EntityWrapper()
     * 2.关键词的使用：where,andNew,order,
     * 分页查询操作
     * @return
     */
    @RequestMapping("test1")
    public Page<User> findByPage(){
        return userService.selectPage(new Page<User>(1,2),new EntityWrapper<User>()
                .where("name={0}","yuanjun")
                .andNew("age>{0}",10)
                .orderBy("age"));
    }

    /**
     * 保存操作
     * @return
     */
    @RequestMapping("saveUser")
    public String saveUser(){
        User user = new User();
        user.setAge(20);
        user.setName("赵浩");
        userService.insert(user);
        return "保存成功";
    }

    /**
     * 更新操作
     * @param id
     * @return
     */
    @RequestMapping("updateUser")
    public String updateUser(int id){
        User user = userService.selectById(id);
        user.setAge(100);
        userService.updateById(user);
        return "更新成功";
    }

    /***
     * 删除操作
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String deleteUser(int id){
        userService.deleteById(id);
        return "删除成功";
    }
}
