package com.myproject.survey.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myproject.survey.dto.SurveyDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SurveyResponse {

	private int statusCode;

	private String status;

	private boolean result;

	private String reason;

	private List<SurveyDTO> list;

	public List<SurveyDTO> getList() {
		return list;
	}

	public void setList(List<SurveyDTO> list) {
		this.list = list;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
