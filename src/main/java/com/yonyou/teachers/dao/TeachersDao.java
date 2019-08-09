package com.yonyou.teachers.dao;

import com.yonyou.teachers.enity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/7 14:07
 * @Description:
 */
public interface TeachersDao extends JpaRepository<Teachers,Integer> {

    @Query(value = "select id,teacher_name,sex,salary,age,mobile from teachers where age >35 and salary >5000", nativeQuery = true)
    List<Teachers> findByAgeAndSalary();

    @Query(value = "select id,teacher_name,sex,salary,age,mobile from teachers where teacher_name = ?1 and mobile = ?2", nativeQuery = true)
    Teachers findByName(String name ,String phone);
}
