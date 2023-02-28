package com.myproject.survey.surveyApis;

import com.myproject.survey.dto.SurveyDTO;
import com.myproject.survey.response.SurveyResponse;

public interface SurveyService {

	SurveyResponse saveSurvey(SurveyDTO req);

	SurveyResponse updateSurvey(SurveyDTO req);

	SurveyResponse deleteSurvey(SurveyDTO req);

	SurveyResponse saveQuestion(SurveyDTO req);

	SurveyResponse updateQuestion(SurveyDTO req);

	SurveyResponse deleteQuestion(SurveyDTO req);

	SurveyResponse saveQuestionOption(SurveyDTO req);

	SurveyResponse updateQuestionOption(SurveyDTO req);

	SurveyResponse deleteQuestionOption(SurveyDTO req);

	SurveyResponse getSurvey();

	SurveyResponse getQuestion();

	SurveyResponse getQuestionOption();

}
