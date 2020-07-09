package com.wyy.webapppractice01.controller;


import com.wyy.webapppractice01.mapper.UserMapper;
import com.wyy.webapppractice01.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller//把字符串返回到前端,用字符串返回
public class hiController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/register")//映射输入路径
    public String reg(){    //防止直接跳转到register页面
        return "register";
    }
    @RequestMapping("/register")//映射下面执行的操作
    public String register(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userMapper.getuser(username);
        if(user1!=null){
            map.put("msg1","the user has been userd,please register again");
            return "register";
        }else {
            userMapper.adduser(user);
            return "login";
        }

    }
    @RequestMapping("/getuser")
    public String getuser(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        User user = userMapper.getuser(username);
        if(user!=null){
            map.put("msg","the user has been registered!");
            return "register";
        }else {
            map.put("msg","the user has not been used");
            return "register";
        }
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginuser = userMapper.login(username, password);
        System.out.println(loginuser);
        map.put("msg2","the user  "+loginuser+"login");
        return "login";
    }
}
