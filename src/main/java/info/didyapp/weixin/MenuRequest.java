package info.didyapp.weixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//    "button": [
//        {
//            "name": "扫码", 
//            "sub_button": [
//                {
//                    "type": "scancode_waitmsg", 
//                    "name": "扫码带提示", 
//                    "key": "rselfmenu_0_0", 
//                    "sub_button": [ ]
//                }, 
//                {
//                    "type": "scancode_push", 
//                    "name": "扫码推事件", 
//                    "key": "rselfmenu_0_1", 
//                    "sub_button": [ ]
//                }
//            ]
//        }, 
//        {
//            "name": "发图", 
//            "sub_button": [
//                {
//                    "type": "pic_sysphoto", 
//                    "name": "系统拍照发图", 
//                    "key": "rselfmenu_1_0", 
//                   "sub_button": [ ]
//                 }, 
//                {
//                    "type": "pic_photo_or_album", 
//                    "name": "拍照或者相册发图", 
//                    "key": "rselfmenu_1_1", 
//                    "sub_button": [ ]
//                }, 
//                {
//                    "type": "pic_weixin", 
//                    "name": "微信相册发图", 
//                    "key": "rselfmenu_1_2", 
//                    "sub_button": [ ]
//                }
//            ]
//        }, 
//        {
//            "name": "发送位置", 
//            "type": "location_select", 
//            "key": "rselfmenu_2_0"
//        },
//        {
//           "type": "media_id", 
//           "name": "图片", 
//           "media_id": "MEDIA_ID1"
//        }, 
//        {
//           "type": "view_limited", 
//           "name": "图文消息", 
//           "media_id": "MEDIA_ID2"
//        }
//    ]
//}

/**
 *
 * @author Didy
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuRequest {

    @JsonProperty("button")
    public List<Button> buttons;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Button {

        public String type;
        public String name;
        public String key;
        public String url;

        @JsonProperty("sub_button")
        public List<Button> subButtons;
    }

    /**
     * 点击推事件
     */
    public static class ClickButton extends Button {

        public final String type = "click";

    }

    /**
     * 跳转URL
     */
    public static class ViewButton extends Button {

        public String type = "view";
    }

    /**
     * 扫码推事件且弹出“消息接收中”提示框
     */
    public static class ScancodeWaitMsgButton extends Button {

        public String type = "scancode_waitmsg";
    }

    /**
     * 扫码推事件
     */
    public static class ScancodePushButton extends Button {

        public String type = "scancode_push";
    }

    /**
     * 弹出系统拍照发图
     */
    public static class PicSysPhotoButton extends Button {

        public String type = "pic_sysphoto";
    }

    /**
     * 弹出拍照或者相册发图
     */
    public static class PicPhotoOrAlbumButton extends Button {

        public String type = "pic_photo_or_album";
    }

    /**
     * 弹出微信相册发图器
     */
    public static class PicWeixinButton extends Button {

        public String type = "pic_weixin";
    }

    /**
     * 弹出地理位置选择器
     */
    public static class LocationSelectButton extends Button {

        public String type = "location_select";
    }

    /**
     * 下发消息（除文本消息）
     */
    public static class MediaButton extends Button {

        public String type = "media_id";
    }

    /**
     * 跳转图文消息URL
     */
    public static class ViewLimitedButton extends Button {

        public String type = "view_limited";
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(MenuRequest.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
}
