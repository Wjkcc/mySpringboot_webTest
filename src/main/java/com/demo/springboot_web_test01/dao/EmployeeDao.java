package com.demo.springboot_web_test01.dao;

import com.demo.springboot_web_test01.pojo.Department;
import com.demo.springboot_web_test01.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Joe
 * @version 1.0
 * @date 2020/3/23 15:52
 */
@Repository
public class EmployeeDao {

    @Autowired
    private DepartmentDao departmentDao;

    private static Map<Integer, Employee> map = null;

    static {
        map = new HashMap<>();

        map.put(2, new Employee(2, "02", 16,new Date(),"12@ee.com",0, 1, new Department(1,"07", new Date())));
        map.put(16, new Employee(16, "广", 16,new Date(),"122@ee.com",1, 1, new Department(1,"07", new Date())));
        map.put(15, new Employee(15, "莓", 16,new Date(),"1211@ee.com",0, 1, new Department(1,"07", new Date())));
    }

    private static Integer initid = 18;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initid++);
        }
        System.out.println("departmentId="+employee.getDepartmentId());
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartmentId()));
        map.put(employee.getId(),employee);

    }

    public Collection<Employee> list() {
        return map.values();
    }

    public boolean del(int id) {
       if (map.containsKey(id)) {
           map.remove(id);
           return true;
       }
       return false;

    }

    public boolean add (Employee employee) {
        if (employee.getId() != null) {
            if (!map.containsKey(employee.getId())) {
                map.put(employee.getId(), employee);
                return true;
            }
        }
        return false;
    }

    public boolean edit (Employee employee) {
        if (map.containsKey(employee.getId())) {
            Department department = departmentDao.getDepartment(employee.getDepartmentId());
            employee.setDepartment(department);
            map.replace(employee.getId(), employee);
            return true;
        }
        return false;
    }

    public Employee get(Integer id) {
        Employee employee = map.get(id);
        return employee;

    }
}
