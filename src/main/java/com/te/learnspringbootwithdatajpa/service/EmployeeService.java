package com.te.learnspringbootwithdatajpa.service;

import java.util.List;

import com.te.learnspringbootwithdatajpa.entity.dto.EmployeeDto;

public interface EmployeeService {
	
     EmployeeDto findByEmployeeId(String employeeId);
     
     List<EmployeeDto> findAllEmployees();
     
     EmployeeDto registerEmployee(EmployeeDto employeeDto);
     
     EmployeeDto updateEmployee(String employeeId,EmployeeDto employeeDto);
     
     boolean deleteEmployee(String employeeId);
     
     
     
     
}