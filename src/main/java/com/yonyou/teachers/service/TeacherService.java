package com.yonyou.teachers.service;

import com.yonyou.teachers.enity.Teachers;

import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/7 14:12
 * @Description:
 */
public interface TeacherService {
    /***
     * 查询所有信息
     * @return
     */
    List<Teachers> findAll();

    /***
     * 通过前端post请求，添加数据库用户
     * @param teachers
     */
    void insert(Teachers teachers);

    List<Teachers> findByAgeAndSalary();

    Teachers findByName(String name,String phone);
 }
