package com.myproject.survey.intermediateApi;

import java.util.List;

import com.myproject.survey.dto.IntermediateDTO;

public interface InterMDao {

	boolean assignSurveyToEmp(IntermediateDTO req);

	List<IntermediateDTO> optionRateByQue(IntermediateDTO req);

	boolean saveEmpSurveyOpt(IntermediateDTO req);

	List<IntermediateDTO> getMaximumSurveySelect();

	List<IntermediateDTO> getNumberOfResponses();

	List<IntermediateDTO> getMaximumQuestionSelect();

	List<IntermediateDTO> getMaximumOptionSelect();

	List<IntermediateDTO> getCompletionRate(int id);

	List<IntermediateDTO> getAllEmpInSurvey();

	boolean updateStatus();


}
