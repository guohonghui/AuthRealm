package com.org.controller;

import com.org.annotation.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通用跳转页面
 * Created by GuoHonghui on 2019-01-19 10:32.
 */
@Controller
public class CommonController {

    /**
     * 任何空的请求跳转到login登录页
     * @return
     */
    @GetMapping(value = "")
    public String loginInit(){
        return loginCheck();
    }


    @GetMapping(value = "goLogin")
    public String goLogin(Model model){
        Subject sub=SecurityUtils.getSubject();
        if(sub.isAuthenticated()){
            return "/main/main";
        }else{
            model.addAttribute("message","请重新登录");
            return "/login";
        }
    }

    /**
     * 跳转登录页
     * @return
     */
    @GetMapping(value = "/login")
    public String loginCheck(){
        //获取登录身份（检查是否被有用户登录）
        Subject sub = SecurityUtils.getSubject();
        //是否记住密码
        Boolean flag2 = sub.isRemembered();
        //检测到登录用户记住密码并获取到登录身份
        boolean flag = sub.isAuthenticated()||flag2;
        //获取session状态
        Session session=sub.getSession();
        //判断如何获取到用户登录或者用户其他session有效身份(true)跳转到mian主页，否则跳到login进行登录
        if(flag){
            return "/main/main";
        }
        return "/login";
    }

    @Log(desc = "用户退出平台")
    @GetMapping(value = "/logout")
    public String logout() {
        Subject sub = SecurityUtils.getSubject();
        sub.logout();
        return "/login";
    }
}
