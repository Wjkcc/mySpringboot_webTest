package com.demo.springboot_web_test01.controller;

import com.demo.springboot_web_test01.dao.DepartmentDao;
import com.demo.springboot_web_test01.dao.EmployeeDao;
import com.demo.springboot_web_test01.pojo.Department;
import com.demo.springboot_web_test01.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author Joe
 * @version 1.0
 * @date 2020/3/20 15:38
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @RequestMapping(value = "/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.list();
        for(Employee e:employees) {
            System.out.println(e);
        }
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @DeleteMapping(value = "/emp")
    public String del (Integer id ,Model model) {
        if (employeeDao.del(id)) {
            Collection<Employee> employees = employeeDao.list();

            model.addAttribute("emps",employees);
            return "emp/list";
        }
        return "error";
    }

    @GetMapping("/emp")
    public String toAdd(Model model) {
        Collection<Department> departments = departmentDao.list();
        model.addAttribute("department", departments);
          return "emp/add";
    }

    @PostMapping("/emp")
    public String add(Employee employee) {
        System.out.println(employee);
        employee.setAge(16);
       employeeDao.save(employee);

        return "forward:/emps";
    }
}
