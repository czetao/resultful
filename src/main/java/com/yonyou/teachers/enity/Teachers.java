package com.yonyou.teachers.enity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @Auther: 陈泽涛
 * @Date: 2019/8/7 13:55
 * @Description: id，teacherName，sex，salary，age，mobile teachersinfo 测试
 */

@Entity
@Table(name = "teachers")
public class Teachers {

    @Id
    @GeneratedValue(generator = "IDENTITY")
    private Integer id;

    private String teacherName;
    private String sex;
    private Integer salary;
    private Integer age;
    private String mobile;

    @Override
    public String toString() {
        return "Teachers{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        Teachers teachers = (Teachers) o;
        return Objects.equals(id, teachers.id) &&
                Objects.equals(teacherName, teachers.teacherName) &&
                Objects.equals(sex, teachers.sex) &&
                Objects.equals(salary, teachers.salary) &&
                Objects.equals(age, teachers.age) &&
                Objects.equals(mobile, teachers.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teacherName, sex, salary, age, mobile);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
