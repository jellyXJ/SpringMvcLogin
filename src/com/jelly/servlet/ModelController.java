package com.jelly.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

//控制类--注解@Controller--控制器
@Controller
@SessionAttributes("userName")
public class ModelController {
    //@PostMapping("/modelController")--映射，页面提交的地址和提交方式
    @PostMapping("/modelController")

    public ModelAndView login(
            @RequestParam("userName") String name,//@RequestParam拿到表单提交的参数--创建变量接受参数
            @RequestParam("password") String password,
            //Model model//加入Model参数--Spring会隐式创建Model对象，可以直接拿来用
            ModelAndView modelAndView//ModelAndView--既包括模型数据信息，又包括视图信息--此时方法返回ModelAndView对象，而不是字符串

    ){
        //将用户名保存到Model--键值对的形式
       // model.addAttribute("userName",name);
        //相当于跳到success页面--可以用  ${requestScope.userName} 页面拿到userName，实现  M----->V的交互
       // return "success";
        //ModelAndView对象设置数据信息和试图信息
        modelAndView.addObject("userName",name);//键值对保存--页面拿${requestScope.userName}
        modelAndView.setViewName("success");//跳到的页面
        return modelAndView;
    }

}
