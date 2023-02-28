package com.myproject.survey.intermediateApi;

import com.myproject.survey.dto.IntermediateDTO;
import com.myproject.survey.dto.SetupDTO;
import com.myproject.survey.response.SetupResponse;

public interface InterMService {

	SetupResponse assignSurveyToEmp(IntermediateDTO req);

	SetupResponse optionRateByQue(IntermediateDTO req);

	SetupResponse saveEmpSurveyOpt(IntermediateDTO req);

	SetupResponse getMaximumSurveySelect();

	SetupResponse getNumberOfResponses();

	SetupResponse getMaximumQuestionSelect();

	SetupResponse getMaximumOptionSelect();

	SetupResponse getCompletionRate(int id);

	SetupResponse getAllEmpInSurvey();

	SetupResponse updateStatus();


}
