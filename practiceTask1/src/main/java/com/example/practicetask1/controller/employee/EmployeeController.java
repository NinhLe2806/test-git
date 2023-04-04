package com.example.practicetask1.controller.employee;


import com.example.practicetask1.model.Employee;
import com.example.practicetask1.model.EmployeeDetail;
import com.example.practicetask1.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private  IEmployeeService iEmployeeService;

    //Test
    @GetMapping("/")
    public String test(){
        return "Hello guys I am an Employee";
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return iEmployeeService.addEmployee(employee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestParam("id") long id, @RequestBody Employee employee){
        return iEmployeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable("id") long id){
        return iEmployeeService.deleteEmployee(id);
    }

    @GetMapping("/list")
    public List<Employee> getAllEmployee(){
        return iEmployeeService.getListEmployee();
    }

    @GetMapping("/id")
    public EmployeeDetail getEmployeeDetail(@RequestParam(value = "id", defaultValue = "1") long id) {
        return iEmployeeService.getEmployeeDetail(id);
    }
}
