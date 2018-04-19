package cn.imzfz.handler;

import cn.imzfz.constant.SexList;
import cn.imzfz.model.User;
import cn.imzfz.service.ILogin;
import cn.imzfz.service.IPersist;
import cn.imzfz.service.ISelect;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
 * 对用户增删改查的控制器
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

    /**
     * 显示用户页面
     * @param map 将要返回给jsp所展示的用户List类
     * @param model 预先加载一个对象，防止jsp页面空指针报错
     * @return 到用户列表页
     */
    @RequestMapping("/editusers")
    public String showUsers(Map<String, Object> map, Model model){
        model.addAttribute("user", new User());
        map.put("users", select.findAll());

        return "editusers";
    }

    /**
     * 添加用户页面
     * @param user 从jsp中传入的实体类
     * @return 返回用户列表页
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(User user){

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

    /**
     * DELETE方式提交 删除某个id的用户
     * @param id 需要删除的用户id
     * @return 返回到用户列表页
     */
    @RequestMapping(value = "/editusers/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        persist.delUser(id);
        return "redirect:/editusers";
    }

    /**
     * 将从数据库中查询到的需要编辑的用户返回到jsp页面中
     * @param id 用户id
     * @param map 返回一个用户Map中的用户对象
     * @param model 预先加载一个对象，防止jsp页面空指针报错
     * @return
     */
    @RequestMapping(value = "/editusers/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer id, Map<String, Object> map, Model model){
        model.addAttribute("user", new User());
        map.put("user", select.findUserById(id));
        return "update";
    }

    /**
     * 以PUT方式提交被编辑的用户对象，操作数据库更新数据
     * @param user 从jsp中获取到的对象
     * @return 返回用户列表页
     */
    @RequestMapping(value = "/editusers", method = RequestMethod.PUT)
    public String modify(User user){
        persist.updateUser(user);
        return "redirect:/editusers";
    }
}
