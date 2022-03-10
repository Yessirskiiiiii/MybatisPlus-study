package com.threewater.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.threewater.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 虞赟淼
 * @Date: 2022/03/09/16:50
 * @Description:
 */
public interface UserMapper extends BaseMapper<User> {

    // 根据id查询用户信息为map集合
    Map<String, Object> selectMapById(Long id);

}
