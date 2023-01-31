package com.te.learnspringbootwithdatajpa;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.te.learnspringbootwithdatajpa.entity.Address;
import com.te.learnspringbootwithdatajpa.entity.Employee;
import com.te.learnspringbootwithdatajpa.entity.enums.AddressType;
import com.te.learnspringbootwithdatajpa.entity.enums.BloodGroup;
import com.te.learnspringbootwithdatajpa.entity.enums.Degree;
import com.te.learnspringbootwithdatajpa.entity.enums.Gender;
import com.te.learnspringbootwithdatajpa.entity.enums.Nationality;
import com.te.learnspringbootwithdatajpa.repository.EmployeeRepository;

@SpringBootApplication
public class LearnSpringBootWithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootWithJpaApplication.class, args);
	}
    @Bean
    
	public CommandLineRunner saveInDb(EmployeeRepository employeeRepository) {
		return args -> {
			Optional <Employee> findByEmpId = employeeRepository.findByEmployeeId("TY01");
			if(!findByEmpId.isPresent()) {
				Employee employee = new Employee();
				employee.setEmployeeId("TY01");
				employee.setEmployeeName("Name01");
				employee.setEmployeeEmail("abc@gmail.com");
				employee.setEmployeeDateOfBirth(LocalDate.now());
				employee.setEmployeeDateOfJoining(LocalDate.now());
				employee.setEmployeeDesignation("Developer");
				employee.setEmloyeeNationality(Nationality.INDIAN);
				employee.setEmployeeGender(Gender.MALE);
				employee.setEmployeeBloodGroup(BloodGroup.A_NEGATIVE);
				employee.setEmployeedegree(Degree.BE_CSE);
				Address address = new Address();
				address.setAddressType(AddressType.PERMANANT);
				address.setEmployeecity("Mumbai");
				
				employee.setAddresses(Arrays.asList(address));
				employeeRepository.save(employee);
			}
		};
	}
}
