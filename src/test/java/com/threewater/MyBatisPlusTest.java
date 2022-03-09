package com.threewater;

import com.threewater.mapper.UserMapper;
import com.threewater.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testInsert() {
        // 实现新增用户
        // INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User("周杰伦", 18, "jay@threewater.com");
        int result = userMapper.insert(user);
        System.out.println("result: " + result);
        System.out.println("id:" + user.getId());
    }

    @Test
    public void testDeleteById() {
        // 依据id删除用户
        // DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(1501494839378788353L); // id范围已经超过int类型了 所以在最后要加上L
        System.out.println("result: " + result);
    }

    @Test
    public void testDeleteByMap() {
        // 依据map键值对的条件删除用户
        // DELETE FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("name", "周杰伦");
        map.put("age", 18);
        int result = userMapper.deleteByMap(map);
        System.out.println("result: " + result);
    }

    @Test
    public void testDeleteBatchIds() {
        // 通过多个id实现批量删除
        // DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result: " + result);
    }

    @Test
    public void testUpdate() {
        // 修改用户
        // UPDATE user SET name=?, age=?, email=? WHERE id=?
        User user = new User(4L, "呵呵", 22, "hehe@threewater.com");
        int result = userMapper.updateById(user);
        System.out.println("result: " + result);
    }

    @Test
    public void testSelect() {
        // 通过id查询用户信息
        // SELECT id,name,age,email FROM user WHERE id=?
        User user = userMapper.selectById(1L);
        System.out.println(user);

        // 通过多个id查询多个用户信息
        // SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> userList = userMapper.selectBatchIds(list);
        for (User user1 : userList) {
            System.out.println(user1);
        }

        // 依据map键值对的条件查询用户
        // SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jone");
        map.put("age", 18);
        List<User> userList1 = userMapper.selectByMap(map);
        for (User user1 : userList1) {
            System.out.println(user1);
        }

        // 查询所有数据
        // SELECT id,name,age,email FROM user
        List<User> userList2 = userMapper.selectList(null);
        for (User user1 : userList2) {
            System.out.println(user1);
        }
    }

}
