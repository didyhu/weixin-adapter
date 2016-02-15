package info.didyapp.weixin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 报名状态通知
 *
 * @author Didy
 */
public class ApplyInfoMessage extends BaseMessage {

    String first;

    String keynote1;

    String keynote2;

    String remark;

    public ApplyInfoMessage(String toUser, String url, String topColor, String first, String keynote1, String keynote2, String remark) {
        super("Mm3PyRES132KYFq-9DAcBXPPH-KY7nYgUz6UzgJjhGk", toUser, url, topColor, null);
        try {
            Map<String, Data> data = new HashMap<>();
            data.put("first", new Data("#000000", first));
            data.put("keynote1", new Data("#000000", keynote1));
            data.put("keynote2", new Data("#000000", keynote2));
            data.put("remark", new Data("#000000", remark));
            this.data = new ObjectMapper().writeValueAsString(data);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ApplyInfoMessage.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
}
