package com.myproject.survey.surveyApis;

import java.util.List;

import com.myproject.survey.dto.SurveyDTO;

public interface SurveyDao {

	boolean saveSurvey(SurveyDTO req);

	boolean updateSurvey(SurveyDTO req);

	boolean deleteSurvey(SurveyDTO req);

	boolean saveQuestion(SurveyDTO req);

	boolean updateQuestion(SurveyDTO req);

	boolean deleteQuestion(SurveyDTO req);

	boolean saveQuestionOption(SurveyDTO req);

	boolean updateQuestionOption(SurveyDTO req);

	boolean deleteQuestionOption(SurveyDTO req);

	List<SurveyDTO> getSurvey();

	List<SurveyDTO> getQuestion();

	List<SurveyDTO> getQuestionOption();

}
