package info.didyapp.weixin;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Didy
 */
public class SendMessageResponse extends BaseResponse {

    @JsonProperty("msgid")
    String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

}
