package com.te.learnspringbootwithdatajpa.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_attendence_info")
public class EmployeeAttendence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendenceId;
	private LocalDate attendenceDate;
	private Boolean attendenceMorning;
	private Boolean attendenceNoon;
	
}
