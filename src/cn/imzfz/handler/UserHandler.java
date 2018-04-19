package cn.imzfz.handler;

import cn.imzfz.model.User;
import cn.imzfz.service.ILogin;
import cn.imzfz.service.IPersist;
import cn.imzfz.service.ISelect;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    public String login(Map<String, Object> map){

        logger.info("select");

        map.put("users", select.findAll());

        logger.info(map.size());

        return "editusers";
    }
}
