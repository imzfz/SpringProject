package cn.imzfz.handler;

import cn.imzfz.model.User;
import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zfz on 2018/4/18.
 */
public class LoginInterceptor implements HandlerInterceptor {

    Logger logger = Logger.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        logger.info("interceptor");
        if (httpServletRequest.getSession().getAttribute("isLogin") == null ||
                httpServletRequest.getSession().getAttribute("isLogin").equals("-1")) {
            httpServletResponse.sendRedirect("/");
            logger.info("interceptor111");
            return false;
        }
        httpServletResponse.sendRedirect("editusers");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
