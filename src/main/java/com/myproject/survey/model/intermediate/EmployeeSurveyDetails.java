package com.myproject.survey.model.intermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.CreationTimestamp;
import com.myproject.survey.model.MasterSurvey;
import com.myproject.survey.model.setup.Employee;

@Entity
@Table(name = "emp_survey_details", uniqueConstraints = @UniqueConstraint(columnNames = { "emp_id", "survey_id" }))
public class EmployeeSurveyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@CreationTimestamp
	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "completion_date")
	private LocalDate completionDate;

	@Column(name = "status", columnDefinition = "varchar(15) default 'INCOMPLETE'")
	private String status;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "survey_id")
	private MasterSurvey survey;

	public EmployeeSurveyDetails() {
		super();
	}

	public int getId() {
		return id;
	}

	public EmployeeSurveyDetails(int id) {
		super();
		this.id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public MasterSurvey getSurvey() {
		return survey;
	}

	public void setSurvey(MasterSurvey survey) {
		this.survey = survey;
	}

}
