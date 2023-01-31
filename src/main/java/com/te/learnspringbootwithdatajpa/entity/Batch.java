package com.te.learnspringbootwithdatajpa.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.te.learnspringbootwithdatajpa.entity.enums.AddressType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee_batch_info")
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer batchId;
	private String batchName;
	private LocalDate batchStartDate;
	private LocalDate batchEndDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "inBatch")
	private List<Employee> employee;
}
