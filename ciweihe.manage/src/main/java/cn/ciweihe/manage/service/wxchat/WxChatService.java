package cn.ciweihe.manage.service.wxchat;
import java.util.Map;

/**
 * Created by admin on 2017/8/28.
 */
public interface WxChatService {
    public String getToken();
    public Map<String,Object> getWxChatButton();
}
