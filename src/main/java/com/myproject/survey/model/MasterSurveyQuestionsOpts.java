package com.myproject.survey.model;

import java.sql.Timestamp;

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
@Table(name = "survey_questions_options")
public class MasterSurveyQuestionsOpts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "option_name")
	private String optionName;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private MasterSurveyQuestions questionId;

	@CreationTimestamp
	@Column(name = "created_date", updatable = true)
	private Timestamp createdDate;

	@UpdateTimestamp
	@Column(name = "updated_date", updatable = true, nullable = true)
	private Timestamp updatedDate;

	@Column(name = "created_by")
	private int createdBy;

	@Column(name = "updated_by", nullable = true)
	private int updatedBy;

	public MasterSurveyQuestionsOpts() {
		super();
	}

	public MasterSurveyQuestionsOpts(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
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

	public MasterSurveyQuestions getQuestionId() {
		return questionId;
	}

	public void setQuestionId(MasterSurveyQuestions questionId) {
		this.questionId = questionId;
	}

}
