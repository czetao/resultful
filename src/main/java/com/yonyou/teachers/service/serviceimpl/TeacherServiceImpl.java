package com.yonyou.teachers.service.serviceimpl;

import com.yonyou.teachers.dao.TeachersDao;
import com.yonyou.teachers.enity.Teachers;
import com.yonyou.teachers.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/7 14:13
 * @Description:
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeachersDao teachersDao;

    /***
     * 查询所有
     * @return  返回所有信息
     */
    @Override
    public List<Teachers> findAll() {
        return teachersDao.findAll();
    }

    /***
     * 插入数据
     * @param teachers
     */
    @Override
    public void insert(Teachers teachers) {
         teachersDao.save(teachers);
    }

    /***
     * 过滤出年龄在35岁以上并且工资大于5000的老师。
     * @return
     */
    @Override
    public List<Teachers> findByAgeAndSalary() {
        return teachersDao.findByAgeAndSalary();
    }

    @Override
    public Teachers findByName(String name ,String phone) {
        return teachersDao.findByName(name,phone);
    }


}
