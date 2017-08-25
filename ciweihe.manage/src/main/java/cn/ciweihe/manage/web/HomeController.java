package cn.ciweihe.manage.web;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by admin on 2017/8/16.
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/","index"})
    public String index(Model model, HttpSession session){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "home/index";
    }
}
