package org.example.service;

import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.EcommerceUserDao;
import org.example.entity.EcommerceUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>EcommerceUser 相关的测试</h1>
 * */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class EcommerceUserTest {

    @Autowired
    private EcommerceUserDao ecommerceUserDao;

    @Test
    public void createUserRecord() {

        EcommerceUser ecommerceUser = new EcommerceUser();
        ecommerceUser.setUsername("zman");
        ecommerceUser.setPassword(MD5.create().digestHex("1234567"));
        ecommerceUser.setExtraInfo("{}");
        log.info("save user: [{}]",
                JSON.toJSON(ecommerceUserDao.save(ecommerceUser)));
    }
}
