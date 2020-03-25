package com.demo.springboot_web_test01.dao;

import com.demo.springboot_web_test01.pojo.Department;
import com.demo.springboot_web_test01.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Delayed;

/**
 * @author Joe
 * @version 1.0
 * @date 2020/3/24 14:19
 */
@Repository
public class DepartmentDao {

    private static Map<Integer, Department> map = null;

    static {
        map = new HashMap<>();

        map.put(1, new Department(1,"07", new Date()));
        map.put(2, new Department(2,"072", new Date()));
        map.put(3, new Department(3,"071", new Date()));

    }

    private static Integer initid = 3;

    public void save (Department department) {
        if (department.getId() == null) {
            department.setId(initid++);
        }
        map.put(department.getId(), department);
    }

    public Collection<Department> list() {
        return map.values();
    }

    public Department getDepartment(Integer id) {
        return map.get(id);
    }
}
