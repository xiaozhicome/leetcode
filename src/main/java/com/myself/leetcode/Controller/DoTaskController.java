package com.myself.leetcode.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class DoTaskController {

    @RequestMapping("/this")
    public String doTask(){
        return "this is me";
    }

    @RequestMapping("/do/{num}")
    public String doTaskNum(@PathVariable int num){
        return "this is "+num*10;
    }

    @RequestMapping("/body")
    public String doTask(@RequestParam("name")String name,@RequestParam("code")String code){
        return "this is "+name+" "+code;
    }
}
