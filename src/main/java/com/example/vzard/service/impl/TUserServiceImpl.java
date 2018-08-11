package com.example.vzard.service.impl;

import com.example.vzard.entity.TUser;
import com.example.vzard.mapper.TUserMapper;
import com.example.vzard.service.ITUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lucailei
 * @since 2018-08-11
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
