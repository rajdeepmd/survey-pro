package com.myproject.survey.model.setup;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "employee")
@DynamicInsert
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "f_name", nullable = false)
	private String fName;

	@Column(name = "l_name")
	private String lName;

	@Column(name = "is_active", columnDefinition = "varchar(3) default 'N'")
	private String isActive;

	@Column(name = "middle_name")
	private String middelName;

	@Column(name = "contact_no", nullable = false)
	private String contactNo;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "dob")
	private LocalDate dob;

	@Column(name = "doj")
	private LocalDate doj;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Departments department;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

//	@OneToMany
//	(mappedBy = "employee",cascade = CascadeType.ALL)
//	private List<EmployeeSurveyDetails> emp;

	public int getId() {
		return id;
	}

	public Employee() {
		super();
	}

	public Employee(int id) {
		super();
		this.id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getMiddelName() {
		return middelName;
	}

	public void setMiddelName(String middelName) {
		this.middelName = middelName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
