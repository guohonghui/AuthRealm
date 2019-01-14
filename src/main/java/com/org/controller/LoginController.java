package com.org.controller;

import com.org.annotation.Log;
import com.org.entity.SysUser;
import com.org.filter.VerifyCodeUtils;
import com.org.utils.ShiroUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录、退出页面
 */
@Controller
public class LoginController {

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

      /**
       * 登录动作
       * @param user
       * @param model
       * @param rememberMe
       * @return
       */
      @ApiOperation(value = "/login", httpMethod = "POST", notes = "登录method")
      @PostMapping(value = "/login")
      public String login(SysUser user,Model model,String rememberMe,HttpServletRequest request){
        //获取setAttribute key
        String codeMsg = (String)request.getAttribute("shiroLoginFailure");
        if("code.error".equals(codeMsg)){
          model.addAttribute("message","验证码错误");
          return "/login";
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername().trim(), user.getPassword());
        Subject subject = ShiroUtil.getSubject();
        String msg=null;
        try{
          subject.login(token);
          if(subject.isAuthenticated()){
            return "/main/main";
          }
        }catch (UnknownAccountException e) {
          msg = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
          msg = "用户名/密码错误";
        } catch (ExcessiveAttemptsException e) {
          msg = "登录失败多次，账户锁定10分钟";
        }
        if(msg!=null){
          model.addAttribute("message",msg);
        }
        return "/login";
      }

      @Log(desc = "用户退出平台")
      @GetMapping(value = "/logout")
      public String logout(){
        Subject sub=SecurityUtils.getSubject();
        sub.logout();
        return "/login";
      }

      @GetMapping(value="/getCode")
      public void getYzm(HttpServletResponse response, HttpServletRequest request){
        try {
          response.setHeader("Pragma", "No-cache");
          response.setHeader("Cache-Control", "no-cache");
          response.setDateHeader("Expires", 0);
          response.setContentType("image/jpg");

          //生成随机字串
          String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
          //存入会话session
          HttpSession session = request.getSession(true);
          session.setAttribute("_code", verifyCode.toLowerCase());
          //生成图片
          int w = 146, h = 33;
          VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
}
