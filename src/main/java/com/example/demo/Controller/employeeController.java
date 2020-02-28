package com.example.demo.Controller;


import com.example.demo.Service.IEmployeeService;
import com.example.demo.bean.Employees;
import com.example.demo.bean.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1")
public class employeeController {

    @Autowired
    private IEmployeeService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("employees")
    public Response createemployee(@RequestBody Employees employees){
        return service.createEmployees(employees);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("employees")
    public List<Employees> getemployees(){
        return service.getEmployees();
    }

    @GetMapping("employees/{id}")
    public Employees getaEmployee(@PathVariable Long id) throws Exception {
        return service.getaEmployee(id);
    }
    @DeleteMapping("employees/{id}")
    public Response DeleteEmployee(@PathVariable Long id){
        return service.deleteEmployee(id);
    }
    @DeleteMapping("employees")
    public Response DeleteAllEmployee(){
        return service.deleteAllEmployee();
    }
    @GetMapping("employees/name/{name}")
    public List<Employees> getaEmployee(@PathVariable("name") String name){
        return service.getaEmployeebyname(name);
    }
    @GetMapping("employees/designation/{designation}")
    public List<Employees> getaEmployeebydesignation(@PathVariable("designation") String designation){
        return service.getaEmployeebydesignation(designation);
    }
    @GetMapping("employees/salary/")
    public List<Employees> getEmployeebySalary(){
        return service.getaEmployeebysalary();
    }
    @GetMapping("employees/namedistinct/")
    public List<Employees> getEmployeeDistinct(){
        return service.getaEmployeeDistinct();
    }
    @GetMapping("employees/maxSalary/")
    public List<Employees> getEmployeeWithMaxSalary(){
        return service.getEmployeebyMaxsalary();
    }

}
