package info.didyapp.weixin;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Didy
 */
public class WechatAdapter {

    final String appId, appSecret;
    final ObjectMapper objectMapper;
    AccessTokenResponse accessTokenResponse;
    Instant accessTokenExpires;

    public WechatAdapter(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.objectMapper = new ObjectMapper();
    }

    public AccessTokenResponse getAccessToken() throws IOException {
        if (accessTokenResponse == null || Instant.now().isAfter(accessTokenExpires)) {
            String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET"
                    .replaceFirst("APPID", appId)
                    .replaceFirst("APPSECRET", appSecret);

            HttpURLConnection conn = (HttpURLConnection) new URL(requestUrl).openConnection();
            conn.connect();
            conn.getInputStream();
            accessTokenResponse = objectMapper.readValue(conn.getInputStream(), AccessTokenResponse.class);
            accessTokenExpires = Instant.now().plusSeconds(accessTokenResponse.getExpiresIn());
        }
        return accessTokenResponse;
    }

    public String getAuthorizeUrl(String redirectUri, String state) {
        try {
            String requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect"
                    .replaceFirst("APPID", appId)
                    .replaceFirst("REDIRECT_URI", URLEncoder.encode(redirectUri, "utf-8"))
                    .replaceFirst("SCOPE", "snsapi_userinfo")
                    .replaceFirst("STATE", state);
            return requestUrl;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WechatAdapter.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    public String getLoginUrl(String redirectUri, String state) {
        try {
            String requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect"
                    .replaceFirst("APPID", appId)
                    .replaceFirst("REDIRECT_URI", URLEncoder.encode(redirectUri, "utf-8"))
                    .replaceFirst("SCOPE", "snsapi_base")
                    .replaceFirst("STATE", state);
            return requestUrl;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WechatAdapter.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    public UserAccessTokenResponse getUserAccessToken(String code) throws IOException {
        String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code"
                .replaceFirst("APPID", appId)
                .replaceFirst("SECRET", appSecret)
                .replaceFirst("CODE", code);

        HttpURLConnection conn = (HttpURLConnection) new URL(requestUrl).openConnection();
        conn.connect();
        conn.getInputStream();
        return objectMapper.readValue(conn.getInputStream(), UserAccessTokenResponse.class);

    }

    public UserInfoResponse getUserInfo(String openId) throws IOException {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN"
                .replaceFirst("ACCESS_TOKEN", getAccessToken().accessToken)
                .replaceFirst("OPENID", openId);

        HttpURLConnection conn = (HttpURLConnection) new URL(requestUrl).openConnection();
        conn.connect();
        conn.getInputStream();
        return objectMapper.readValue(conn.getInputStream(), UserInfoResponse.class);

    }

    public SendMessageResponse sendTemplateMessage(BaseMessage message) throws IOException {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN"
                .replaceFirst("ACCESS_TOKEN", getAccessToken().accessToken);

        HttpURLConnection conn = (HttpURLConnection) new URL(requestUrl).openConnection();
        byte[] postDataBytes = message.toString().getBytes("UTF-8");
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        conn.getInputStream();
        return objectMapper.readValue(conn.getInputStream(), SendMessageResponse.class);
    }

    public BaseResponse createMenu(MenuRequest menuRequest) throws IOException {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN"
                .replaceFirst("ACCESS_TOKEN", getAccessToken().accessToken);
        HttpURLConnection conn = (HttpURLConnection) new URL(requestUrl).openConnection();
        byte[] postDataBytes = menuRequest.toString().getBytes("UTF-8");
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; encoding=utf-8");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(postDataBytes);

        conn.getInputStream();
        return objectMapper.readValue(conn.getInputStream(), BaseResponse.class);

    }

    public BaseResponse deleteMenu() throws IOException {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN"
                .replaceFirst("ACCESS_TOKEN", getAccessToken().accessToken);

        HttpURLConnection conn = (HttpURLConnection) new URL(requestUrl).openConnection();
        conn.connect();
        conn.getInputStream();
        return objectMapper.readValue(conn.getInputStream(), BaseResponse.class);

    }

    public MenuResponse getMenu() throws IOException {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN"
                .replaceFirst("ACCESS_TOKEN", getAccessToken().accessToken);

        LOG.info(requestUrl);

        HttpURLConnection conn = (HttpURLConnection) new URL(requestUrl).openConnection();
        conn.connect();
        conn.getInputStream();
        return objectMapper.readValue(conn.getInputStream(), MenuResponse.class);
    }

    public JsapiTicketResponse getJsapiTicket() throws IOException {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi"
                .replaceFirst("ACCESS_TOKEN", getAccessToken().accessToken);

        HttpURLConnection conn = (HttpURLConnection) new URL(requestUrl).openConnection();
        conn.connect();
        conn.getInputStream();
        return objectMapper.readValue(conn.getInputStream(), JsapiTicketResponse.class);
    }

    private static final Logger LOG = Logger.getLogger(WechatAdapter.class.getName());
}
