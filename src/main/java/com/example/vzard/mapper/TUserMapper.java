package com.example.vzard.mapper;

import com.example.vzard.entity.TUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lucailei
 * @since 2018-08-11
 */
@Mapper
@Component
public interface TUserMapper extends BaseMapper<TUser> {

    @Insert("insert into t_user (id,username,password,del_flag,created_at,updated_at) " +
            "values (#{id},#{username},#{password},#{delFlag},now(),now())")
    int addUser(TUser user);
}
