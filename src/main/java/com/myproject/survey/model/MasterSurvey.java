package com.myproject.survey.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "master_survey")
public class MasterSurvey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "survey_title", nullable = false)
	private String surveyTitle;

	@CreationTimestamp
	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@Column(name = "updated_date", updatable = true, nullable = true, columnDefinition = "timestamp default NULL")
	private LocalDateTime updatedDate;

	@Column(name = "created_by")
	private int CreatedBy;

	@Column(name = "updated_by", columnDefinition = "int default null", nullable = true)
	private int updatedBy;

	@Column(name = "depatment_id")
	private int departmenyId;

	@Column(name = "branch_id")
	private int branchId;

	public MasterSurvey(int id) {
		super();
		this.id = id;
	}

	public MasterSurvey() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
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
		return CreatedBy;
	}

	public void setCreatedBy(int createdBy) {
		CreatedBy = createdBy;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getDepartmenyId() {
		return departmenyId;
	}

	public void setDepartmenyId(int departmenyId) {
		this.departmenyId = departmenyId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

}
