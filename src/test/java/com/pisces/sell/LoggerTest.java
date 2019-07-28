package com.pisces.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Title: LoggerTest </p>
 * <p>Description: 日志功能测试 </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-2-26 22:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    // private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {
        String name = "christopher";
        String password = "123456";
        log.debug("debug...");
        log.info("name: {}, password: {}", name, password);
        log.error("error...");
        log.warn("warn...");
    }
}
