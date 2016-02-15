package info.didyapp.weixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//{
//   "openid":" OPENID",
//   "nickname": NICKNAME,
//   "sex":"1",
//   "province":"PROVINCE"
//   "city":"CITY",
//   "country":"COUNTRY",
//   "headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46", 
//   "privilege":[
//	"PRIVILEGE1"
//	"PRIVILEGE2"
//   ],
//   "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
//}

/**
 *
 * @author Didy
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoResponse extends BaseResponse {

    @JsonProperty("subscribe")
    Integer subscribe;

    @JsonProperty("openid")
    String openId;

    @JsonProperty("nickname")
    String nickname;

    @JsonProperty("sex")
    Integer sex;

    @JsonProperty("province")
    String province;

    @JsonProperty("city")
    String city;

    @JsonProperty("country")
    String country;

    @JsonProperty("headimgurl")
    String headImgUrl;

    @JsonProperty("privilige")
    List<String> priviliges;

    @JsonProperty("unionid")
    String unionId;

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public List<String> getPriviliges() {
        return priviliges;
    }

    public void setPriviliges(List<String> priviliges) {
        this.priviliges = priviliges;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

}
