package com.jd.xiahongyun.controller;

/*
* @登录类
* @创建者：夏洪运
* @功能：对登录界面进行处理
* */


import com.jd.xiahongyun.Base.Login;
import com.jd.xiahongyun.Base.User;
import com.jd.xiahongyun.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Controller
public class LoginController {

    @Resource
    UserDao userService;

    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value="/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login")Login login)
    {
        ModelAndView mav = null;
        User user = userService.validateUser(login);
        if(null != user)
        {
            mav = new ModelAndView("welcome");

            mav.addObject("firstname", user.getFirstname());
        }else{
            mav = new ModelAndView("login");

            mav.addObject("message", "Username or Password is wrong!!");
        }

        return mav;
    }
}
