package cn.dy.chatapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @program: chat-gpt
 * @description: 启动类
 * @author: Bernard ding
 * @create: 2023-05-23 23:49
 **/
@SpringBootApplication
@ComponentScan("cn.dy")
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
