package com.example.vzard.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.vzard.annotation.TimeStamp;
import com.example.vzard.entity.TUser;
import com.example.vzard.service.ITUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lucailei
 * @since 2018-08-11
 */
@RestController
@RequestMapping(value = "/api/v1")
@Api(tags = "关于用户的操作(用于测试)")
public class TUserController {
    @Autowired
    ITUserService itUserService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ApiOperation("获取所有的用户")
    public List<TUser> getAllUsers() {
        return itUserService.selectList(new EntityWrapper<>(new TUser()));
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ApiOperation("新增一个用户")
    @TimeStamp(type = TUser.class)
    public boolean addUser(TUser user) {
        return itUserService.insertAllColumn(user);
    }


}

