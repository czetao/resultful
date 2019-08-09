package com.yonyou.teachers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/7 17:07
 * @Description: 第五点，直接跳转success
 */
@Controller
public class SuccessController {


    /***
     *  使用redis的工具类
     */
    @Autowired
    private StringRedisTemplate redisTemplate;

    /***
     * 对直接进入success的进行判断
     * @return
     */
    @RequestMapping("/success")
    public ModelAndView successful(){
        //从redis中拿user数据
        String user = redisTemplate.opsForValue().get("user");
        ModelAndView modelAndView = new ModelAndView();
        if(user != null){
            //对user进行判断，成功进页面
           modelAndView.addObject("user",user);
           modelAndView.setViewName("success");
        }else {
            //失败跳到失败页面
            modelAndView.setViewName("fail");
        }
        return modelAndView;
    }
}
