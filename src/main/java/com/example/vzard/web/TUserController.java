package com.example.vzard.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.vzard.annotation.HttpLog;
import com.example.vzard.annotation.TimeStamp;
import com.example.vzard.entity.TUser;
import com.example.vzard.generator.IdGenerator;
import com.example.vzard.mapper.TUserMapper;
import com.example.vzard.service.ITUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
@HttpLog
public class TUserController {
    @Autowired
    ITUserService itUserService;

    @Autowired
    TUserMapper tUserMapper;

    IdGenerator idGenerator = IdGenerator.create(1, 1);

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ApiOperation("获取所有的用户")
    public List<TUser> getAllUsers() {
        return itUserService.selectList(new EntityWrapper<>(new TUser()));
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ApiOperation("新增一个用户")
    @TimeStamp(type = TUser.class)

    public boolean addUser(@RequestBody TUser user) {
        user.setId(idGenerator.nextStrId());
        return itUserService.insertAllColumn(user);
    }

    @RequestMapping(value = "/user-new", method = RequestMethod.POST)
    @ApiOperation("新增一个用户，使用直接写sql插入时间戳的方式")
    public int insertUser(TUser user) {
        user.setId(idGenerator.nextStrId());
        return tUserMapper.addUser(user);
    }


}

