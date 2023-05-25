package cn.dy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * @program: chat-gpt
 * @description: 测试类
 * @author: Bernard ding
 * @create: 2023-05-23 23:55
 **/
@SpringBootTest
@SpringBootConfiguration
@RunWith(SpringRunner.class)
public class ApiTest {


    private String token;

    @Test
    public void getTokenTest() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HashMap<String, String> map = new HashMap<>();
        map.put("appKey", "ding2bspjaawdawhjgl3");
        map.put("appSecret", "Lj-5yi07DQ82OdJtuvqYDgIXOax1Ulm79LidjhFze-bl-kxUW_mByefZakH0D7ll");
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity("https://api.dingtalk.com/v1.0/oauth2/accessToken", entity, Map.class);
        JSONObject jsonObject = new JSONObject(response.getBody());
        String accessToken = jsonObject.getString("accessToken");
        System.out.println(accessToken);
    }

    @Test
    public void responseInfo() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("x-acs-dingtalk-access-token", "e924297025b83598afa9392b9f936680");
        headers.add("Content-Type", "application/json");

        HashMap<String, Object> map = new HashMap<>();
        map.put("robotCode", "ding2bspjaawdawhjgl3");
        map.put("userIds", Arrays.asList("manager4338"));
        map.put("msgKey", "sampleText");
        String content = "hello world";
        Map<String,String> info = new HashMap<>();
        info.put("content",content);
        map.put("msgParam", JSON.toJSONString(info));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity("https://api.dingtalk.com/v1.0/robot/oToMessages/batchSend", entity, Map.class);
        JSONObject jsonObject = new JSONObject(response.getBody());
    }
}
