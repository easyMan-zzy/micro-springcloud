package org.example.service;

import com.alibaba.fastjson.JSON;
import org.example.util.TokenParseUtil;
import org.example.vo.LoginUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <h1>JWT 相关服务测试类</h1>
 * */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class JWTServiceTest {

    @Autowired
    private IJWTService ijwtService;

    @Test
    public void testGenerateAndParseToken() throws Exception {

        String jwtToken = ijwtService.generateToken(
                "zman",
                "fcea920f7412b5da7be0cf42b8c93759"
        );
        log.info("jwt token is: [{}]", jwtToken);

        LoginUserInfo userInfo = TokenParseUtil.parseUserInfoFromToken(jwtToken);
        log.info("parse token: [{}]", JSON.toJSONString(userInfo));
    }
}
