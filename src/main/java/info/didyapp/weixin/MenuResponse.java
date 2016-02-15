package info.didyapp.weixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.csdra.weixin.MenuRequest.Button;

import java.util.List;

/**
 *
 * @author Didy
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuResponse extends BaseResponse {

    @JsonProperty("menu")
    public Menu menu;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Menu {

        @JsonProperty("button")
        public List<Button> buttons;

    }

}
