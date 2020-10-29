package com.pack;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pack.dao.mapper.MyUserMapper;
import com.pack.entity.MyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private MyUserMapper userMapper;

    @Test
    public void Test1() {

        QueryWrapper<MyUser> wrapper = new QueryWrapper<>();
//         查询name不为空的并且email不为空的用户，年龄大于50的用户
//         wrapper.isNotNull("name").isNotNull("email").ge("age",50)
//         List<MyUser> list = userMapper.selectList(wrapper);
//         list.forEach(System.out::println);
//         查询name 是测试575866116
//        wrapper.eq("name","测试575866116");
//        MyUser user = userMapper.selectOne(wrapper);
//        System.out.println(user);
        // 查询年龄20-30之间的用户
//        wrapper.between("age",50,60);
//        Integer count = userMapper.selectCount(wrapper);
//        System.out.println(count);
        //查询名字里面不包含e的， 邮箱以953打头的
//        wrapper.notLike("name","e").likeRight("email","953");
//        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
//        maps.forEach(System.out::println);
        // sql 条件查询
//        wrapper.inSql("id","select id from my_user where id < 10");
//        List<Object> objects = userMapper.selectObjs(wrapper);
//        objects.forEach(System.out::println);
        // 排序
//        wrapper.orderByDesc("id","name");
//        List<MyUser> myUsers = userMapper.selectList(wrapper);
//        myUsers.forEach(System.out::println);
        wrapper.groupBy("id","age");
        List<MyUser> myUsers = userMapper.selectList(wrapper);
        myUsers.forEach(System.out::println);
    }
}
