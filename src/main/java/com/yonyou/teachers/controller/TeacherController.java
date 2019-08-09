package com.yonyou.teachers.controller;

import com.yonyou.teachers.enity.Teachers;
import com.yonyou.teachers.result.Result;
import com.yonyou.teachers.result.StatusCode;
import com.yonyou.teachers.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/7 14:16
 * @Description:   teacherinfo操作
 */
@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    /***
     * 查询所有teacher数据
     * @return
     */
    @RequestMapping(value = "/findall")
    public Result findall(){
        List<Teachers> list = teacherService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",list);
    }

    /***
     * 插入用户数据
     * TODO 判断插入数据，验证是否成功
     * @param teachers
     * @return
     */
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public Result save(@RequestBody Teachers teachers){
        teacherService.insert(teachers);
        return new Result(true, StatusCode.OK,"插入成功");
    }

    /***
     * 过滤出年龄在35岁以上并且工资大于5000的老师。
     * @return
     */
    @RequestMapping(value = "/findbyage")
    public Result findByAgeAndSalary(){
        List<Teachers> list = teacherService.findByAgeAndSalary();
        return new Result(true, StatusCode.OK,"查询成功",list);
    }

}
