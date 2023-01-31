package com.te.learnspringbootwithdatajpa.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.te.learnspringbootwithdatajpa.entity.dto.EmployeeDto;
import com.te.learnspringbootwithdatajpa.exception.EmployeeNotFoundException;
import com.te.learnspringbootwithdatajpa.response.GeneralResponse;
import com.te.learnspringbootwithdatajpa.service.EmployeeService;

@RestController
@RequestMapping(path = "/api")
class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	@GetMapping(path = "/employee")
	public ResponseEntity<GeneralResponse> getEmployees() {
		return ResponseEntity.ok()
				.body(new GeneralResponse(
						ServletUriComponentsBuilder.fromCurrentContextPath().path("/employees").toUriString(),
						HttpStatus.OK, null, "Provided!", "List of employee!"));
	}

	@GetMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> getEmployee(@PathVariable String employeeId) {
		EmployeeDto employeeDto = employeeService.findByEmployeeId(employeeId);
		if (employeeDto != null) {
			return ResponseEntity.ok()
					.body(new GeneralResponse(ServletUriComponentsBuilder.fromCurrentContextPath()
							.path("/employees/" + employeeId).toUriString(), HttpStatus.OK, null, "Data provided!",
							employeeDto));
		}
		throw new EmployeeNotFoundException(
				"Employee with given employee id " + employeeId + " is not present in database!");
	}

	@PostMapping(path = "/employee")
	public ResponseEntity<GeneralResponse> registerEmployee(@RequestBody EmployeeDto employeeDto) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/employee").toUriString());
		return ResponseEntity.created(uri).body(new GeneralResponse(
				ServletUriComponentsBuilder.fromCurrentContextPath().path("/employee").toUriString(),
				HttpStatus.CREATED, null, "Employee registered!", employeeService.registerEmployee(employeeDto)));
	}

	@PutMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> updateEmployee(@PathVariable String employeeId,
			@RequestBody EmployeeDto employeeDto) {
		return ResponseEntity.accepted()
				.body(new GeneralResponse(
						ServletUriComponentsBuilder.fromCurrentContextPath().path("/employee/" + employeeId)
								.toUriString(),
						HttpStatus.ACCEPTED, null, "Employee updated!",
						employeeService.updateEmployee(employeeId, employeeDto)));
	}
	@DeleteMapping(path = "/employee/{employeeId}")
	public ResponseEntity<GeneralResponse> deleteEmployee(@PathVariable String employeeId) {
		EmployeeDto employeeDto = employeeService.findByEmployeeId(employeeId);
		if (employeeDto != null) {
			return ResponseEntity.ok()
					.body(new GeneralResponse(ServletUriComponentsBuilder.fromCurrentContextPath()
							.path("/employees/" + employeeId).toUriString(), HttpStatus.OK, null, "Data provided!",
							employeeService.deleteEmployee(employeeId)));
		}
		throw new EmployeeNotFoundException(
				"Employee with given employee id " + employeeId + " is not present in database!");
	}
}
