package info.didyapp.weixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Didy
 */
public class BaseMessage {

    public static class Data {

        @JsonProperty("color")
        String color;

        @JsonProperty("value")
        String value;

        public Data(String color, String value) {
            this.color = color;
            this.value = value;
        }

    }

    @JsonProperty(value = "template_id")
    final String templateId;

    @JsonProperty(value = "touser")
    String toUser;

    @JsonProperty(value = "url")
    String url;

    @JsonProperty(value = "topcolor")
    String topColor;

    @JsonProperty(value = "data")
    String data;

    public BaseMessage(String templateId, String toUser, String url, String topColor, String data) {
        this.templateId = templateId;
        this.toUser = toUser;
        this.url = url;
        this.topColor = topColor;
        this.data = data;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ApplyInfoMessage.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
}
