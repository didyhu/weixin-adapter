package info.didyapp.weixin;

//{
import com.fasterxml.jackson.annotation.JsonProperty;

//   "access_token":"ACCESS_TOKEN",
//   "expires_in":7200,
//   "refresh_token":"REFRESH_TOKEN",
//   "openid":"OPENID",
//   "scope":"SCOPE",
//   "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
//}

/**
 *
 * @author Didy
 */
public class UserAccessTokenResponse extends BaseResponse {

    @JsonProperty("access_token")
    String accessToken;

    @JsonProperty("expires_in")
    Integer expiresIn;

    @JsonProperty("refresh_token")
    String refreshToken;

    @JsonProperty("openid")
    String openId;

    @JsonProperty("scope")
    String scope;

    @JsonProperty("union_id")
    String unionId;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

}
