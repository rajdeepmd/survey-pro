package com.myproject.survey.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myproject.survey.dto.IntermediateDTO;
import com.myproject.survey.dto.SetupDTO;
@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class SetupResponse {

	private int statusCode;

	private String status;

	private boolean result;

	private String reason;

	private List<SetupDTO> list;

	private List<IntermediateDTO> qlist;

	public List<SetupDTO> getList() {
		return list;
	}

	public void setList(List<SetupDTO> list) {
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

	public List<IntermediateDTO> getQlist() {
		return qlist;
	}

	public void setQlist(List<IntermediateDTO> qlist) {
		this.qlist = qlist;
	}

}
