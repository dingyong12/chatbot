package cn.dy.chatapi.api;

import cn.hutool.json.JSONUtil;
import ding.BotAskRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 适用于钉钉
 *
 * @author bernard.ding
 * @create 2023-05-24 21:19
 */
@RestController
@RequestMapping("dingding")
public class DingController {

    private final Logger logger = LoggerFactory.getLogger(DingController.class);

    @RequestMapping("ask")
    public void getAskQuestion(@RequestBody BotAskRequest botAskRequest) {
        //todo 验签

        // 消费消息
        logger.info("收到的钉钉信息 =>{}", JSONUtil.toJsonStr(botAskRequest));
    }
}
