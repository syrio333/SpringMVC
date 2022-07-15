package com.example.dao;

/*
    @author syrio
    @date 2022/6/13
    @time 17:30
    @description 员工 数据访问层
*/

import com.example.bean.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "aaa", 1, "aaa@163.com"));
        employees.put(1002, new Employee(1002, "bbb", 0, "bbb@163.com"));
        employees.put(1003, new Employee(1003, "ccc", 1, "ccc@163.com"));
        employees.put(1004, new Employee(1004, "ddd", 0, "ddd@163.com"));
        employees.put(1005, new Employee(1005, "eee", 1, "eee@163.com"));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee getById(Integer id) {
        return employees.get(id);
    }

    public void deleteById(Integer id) {
        employees.remove(id);
    }

}
