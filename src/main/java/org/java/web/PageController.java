package org.java.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class PageController {

    //页面跳转控制器
        @GetMapping("/forward/{target}")
        public String forward(@PathVariable("target") String target) {

            return "/" + target;
        }

        //所有请求一开始加载就自动发请求，进行该控制器
        @Controller
        public class FirstController {

            @RequestMapping("/")
            public String first(HttpSession session, Model model){
                //获得认证的主体
                Subject subject= SecurityUtils.getSubject();
                Map map= (Map) subject.getPrincipal();
                session.setAttribute("username",map.get("userName"));
                model.addAttribute("menus",map.get("menus"));
                return "/index";
            }
        }
}
