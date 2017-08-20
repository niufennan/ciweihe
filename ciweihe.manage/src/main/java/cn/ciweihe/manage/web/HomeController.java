package cn.ciweihe.manage.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by admin on 2017/8/16.
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"/","index"})
    public String index(Model model){
        model.addAttribute("name", "Dear");
        return "home/index";
    }
}
