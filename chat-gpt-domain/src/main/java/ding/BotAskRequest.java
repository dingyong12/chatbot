package ding;

import java.io.Serializable;
import java.util.List;

/**
 * @author bernard.ding
 * @create 2023-05-24 21:23
 */
public class BotAskRequest implements Serializable {

    private static final long serialVersionUID  = 124125129951295L;

    private String conversationId;


    private String senderStaffId;

    /**
     * 被@人的信息
     */
    private List<DingUserInfo> atUsers;

    private String senderNick;

    /**
     * 企业内部群有的发送者当前群的企业corpId。
     */
    private String senderCorpId;

    /**
     * 目前只支持text。
     */
    private String msgtype;

    /**
     * 消息内容
     */
    private DingText text;

    public BotAskRequest() {
    }

    public BotAskRequest(String conversationId, String senderStaffId, List<DingUserInfo> atUsers, String senderNick, String senderCorpId, String msgtype, DingText text) {
        this.conversationId = conversationId;
        this.senderStaffId = senderStaffId;
        this.atUsers = atUsers;
        this.senderNick = senderNick;
        this.senderCorpId = senderCorpId;
        this.msgtype = msgtype;
        this.text = text;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getSenderStaffId() {
        return senderStaffId;
    }

    public void setSenderStaffId(String senderStaffId) {
        this.senderStaffId = senderStaffId;
    }

    public List<DingUserInfo> getAtUsers() {
        return atUsers;
    }

    public void setAtUsers(List<DingUserInfo> atUsers) {
        this.atUsers = atUsers;
    }

    public String getSenderCorpId() {
        return senderCorpId;
    }

    public void setSenderCorpId(String senderCorpId) {
        this.senderCorpId = senderCorpId;
    }

    public String getSenderNick() {
        return senderNick;
    }

    public void setSenderNick(String senderNick) {
        this.senderNick = senderNick;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public DingText getText() {
        return text;
    }

    public void setText(DingText text) {
        this.text = text;
    }
}
