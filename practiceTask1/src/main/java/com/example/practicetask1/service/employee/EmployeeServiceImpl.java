package com.example.practicetask1.service.employee;

import com.example.practicetask1.model.Employee;
import com.example.practicetask1.model.EmployeeDetail;
import com.example.practicetask1.model.Product;
import com.example.practicetask1.repository.employee.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository empRepo;

    public EmployeeServiceImpl(EmployeeRepository empRepo){
        this.empRepo=empRepo;
    }


    @Autowired
    private ApiCall apiCall;

    @Autowired
    private FeignService feignService;


    @Override
    public Employee addEmployee(Employee emp) {
        if(emp!=null){
            return empRepo.save(emp);
        }
        return null;
    }

    @Override
    public Employee updateEmployee(long id, Employee emp) {
        if(emp!=null){
            Employee employee = empRepo.findById(id).orElse(null);
            if(employee!=null){
                employee.setName(emp.getName());
                employee.setAddress(emp.getAddress());

                return empRepo.save(employee);
            }
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(long id) {
        if (id >= 1) {
            Employee employee = empRepo.findById(id).orElse(null);
            if(employee!=null){
                empRepo.delete(employee);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Employee> getListEmployee() {
        return empRepo.findAll();
    }

    @Override
    public Employee getEmployee(long id) {
        return empRepo.findById(id).orElse(null);
    }


    @Override
    public EmployeeDetail getEmployeeDetail(long id) {
        Employee emp = empRepo.findById(id).orElse(null);

//      Product product = apiCall.getProductDetails(emp.getProductId());

        Product product = feignService.findProductById(emp.getProductId());

        EmployeeDetail empDetail = new EmployeeDetail();
        BeanUtils.copyProperties(emp,empDetail);
        empDetail.setProduct(product);

        return empDetail;
    }
}
