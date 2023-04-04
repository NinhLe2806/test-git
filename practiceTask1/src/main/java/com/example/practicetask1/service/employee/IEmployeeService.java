package com.example.practicetask1.service.employee;

import com.example.practicetask1.model.Employee;
import com.example.practicetask1.model.EmployeeDetail;

import java.util.List;

public interface IEmployeeService {
    public Employee addEmployee(Employee emp);

    public Employee updateEmployee(long id, Employee emp);

    public boolean deleteEmployee(long id);

    public List<Employee> getListEmployee();

    public Employee getEmployee(long id);

    public EmployeeDetail getEmployeeDetail(long id);

}
