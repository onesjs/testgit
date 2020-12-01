package com.imooc.mall;

import com.imooc.mall.model.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class MallApplicationTests {

    @Test
    void contextLoads(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        User user = new User();
        System.out.println(user.getPersonalizedSignature());
        System.out.println(user.getCreateTime());
    }

}
