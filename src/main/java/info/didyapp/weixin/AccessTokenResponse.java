package info.didyapp.weixin;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Didy
 */
public class AccessTokenResponse extends BaseResponse {

    @JsonProperty("access_token")
    String accessToken;

    @JsonProperty("expires_in")
    Integer expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

}
