package com.ktb.model.onetomany;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;
	
	@Column(name="DEPT_NAME")
	private String departmentName;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="department_id")
	private List<Employee> employees;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
