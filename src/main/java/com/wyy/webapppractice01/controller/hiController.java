package com.wyy.webapppractice01.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//把字符串返回到前端
public class hiController {
    @GetMapping("/hi")//映射输入路径
    @RequestMapping("/hi")//映射下面执行的操作
    public String hi(){
        return "hi springboot";
    }

}
