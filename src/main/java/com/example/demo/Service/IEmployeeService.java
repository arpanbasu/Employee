package com.example.demo.Service;

import com.example.demo.bean.Employees;
import com.example.demo.bean.Response;

import java.util.List;

public interface IEmployeeService {
    public Response createEmployees(Employees employees);
    public List<Employees> getEmployees();

    Employees getaEmployee(Long id) throws Exception;

    Response deleteEmployee(Long id);

    Response deleteAllEmployee();

    List<Employees> getaEmployeebyname(String name);
    List<Employees> getaEmployeebydesignation(String designation);

    List<Employees> getaEmployeebysalary();

    List<Employees> getEmployeebyMaxsalary();

   List<Employees> getaEmployeeDistinct();
}
