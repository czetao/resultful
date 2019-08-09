package com.yonyou.teachers;

import com.yonyou.teachers.dao.TeachersDao;
import com.yonyou.teachers.enity.Teachers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeachersApplicationTests {

    @Autowired
    private TeachersDao teachersDao;
    //使用redis的工具类
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void contextLoads() {

        System.out.println(teachersDao.findByName("zzz","16265421"));
    }


    /***
     * 优化2，使用匿名内部类
     * 定义过滤方法
     */
    public List<Teachers> filterTeachersByPredicate(List<Teachers> list, MyPredicate<Teachers> mp){
        List<Teachers> prods = new ArrayList<>();
        for (Teachers tea : list){
            if (mp.test(tea)){
                prods.add(tea);
            }
        }
        return prods;
    }
    @Test
    public void test2(){
        List<Teachers> list = teachersDao.findAll();
        //通过匿名内部类的方法对数据进行过滤
        List<Teachers> teachers = filterTeachersByPredicate(list, new MyPredicate<Teachers>() {
            @Override
            public boolean test(Teachers teachers) {
                return teachers.getAge() > 35 && teachers.getSalary()>5000;
            }
        });
        System.out.println(teachers);

    }


    /***
     * 使用lambda表达式
     */
    @Test
    public void test3(){
        List<Teachers> list = teachersDao.findAll();
        List<Teachers> teachers = filterTeachersByPredicate(list, (p) -> p.getSalary() > 5000 & p.getAge() > 35);
        System.out.println(teachers);
    }

    @Test
    public void redisTest(){
        redisTemplate.opsForValue().set("user","ddd");
    }
}
