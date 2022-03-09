package com.threewater;

import com.threewater.mapper.UserMapper;
import com.threewater.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 虞赟淼
 * @Date: 2022/03/09/16:57
 * @Description:
 */
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        // 通过条件查询器查询一个list集合，若没有条件，则可以设置null为参数
        List<User> list = userMapper.selectList(null);
        for (User user : list) {
            System.out.println(user);
        }
    }

}
