package com.example.demo.Service;

import com.example.demo.Exception.InvalidRequestException;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.bean.Employees;
import com.example.demo.bean.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

@Autowired
    private EmployeeRepository repository;
@Override
    public Response createEmployees(Employees employees)
    {
        Employees employee = new Employees();
        employee.setName(employees.getName());
        employee.setSalary(employees.getSalary());
        employee.setDesignation(employees.getDesignation());

        repository.save(employee);
        return new Response(false,"successfully inserted");

    }

    @Override
    public List<Employees> getEmployees() {
        return repository.findAll();
    }

    @Override
    public Employees getaEmployee(Long id) {
        Optional<Employees> employeesOptional= repository.findById(id);

        if (!employeesOptional.isPresent())
            throw new InvalidRequestException(String.format("Employee with id : %s is not present",id));
       return employeesOptional.get();
    }
    @Override
    public List<Employees> getaEmployeebyname(String name) {

        return repository.findByNameAllIgnoreCase(name);
    }

    @Override
    public List<Employees> getaEmployeebydesignation(String designation) {
        return repository.findBydesignationAllIgnoreCase(designation);
    }

    @Override
    public List<Employees> getaEmployeebysalary() {
        return repository.findByOrderBySalaryDesc();
    }

    @Override
    public List<Employees> getEmployeebyMaxsalary() {
        return repository.findFirstByOrderBySalaryDesc();
    }

    @Override
    public List<Employees> getaEmployeeDistinct() {
        return repository.findByNameDistinct();
    }

    @Override
    public Response deleteEmployee(Long id) {

        if (!repository.existsById(id))
            throw new InvalidRequestException(String.format("Employee with id : %s is not present",id));
        repository.deleteById(id);
        return new Response(false,"Successfully Deleted");
    }

    @Override
    public Response deleteAllEmployee() {
        repository.deleteAll();
        return new Response(false,"Successfully Deleted all data");
    }



}
