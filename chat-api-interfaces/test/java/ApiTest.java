package java;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: chat-gpt
 * @description: 测试类
 * @author: Bernard ding
 * @create: 2023-05-23 23:55
 **/
@SpringBootTest
public class ApiTest {


    @Test
    public void query_unanswered_questions() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet();

    }
}
