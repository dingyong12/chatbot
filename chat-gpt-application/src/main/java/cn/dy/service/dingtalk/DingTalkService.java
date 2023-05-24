package cn.dy.service.dingtalk;

import ding.BotAskRequest;
import ding.DingText;
import ding.DingUserInfo;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bernard.ding
 * @create 2023-05-24 23:17
 */
@Service
public class DingTalkService {

    @Value("${dingtalk.post.url}")
    private String dingTalkPostUrl;

    /**
     *
     */
    public void handleMsg(BotAskRequest request) {

        //todo 验签

        String content = request.getText().getContent();
        String userId = request.getAtUsers().get(0).getStaffId();

        //todo 请求chatgpt获取回复内容

        //获取钉钉请求头accessToken
        String token = getToken();

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(dingTalkPostUrl);
        httpPost.addHeader("x-acs-dingtalk-access-token", token);
        httpPost.addHeader("Content-Type", "application/json");

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("robotCode",""));
        params.add(new BasicNameValuePair("userIds",userId));
        params.add(new BasicNameValuePair("msgKey","sampleText"));
        params.add(new BasicNameValuePair("msgParam","{\n" +
                "      \"content\": \"xxxx\"\n" +
                "  }"));

        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private String getToken() {
        //todo 获取钉钉请求头accessToken
        return null;
    }
}
