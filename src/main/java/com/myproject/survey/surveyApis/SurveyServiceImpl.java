package com.myproject.survey.surveyApis;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myproject.survey.dto.SurveyDTO;
import com.myproject.survey.response.SurveyResponse;
import com.myproject.survey.util.SurveyConstants;

@Service
public class SurveyServiceImpl extends SurveyConstants implements SurveyService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SurveyServiceImpl.class);


	@Autowired
	SurveyDao daoi;

	@Override
	public SurveyResponse saveSurvey(SurveyDTO req) {
		LOGGER.info("Inside saveSurvey ");
		SurveyResponse responce = new SurveyResponse();

		try {
			boolean flag = daoi.saveSurvey(req);
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
	public SurveyResponse updateSurvey(SurveyDTO req) {
		LOGGER.info("Inside updateSurvey ");
		SurveyResponse responce = new SurveyResponse();

		try {
			boolean flag = daoi.updateSurvey(req);
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
	public SurveyResponse getSurvey() {
		LOGGER.info("Inside getSurvey ");
		SurveyResponse responce = new SurveyResponse();

		try {
			List<SurveyDTO> list = daoi.getSurvey();
			if (list != null && !list.isEmpty()) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
				responce.setList(list);

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
	public SurveyResponse deleteSurvey(SurveyDTO req) {
		LOGGER.info("Inside deleteSurvey ");
		SurveyResponse responce = new SurveyResponse();

		try {
			boolean flag = daoi.deleteSurvey(req);
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
	public SurveyResponse saveQuestion(SurveyDTO req) {
		LOGGER.info("Inside saveQuestion ");
		SurveyResponse responce = new SurveyResponse();

		try {
			boolean flag = daoi.saveQuestion(req);
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
	public SurveyResponse updateQuestion(SurveyDTO req) {
		LOGGER.info("Inside updateQuestion ");
		SurveyResponse responce = new SurveyResponse();

		try {
			boolean flag = daoi.updateQuestion(req);
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
	public SurveyResponse getQuestion() {
		LOGGER.info("Inside getQuestion ");
		SurveyResponse responce = new SurveyResponse();

		try {
			List<SurveyDTO> list = daoi.getQuestion();
			if (list != null && !list.isEmpty()) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
				responce.setList(list);

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
	public SurveyResponse deleteQuestion(SurveyDTO req) {
		LOGGER.info("Inside deleteQuestion ");
		SurveyResponse responce = new SurveyResponse();
		try {
			boolean flag = daoi.deleteQuestion(req);
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
	public SurveyResponse saveQuestionOption(SurveyDTO req) {
		LOGGER.info("Inside saveQuestionOption ");
		SurveyResponse responce = new SurveyResponse();
		try {
			boolean flag = daoi.saveQuestionOption(req);
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
	public SurveyResponse updateQuestionOption(SurveyDTO req) {
		LOGGER.info("Inside updateQuestionOption ");
		SurveyResponse responce = new SurveyResponse();
		try {
			boolean flag = daoi.updateQuestionOption(req);
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
	public SurveyResponse getQuestionOption() {
		LOGGER.info("Inside getQuestionOption ");
		SurveyResponse responce = new SurveyResponse();

		try {
			List<SurveyDTO> list = daoi.getQuestionOption();
			if (list != null && !list.isEmpty()) {
				responce.setStatus(SurveyConstants.STATUS_SUCCESS);
				responce.setStatusCode(SurveyConstants.STATUS_CODE_200);
				responce.setResult(SurveyConstants.RESULT_TRUE);
				responce.setList(list);

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
	public SurveyResponse deleteQuestionOption(SurveyDTO req) {
		LOGGER.info("Inside deleteQuestionOption ");
		SurveyResponse responce = new SurveyResponse();
		try {
			boolean flag = daoi.deleteQuestionOption(req);
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
