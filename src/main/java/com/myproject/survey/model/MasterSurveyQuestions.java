package com.myproject.survey.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "survey_questions")
public class MasterSurveyQuestions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "question", length = 1000, nullable = false)
	private String quetion;

	@CreationTimestamp
	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@Column(name = "updated_date", updatable = true, columnDefinition = "timestamp default null")
	private LocalDateTime updatedDate;

	@ManyToOne
	@JoinColumn(name = "survey_id")
	private MasterSurvey surveyId;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "updated_by", columnDefinition = "int default null")
	private int updatedBy;

	public MasterSurveyQuestions() {
		super();
	}

	public MasterSurveyQuestions(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuetion() {
		return quetion;
	}

	public void setQuetion(String quetion) {
		this.quetion = quetion;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public MasterSurvey getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(MasterSurvey surveyId) {
		this.surveyId = surveyId;
	}

}
