package com.jd.xiahongyun.controller;

/**
 *@注册类
 *@创建者：夏洪运
 *@功能：对注册信息进行处理与返回
 *
 */

import com.jd.xiahongyun.Base.User;
import com.jd.xiahongyun.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegistrationController {

   /* @ResponseBody
    @RequestMapping(value="/print", method= RequestMethod.GET)
    public String print()
    {
        return "welcome";
    }*/

    @Autowired
    UserDao userService;

    @RequestMapping(value="/register", method= RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response)
    {
        //System.out.println("register");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        mav.addObject("user", new User());
        return mav;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user")User user)
    {
        userService.register(user);
        return new ModelAndView("welcome", "firstName", user.getFirstname());
    }
}
