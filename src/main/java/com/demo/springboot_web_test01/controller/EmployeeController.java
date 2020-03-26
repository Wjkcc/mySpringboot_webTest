package com.demo.springboot_web_test01.controller;

import com.demo.springboot_web_test01.dao.DepartmentDao;
import com.demo.springboot_web_test01.dao.EmployeeDao;
import com.demo.springboot_web_test01.pojo.Department;
import com.demo.springboot_web_test01.pojo.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping(value = "/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.list();
        for(Employee e:employees) {
            System.out.println(e);
        }
        model.addAttribute("emps",employees);
        return "emp/list";
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

        return "redirect:/emps";
    }

    @GetMapping("/edit/{id}")
    public String toEdit(Model model,@PathVariable("id") Integer id) {
        Collection<Department> departments = departmentDao.list();
        model.addAttribute("department", departments);
        Employee employee = employeeDao.get(id);

        log.info("edit" +employee);
        model.addAttribute("emp", employee);
        return "emp/edit";
    }

    @PutMapping("/emp")
    public String edit(Employee employee) {
        System.out.println(employee);
        employeeDao.edit(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String del(@PathVariable("id") Integer id) {
        employeeDao.del(id);
        return "redirect:/emps";
    }
}
