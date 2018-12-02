package com.example.springbootshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.apache.shiro.subject.Subject;



@Controller
public class UserController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world";
    }
    @RequestMapping("/add")
    public String add(){
        return "/user/add";
    }
    @RequestMapping("/unAuth")
    public String unAuth(){
        return "/unAuth";
    }
    @RequestMapping("/update")
    public String update(){
        return "/user/update";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(String name,String password,Model model){
        /**
         * 使用shiro编写认证操作
         */
         // 1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        //3.执行方法
        try {
            subject.login(token);
            //登录成功 跳转到test.html
            return "redirect:/testThymeleaf";
        }catch(UnknownAccountException e){
            //登录失败：用户名不存在
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch(IncorrectCredentialsException e){
            //登录失败，密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model){
        //把数据存入model
        model.addAttribute("name","Thymeleaf测试程序");
        //返回test.html
        return "test";
    }

}
