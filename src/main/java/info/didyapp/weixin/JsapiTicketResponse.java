package info.didyapp.weixin;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Didy
 */
public class JsapiTicketResponse extends BaseResponse {

    String ticket;

    @JsonProperty("expires_in")
    Integer expiresIn;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

}
