package com.myproject.survey.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class IntermediateDTO {

	private int employeeId;

	private int surveyId;

	private String status;

	private int empSurveyId;

	private int empSurveyQueId;

	private int surveyQueId;

	private int surveyOptId;

	private LocalDate complitionDate;

	private int count;

	private String question;

	private String surveyName;

	private String option;
	
	private String percentage;

	private double completionRate;

	private int numberOfResponses;

	private LocalDateTime createdDate;

	private LocalDateTime queCreatedDate;

	private String fName;

	private String lName;

	private int questionCount;

	private int optionCount;

	private int departmentId;
	
	private int questionId;
	
	private List<IntermediateDTO> questionAnswerlist;
	
	private List<IntermediateDTO> list;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEmpSurveyId() {
		return empSurveyId;
	}

	public void setEmpSurveyId(int empSurveyId) {
		this.empSurveyId = empSurveyId;
	}

	public int getEmpSurveyQueId() {
		return empSurveyQueId;
	}

	public void setEmpSurveyQueId(int empSurveyQueId) {
		this.empSurveyQueId = empSurveyQueId;
	}

	public int getSurveyOptId() {
		return surveyOptId;
	}

	public void setSurveyOptId(int surveyOptId) {
		this.surveyOptId = surveyOptId;
	}

	public LocalDate getComplitionDate() {
		return complitionDate;
	}

	public void setComplitionDate(LocalDate complitionDate) {
		this.complitionDate = complitionDate;
	}

	public int getSurveyQueId() {
		return surveyQueId;
	}

	public void setSurveyQueId(int surveyQueId) {
		this.surveyQueId = surveyQueId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public double getCompletionRate() {
		return completionRate;
	}

	public void setCompletionRate(double completionRate) {
		this.completionRate = completionRate;
	}

	public int getNumberOfResponses() {
		return numberOfResponses;
	}

	public void setNumberOfResponses(int numberOfResponses) {
		this.numberOfResponses = numberOfResponses;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getQueCreatedDate() {
		return queCreatedDate;
	}

	public void setQueCreatedDate(LocalDateTime queCreatedDate) {
		this.queCreatedDate = queCreatedDate;
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

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	public int getOptionCount() {
		return optionCount;
	}

	public void setOptionCount(int optionCount) {
		this.optionCount = optionCount;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public List<IntermediateDTO> getList() {
		return list;
	}

	public void setList(List<IntermediateDTO> list) {
		this.list = list;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public List<IntermediateDTO> getQuestionAnswerlist() {
		return questionAnswerlist;
	}

	public void setQuestionAnswerlist(List<IntermediateDTO> questionAnswerlist) {
		this.questionAnswerlist = questionAnswerlist;
	}

	
	
}
