package com.yonyou.teachers.controller;

import com.yonyou.teachers.enity.Teachers;
import com.yonyou.teachers.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/7 15:56
 * @Description: 登录controller
 */

@Controller
public class LoginController {

    @Autowired
    private TeacherService teacherService;

    //使用redis的工具类
    @Autowired
    private StringRedisTemplate redisTemplate;

    /***
     * 项目初始页面
     * @return
     */
    @RequestMapping(value = "/")
    public String index(){
        return "/login";
    }

    /***
     * 通过验证数据库中是否有数据，进行登录校验
     * TODO 没有进行表单验证
     * @param name
     * @param phone
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login")
    public ModelAndView login(String name , String phone){
        //通过数据库查询用户
        Teachers user = teacherService.findByName(name, phone);
        ModelAndView modelAndView = new ModelAndView();
        if (user != null){
            //如果存在用户，跳转到登录页面
            modelAndView.addObject("user",user.getTeacherName());
            modelAndView.setViewName("success");

            // 使用redisTemplate设置key值为user，value值为userName的数据
            redisTemplate.opsForValue().set("user",user.getTeacherName());
        }else {
            //不存在则跳到失败页面
            modelAndView.setViewName("fail");
        }
        return modelAndView;
    }


}
