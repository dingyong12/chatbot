package ding;

/**
 * @author bernard.ding
 * @create 2023-05-24 23:00
 */
public class DingUserInfo {

    /**
     * 加密的发送者ID
     */
    private String dingtalkId;

    /**
     * 当前企业内部群中员工userid值
     */
    private String staffId;

    public String getDingtalkId() {
        return dingtalkId;
    }

    public void setDingtalkId(String dingtalkId) {
        this.dingtalkId = dingtalkId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }


}
