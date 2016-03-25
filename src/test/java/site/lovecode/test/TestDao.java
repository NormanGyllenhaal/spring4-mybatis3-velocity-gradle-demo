package site.lovecode.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import site.lovecode.entity.User;
import site.lovecode.mapper.UserMapper;

import java.util.List;

/**
 * Created by Administrator on 2016/3/24.
 */
public class TestDao {


    @Test
    public void testUser(){
        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath*:applicationContext-*.xml");
    	UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
        List<User> list = userMapper.selectAll();
        System.out.println(list);

    }
}


