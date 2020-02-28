package com.example.demo.Repository;

import com.example.demo.bean.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository

public interface EmployeeRepository extends JpaRepository<Employees,Long> {
    List<Employees> findByNameAllIgnoreCase (String name);
    List<Employees> findBydesignationAllIgnoreCase (String designation);
    List<Employees> findByOrderBySalaryDesc();


   @Query(value = "SELECT e.* FROM employee e inner join (select name,min(id) as id from employee group by name) as b on e.name = b.name and e.id = b.id",nativeQuery = true)
    List<Employees> findByNameDistinct();


    List<Employees> findFirstByOrderBySalaryDesc();






}
