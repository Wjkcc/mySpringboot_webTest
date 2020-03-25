package com.demo.springboot_web_test01.pojo;

import java.util.Date;

/**
 * @author Joe
 * @version 1.0
 * @date 2020/3/23 15:54
 */
public class Employee {

    private Integer id;
    private String name;
    private Integer age;
    private Date birth;
    private String email;
    private Integer sex;
    private Integer departmentId;
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", departmentId=" + departmentId +
                ", department=" + department +
                '}';
    }

    public Employee(Integer id, String name, Integer age, Date birth, String email, Integer sex, Integer departmentId, Department department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.email = email;
        this.sex = sex;
        this.departmentId = departmentId;
        this.department = department;
    }
}
