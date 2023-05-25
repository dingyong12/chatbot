package cn.dy.service.dingtalk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ding.BotAskRequest;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * @author bernard.ding
 * @create 2023-05-24 23:17
 */
@Service
public class DingTalkService {

    private static final Logger logger = LoggerFactory.getLogger(DingTalkService.class);

    @Value("${dingding.sendUrl}")
    private String dingTalkSendUrl;

    @Value("${dingding.tokenUrl}")
    private String dingTalkTokenUrl;

    @Value("${dingding.appKey}")
    private String appKey;

    @Value("${dingding.appSecret}")
    private String appSecret;

    @Resource
    private RestTemplate restTemplate;


    /**
     *
     */
    public void handleMsg(BotAskRequest request) {

        //todo 验签

        String content = request.getText().getContent();
        String userId = request.getSenderStaffId();

        //todo 请求chatgpt获取回复内容

        //获取钉钉请求头accessToken
        String token = getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("x-acs-dingtalk-access-token", token);

        HashMap<String, Object> map = new HashMap<>();
        map.put("robotCode", appKey);
        map.put("userIds", Arrays.asList(userId));
        map.put("msgKey", "sampleText");
        Map<String,String> info = new HashMap<>();
        info.put("content",content);
        map.put("msgParam", JSON.toJSONString(info));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
        restTemplate.postForEntity(dingTalkSendUrl, entity, Map.class);
    }


    private String getToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HashMap<String, String> map = new HashMap<>();
        map.put("appKey", appKey);
        map.put("appSecret", appSecret);
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(dingTalkTokenUrl, entity, Map.class);
        JSONObject jsonObject = new JSONObject(response.getBody());
        String accessToken = jsonObject.getString("accessToken");
        logger.info("token={}", accessToken);
        return accessToken;
    }
}
