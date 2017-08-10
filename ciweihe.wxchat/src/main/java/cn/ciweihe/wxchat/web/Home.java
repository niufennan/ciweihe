package cn.ciweihe.wxchat.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2017/8/10.
 */
@Controller
public class Home {
    @RequestMapping(value = {"/","/index"})
    public String index(){
        return "home/index";
    }
}
