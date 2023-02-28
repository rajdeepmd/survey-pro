package com.myproject.survey.surveyApis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myproject.survey.dto.SurveyDTO;
import com.myproject.survey.response.SurveyResponse;

@RestController
@RequestMapping(value = "survey")
@CrossOrigin
public class SurveyController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SurveyController.class);

	@Autowired
	SurveyService si;

	@PostMapping(value = "/saveSurvey")
	public SurveyResponse saveSurvey(@RequestBody SurveyDTO req) {
		LOGGER.info("Inside saveSurvey ");
		System.out.println("inside controller | saveSurvey");
		return si.saveSurvey(req);
	}

	@PutMapping(value = "/updateSurvey")
	public SurveyResponse updateSurvey(@RequestBody SurveyDTO req) {
		LOGGER.info("Inside updateSurvey ");
		System.out.println("inside controller | updateSurvey");
		return si.updateSurvey(req);

	}

	@GetMapping(value = "/getSurvey")
	public SurveyResponse getSurvey() {
		LOGGER.info("Inside getSurvey ");
		System.out.println("inside controller | getSurvey");
		return si.getSurvey();
	}

	@DeleteMapping(value = "deleteSurvey")
	public SurveyResponse deleteSurvey(@RequestBody SurveyDTO req) {
		LOGGER.info("Inside deleteSurvey ");
		System.out.println("inside controller | deleteSurvey");
		return si.deleteSurvey(req);
	}

	@PostMapping(value = "/saveQuestion")
	public SurveyResponse saveQuestion(@RequestBody SurveyDTO req) {
		LOGGER.info("Inside saveQuestion ");
		System.out.println("inside controller | saveQuestion");
		return si.saveQuestion(req);
	}

	@PutMapping(value = "/updateQuestion")
	public SurveyResponse updateQuestion(@RequestBody SurveyDTO req) {
		LOGGER.info("Inside updateQuestion ");
		System.out.println("inside controller | updateQuestion");
		return si.updateQuestion(req);
	}

	@GetMapping(value = "/getQuestion")
	public SurveyResponse getQuestion() {
		LOGGER.info("Inside getQuestion ");
		System.out.println("inside controller | getQuestion");
		return si.getQuestion();
	}

	@DeleteMapping(value = "deleteQuestion")
	public SurveyResponse deleteQuestion(@RequestBody SurveyDTO req) {
		LOGGER.info("Inside deleteQuestion ");
		System.out.println("inside controller | deleteQuestion");
		return si.deleteQuestion(req);
	}

	@PostMapping(value = "/saveQuestionOption")
	public SurveyResponse saveQuestionOption(@RequestBody SurveyDTO req) {
		LOGGER.info("Inside saveQuestionOption ");
		System.out.println("inside controller | saveQuestionOption");
		return si.saveQuestionOption(req);
	}

	@PutMapping(value = "/updateQuestionOption")
	public SurveyResponse updateQuestionOption(@RequestBody SurveyDTO req) {
		LOGGER.info("Inside updateQuestionOption ");
		System.out.println("inside controller | updateQuestionOption");
		return si.updateQuestionOption(req);
	}

	@GetMapping(value = "/getQuestionOption")
	public SurveyResponse getQuestionOption() {
		LOGGER.info("Inside getQuestionOption ");
		System.out.println("inside controller | getQuestionOption");
		return si.getQuestionOption();
	}

	@DeleteMapping(value = "deleteQuestionOption")
	public SurveyResponse deleteQuestionOption(@RequestBody SurveyDTO req) {
		LOGGER.info("Inside deleteQuestionOption ");
		System.out.println("inside controller | deleteQuestionOption");
		return si.deleteQuestionOption(req);
	}
	
}
