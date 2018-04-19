package cn.imzfz.handler;

import cn.imzfz.model.Record;
import cn.imzfz.model.User;
import cn.imzfz.service.ILogin;
import cn.imzfz.service.IPersist;
import cn.imzfz.service.ISelect;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zfz on 2018/4/17.
 * 登录控制器
 */

@Controller
public class LoginHandler {
    Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private ISelect<User> select;
    @Resource
    private IPersist<User> persist;
    @Resource
    private ILogin login;


    /*@RequestMapping("/")
    public String isLogin(HttpServletRequest request, Model model){
        model.addAttribute("user", new User());
        User user = (User)request.getSession().getAttribute("user");
        if(user != null){
            return "redirect:/editusers";
        }
        return "index";

    }*/

    /**
     * 登录验证
     * @param request
     * @return 登录成功则转到editusers页面，否则转到主页
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        String loginName = request.getParameter("user");
        String password = request.getParameter("password");
        User user;
        if(login.isValidUser(loginName, password)){
            request.getSession().setAttribute("isLogin", "1");
            user = select.findUserByLoginName(loginName);
            request.getSession().setAttribute("user", user);
//            loginInfo(request);
            return "redirect:editusers";
        }
        return "redirect:/";
    }
}
