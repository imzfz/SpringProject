package cn.imzfz.handler;

import cn.imzfz.constant.SexList;
import cn.imzfz.model.User;
import cn.imzfz.service.ILogin;
import cn.imzfz.service.IPersist;
import cn.imzfz.service.ISelect;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zfz on 2018/4/19.
 */

@Controller
public class UserHandler {
    Logger logger = Logger.getLogger(this.getClass());

    @Resource
    private ISelect<User> select;
    @Resource
    private IPersist<User> persist;
    @Resource
    private ILogin login;

    @RequestMapping("/editusers")
    public String showUsers(Map<String, Object> map, Model model){
        model.addAttribute("user", new User());
        map.put("users", select.findAll());

        return "editusers";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(User user, BindingResult result){

        if(user.getSex().equals("0")){
            user.setSex(SexList.Male.getSex());
        }
        else {
            user.setSex(SexList.Female.getSex());
        }

        if(StringUtils.isBlank(user.getLoginName())){
            return "redirect:errorpage.jsp";
        }

        if(select.findUserByLoginName(user.getLoginName()) == null) {
            persist.addUser(user);
        }

        return "redirect:/editusers";
    }

    @RequestMapping(value = "/editusers/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        persist.delUser(id);
        return "redirect:/editusers";
    }
}
