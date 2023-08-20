package com.imooc.pan.server.controller;

import com.imooc.pan.core.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
public class HelloController {
    @GetMapping("hello")
    public R<String> hello(@RequestParam(name = "name")@NotBlank(message = "name不能为空") String name){
        System.out.println(Thread.currentThread().getContextClassLoader());
        return R.success("hello" +name +"1");
    }

}
