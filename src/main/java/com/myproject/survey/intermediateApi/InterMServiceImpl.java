package com.myproject.survey.intermediateApi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myproject.survey.dto.IntermediateDTO;
import com.myproject.survey.response.SetupResponse;
import com.myproject.survey.util.SurveyConstants;

@Service
public class InterMServiceImpl extends SurveyConstants implements InterMService {
	private static final Logger LOGGER = LoggerFactory.getLogger(InterMServiceImpl.class);

	@Autowired
	InterMDao imd;

	@Override
	public SetupResponse assignSurveyToEmp(IntermediateDTO req) {
		LOGGER.info("Inside InterMServiceImpl | assignSurveyToEmp ");
		SetupResponse responce = new SetupResponse();
		try {
			boolean flag = imd.assignSurveyToEmp(req);
			if (flag) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
			} else {
				responce.setStatus(SurveyConstants.STATUS_FAIL);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_400);
				responce.setResult(SurveyConstants.RESULT_FAIL);
				responce.setReason(SurveyConstants.STATUS_REASON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responce.setStatus(SurveyConstants.STATUS_FAIL);
			responce.setStatusCode(SurveyConstants.STATUS_CODE_500);
			responce.setResult(SurveyConstants.RESULT_FAIL);
			responce.setReason(SurveyConstants.STATUS_REASON);
		}
		return responce;
	}

	@Override
	public SetupResponse optionRateByQue(IntermediateDTO req) {
		LOGGER.info("Inside InterMServiceImpl | optionRateByQue ");
		SetupResponse responce = new SetupResponse();
		try {
			List<IntermediateDTO> qlist = imd.optionRateByQue(req);
			if (qlist != null) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
				responce.setQlist(qlist);
			} else {
				responce.setStatus(SurveyConstants.STATUS_FAIL);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_400);
				responce.setResult(SurveyConstants.RESULT_FAIL);
				responce.setReason(SurveyConstants.STATUS_REASON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responce.setStatus(SurveyConstants.STATUS_FAIL);
			responce.setStatusCode(SurveyConstants.STATUS_CODE_500);
			responce.setResult(SurveyConstants.RESULT_FAIL);
			responce.setReason(SurveyConstants.STATUS_REASON);
		}
		return responce;
	}

	@Override
	public SetupResponse saveEmpSurveyOpt(IntermediateDTO req) {
		LOGGER.info("Inside InterMServiceImpl | saveEmpSurveyOpt ");
		SetupResponse responce = new SetupResponse();
		try {
			boolean flag = imd.saveEmpSurveyOpt(req);
			if (flag) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
			} else {
				responce.setStatus(SurveyConstants.STATUS_FAIL);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_400);
				responce.setResult(SurveyConstants.RESULT_FAIL);
				responce.setReason(SurveyConstants.STATUS_REASON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responce.setStatus(SurveyConstants.STATUS_FAIL);
			responce.setStatusCode(SurveyConstants.STATUS_CODE_500);
			responce.setResult(SurveyConstants.RESULT_FAIL);
			responce.setReason(SurveyConstants.STATUS_REASON);
		}
		return responce;
	}

	@Override
	public SetupResponse getMaximumSurveySelect() {
		LOGGER.info("Inside InterMServiceImpl | getMaximumSurveySelect ");
		SetupResponse responce = new SetupResponse();
		try {
			List<IntermediateDTO> qlist = imd.getMaximumSurveySelect();
			if (qlist != null) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
				responce.setQlist(qlist);
			} else {
				responce.setStatus(SurveyConstants.STATUS_FAIL);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_400);
				responce.setResult(SurveyConstants.RESULT_FAIL);
				responce.setReason(SurveyConstants.STATUS_REASON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responce.setStatus(SurveyConstants.STATUS_FAIL);
			responce.setStatusCode(SurveyConstants.STATUS_CODE_500);
			responce.setResult(SurveyConstants.RESULT_FAIL);
			responce.setReason(SurveyConstants.STATUS_REASON);
		}
		return responce;
	}

	@Override
	public SetupResponse getNumberOfResponses() {
		LOGGER.info("Inside InterMServiceImpl | getNumberOfResponses ");
		SetupResponse responce = new SetupResponse();
		try {
			List<IntermediateDTO> qlist = imd.getNumberOfResponses();
			if (qlist != null) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
				responce.setQlist(qlist);
			} else {
				responce.setStatus(SurveyConstants.STATUS_FAIL);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_400);
				responce.setResult(SurveyConstants.RESULT_FAIL);
				responce.setReason(SurveyConstants.STATUS_REASON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responce.setStatus(SurveyConstants.STATUS_FAIL);
			responce.setStatusCode(SurveyConstants.STATUS_CODE_500);
			responce.setResult(SurveyConstants.RESULT_FAIL);
			responce.setReason(SurveyConstants.STATUS_REASON);
		}
		return responce;
	}
	
	@Override
	public SetupResponse getAllEmpInSurvey() {
		LOGGER.info("Inside InterMServiceImpl | getAllEmpInSurvey ");
		SetupResponse responce = new SetupResponse();
		try {
			List<IntermediateDTO> qlist = imd.getAllEmpInSurvey();
			if (qlist != null) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
				responce.setQlist(qlist);
			} else {
				responce.setStatus(SurveyConstants.STATUS_FAIL);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_400);
				responce.setResult(SurveyConstants.RESULT_FAIL);
				responce.setReason(SurveyConstants.STATUS_REASON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responce.setStatus(SurveyConstants.STATUS_FAIL);
			responce.setStatusCode(SurveyConstants.STATUS_CODE_500);
			responce.setResult(SurveyConstants.RESULT_FAIL);
			responce.setReason(SurveyConstants.STATUS_REASON);
		}
		return responce;
	}

	@Override
	public SetupResponse getMaximumQuestionSelect() {
		LOGGER.info("Inside InterMServiceImpl | getMaximumQuestionSelect ");
		SetupResponse responce = new SetupResponse();
		try {
			List<IntermediateDTO> qlist = imd.getMaximumQuestionSelect();
			if (qlist != null) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
				responce.setQlist(qlist);
			} else {
				responce.setStatus(SurveyConstants.STATUS_FAIL);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_400);
				responce.setResult(SurveyConstants.RESULT_FAIL);
				responce.setReason(SurveyConstants.STATUS_REASON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responce.setStatus(SurveyConstants.STATUS_FAIL);
			responce.setStatusCode(SurveyConstants.STATUS_CODE_500);
			responce.setResult(SurveyConstants.RESULT_FAIL);
			responce.setReason(SurveyConstants.STATUS_REASON);
		}
		return responce;
	}

	@Override
	public SetupResponse getMaximumOptionSelect() {
		LOGGER.info("Inside InterMServiceImpl | getMaximumOptionSelect ");
		SetupResponse responce = new SetupResponse();
		try {
			List<IntermediateDTO> qlist = imd.getMaximumOptionSelect();
			if (qlist != null) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
				responce.setQlist(qlist);
			} else {
				responce.setStatus(SurveyConstants.STATUS_FAIL);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_400);
				responce.setResult(SurveyConstants.RESULT_FAIL);
				responce.setReason(SurveyConstants.STATUS_REASON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responce.setStatus(SurveyConstants.STATUS_FAIL);
			responce.setStatusCode(SurveyConstants.STATUS_CODE_500);
			responce.setResult(SurveyConstants.RESULT_FAIL);
			responce.setReason(SurveyConstants.STATUS_REASON);
		}
		return responce;
	}

	@Override
	public SetupResponse getCompletionRate(int id) {
		LOGGER.info("Inside InterMServiceImpl | getCompletionRate ");
		SetupResponse responce = new SetupResponse();
		try {
			List<IntermediateDTO> qlist = imd.getCompletionRate(id);
			if (qlist != null) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
				responce.setQlist(qlist);
			} else {
				responce.setStatus(SurveyConstants.STATUS_FAIL);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_400);
				responce.setResult(SurveyConstants.RESULT_FAIL);
				responce.setReason(SurveyConstants.STATUS_REASON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responce.setStatus(SurveyConstants.STATUS_FAIL);
			responce.setStatusCode(SurveyConstants.STATUS_CODE_500);
			responce.setResult(SurveyConstants.RESULT_FAIL);
			responce.setReason(SurveyConstants.STATUS_REASON);
		}
		return responce;
	}

	@Override
	public SetupResponse updateStatus() {
		LOGGER.info("Inside InterMServiceImpl | getCompletionRate ");
		SetupResponse responce = new SetupResponse();
		try {
			boolean flag = imd.updateStatus();
			if (flag) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
				
			} else {
				responce.setStatus(SurveyConstants.STATUS_FAIL);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_400);
				responce.setResult(SurveyConstants.RESULT_FAIL);
				responce.setReason(SurveyConstants.STATUS_REASON);
			}
		} catch (Exception e) {
			e.printStackTrace();
			responce.setStatus(SurveyConstants.STATUS_FAIL);
			responce.setStatusCode(SurveyConstants.STATUS_CODE_500);
			responce.setResult(SurveyConstants.RESULT_FAIL);
			responce.setReason(SurveyConstants.STATUS_REASON);
		}
		return responce;
	}
}
