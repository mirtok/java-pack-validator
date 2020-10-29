package com.pack;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pack.dao.mapper.MyUserMapper;
import com.pack.entity.MyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@SpringBootTest
class JavaPackValidatorApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyUserMapper userMapper;

    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getConnection());
        System.out.println(dataSource.getClass());
    }

    @Test
    public void textPlusPage(){
        Page<MyUser> page = new Page(1,10);
        userMapper.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        List<MyUser> records = page.getRecords();
        records.forEach(System.out::println);
    }

    @Test
    public void testPlus(){
        MyUser user = new MyUser();
        user.setName("测试" + randomInt(100000000,1000000000));
        user.setAge(randomInt(10,100));
        user.setEmail(randomInt(100000000,1000000000) +  "@qq.com");
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void testPlusMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","就哈哈");
        List<MyUser> myUsers = userMapper.selectByMap(map);
        myUsers.forEach(System.out::println);
    }

    @Test
    public void testPlusInsertMultipleDate(){
        List<MyUser> list = new ArrayList();
        for (int i = 0; i < 30; i++) {
            MyUser user = new MyUser();
            user.setName("测试" + randomInt(100000000,1000000000));
            user.setAge(randomInt(10,100));
            user.setEmail(randomInt(100000000,1000000000) +  "@qq.com");
            list.add(user);
        }
        userMapper.insertMultipleData(list);
    }

    @Test
    public void testPlusDelete(){
//        int i = userMapper.deleteById(2);
        MyUser user = userMapper.selectById(2);
        System.out.println(user);

    }
    /**
     * 指定范围随机数
     * @param min
     * @param max
     * @return
     */
    public int randomInt (int min,int max){
        int random = new Random().nextInt(max) + min;
        return random;
    }
}
