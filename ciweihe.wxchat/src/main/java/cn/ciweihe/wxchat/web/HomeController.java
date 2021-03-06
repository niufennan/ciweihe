package cn.ciweihe.wxchat.web;

import cn.ciweihe.wxchat.service.WxChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

/**
 * Created by admin on 2017/8/10.
 */
@Controller
public class HomeController {

    @Autowired
    WxChatService wxChatService;

    @RequestMapping(value = {"/","/index"})
    public String index(Model model) throws InterruptedException {
        model.addAttribute("token",wxChatService.getToken());
        return "home/index";
    }
}
