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
import com.myproject.survey.model.MasterSurveyQuestions;

@Entity
@Table(name = "emp_survey_questions", uniqueConstraints = @UniqueConstraint(columnNames = { "emp_survey_id",
		"question_id" }))
public class EmployeeSurveyQuestions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@CreationTimestamp
	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@ManyToOne
	@JoinColumn(name = "emp_survey_id")
	private EmployeeSurveyDetails empSurveyId;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private MasterSurveyQuestions questionId;

	public EmployeeSurveyQuestions() {
		super();
	}

	public EmployeeSurveyQuestions(int id) {
		super();
		this.id = id;
	}

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

	public EmployeeSurveyDetails getEmpSurveyId() {
		return empSurveyId;
	}

	public void setEmpSurveyId(EmployeeSurveyDetails empSurveyId) {
		this.empSurveyId = empSurveyId;
	}

	public MasterSurveyQuestions getQuestionId() {
		return questionId;
	}

	public void setQuestionId(MasterSurveyQuestions questionId) {
		this.questionId = questionId;
	}

}
