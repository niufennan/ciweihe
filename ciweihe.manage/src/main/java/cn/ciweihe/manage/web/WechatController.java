package cn.ciweihe.manage.web;

import cn.ciweihe.manage.service.wxchat.WxChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by admin on 2017/8/21.
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {
    private String format="wechat/%s";
    @Autowired
    WxChatService wxChatService;
    @RequestMapping("/menu")
    public String menu(Model model){
        Map<String,Object> map= wxChatService.getWxChatButton();
        if(map.containsKey("error")){
            model.addAttribute("msg",map.get("error"));
        }

        return String.format(format,"menu");
    }
}
