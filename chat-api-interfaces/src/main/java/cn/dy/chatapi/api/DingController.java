package cn.dy.chatapi.api;

import cn.dy.service.dingtalk.DingTalkService;
import cn.hutool.json.JSONUtil;
import ding.BotAskRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

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

    @Resource
    private DingTalkService dingTalkService;

    /**
     * 钉钉机器人问答(目前只有群聊)
     *
     * @param botAskRequest 问答请求
     */
    @RequestMapping("ask")
    public void getAskQuestion(@RequestBody BotAskRequest botAskRequest) {
        logger.info("收到的钉钉信息 =>{}", JSONUtil.toJsonStr(botAskRequest));
        dingTalkService.handleMsg(botAskRequest);

    }
}
