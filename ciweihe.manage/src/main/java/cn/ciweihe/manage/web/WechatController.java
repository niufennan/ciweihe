package cn.ciweihe.manage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2017/8/21.
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {
    private String format="wechat/%s";
    @RequestMapping("/menu")
    public String menu(){
        return String.format(format,"menu");
    }
}
