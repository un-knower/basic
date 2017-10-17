package com.zhan.web.controller;

import com.zhan.web.entity.User;
import com.zhan.web.dbmapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : Zhan
 * E-mail : kenger@163.com
 * Date   : 2017/10/16
 */
@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public User getUser(int id){
        return userMapper.getOneUser(id);
    }

    @RequestMapping("/adduser")
    @ResponseBody
    public Map<String,Integer> addUser(){
       User user = new User();
       user.setAge(30);
       user.setId(2);
       user.setName("lisi");
        int count = userMapper.insertOneUser(user);
        Map<String,Integer> map = new HashMap<>();
        map.put("count",count);
        return map;
    }

    @RequestMapping("/updateuser")
    @ResponseBody
    public Map<String,Integer> updateUser(){
        User user = new User();
        user.setName("李四");
        user.setId(2);
        user.setAge(32);
        int count = userMapper.updateOneUser(user);
        Map<String,Integer> map = new HashMap<>();
        map.put("count",count);
        return map;
    }

    @RequestMapping(value="/deleteuser",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Integer> deleteUser(int id){
        int count = userMapper.deleteById(id);
        Map<String,Integer> map = new HashMap<>();
        map.put("count",count);
        return map;
    }
}
