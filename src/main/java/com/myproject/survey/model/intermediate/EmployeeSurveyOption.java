package com.myproject.survey.model.intermediate;

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

import com.myproject.survey.model.MasterSurveyQuestionsOpts;

@Entity
@Table(name = "emp_survey_option", uniqueConstraints = @UniqueConstraint(columnNames = { "emp_survey_que_id",
		"option_id" }))
public class EmployeeSurveyOption {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@CreationTimestamp
	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@ManyToOne
	@JoinColumn(name = "emp_survey_que_id")
	private EmployeeSurveyQuestions empSurveyQueId;

	@ManyToOne
	@JoinColumn(name = "option_id")
	private MasterSurveyQuestionsOpts optionId;

	public int getId() {
		return id;
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

	public EmployeeSurveyQuestions getEmpSurveyQueId() {
		return empSurveyQueId;
	}

	public void setEmpSurveyQueId(EmployeeSurveyQuestions empSurveyQueId) {
		this.empSurveyQueId = empSurveyQueId;
	}

	public MasterSurveyQuestionsOpts getOptionId() {
		return optionId;
	}

	public void setOptionId(MasterSurveyQuestionsOpts optionId) {
		this.optionId = optionId;
	}

}
