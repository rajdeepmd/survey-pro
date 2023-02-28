package com.myproject.survey.intermediateApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myproject.survey.dto.IntermediateDTO;
import com.myproject.survey.response.SetupResponse;

@RestController
@RequestMapping(value = "intermediate")
@CrossOrigin
public class InterMController {

	private static final Logger LOGGER = LoggerFactory.getLogger(InterMController.class);

	@Autowired
	InterMService ims;

	@PostMapping(value = "assignSurveyToEmp")
	public SetupResponse assignSurveyToEmp(@RequestBody IntermediateDTO req) {
		LOGGER.info("Inside InterMController | assignSurveyToEmp ");
		return ims.assignSurveyToEmp(req);
	}

	@PostMapping(value = "optionRateByQue")
	public SetupResponse optionRateByQue(@RequestBody IntermediateDTO req) {
		LOGGER.info("Inside InterMController | optionRateByQue ");
		return ims.optionRateByQue(req);
	}

	@PostMapping(value = "saveEmpSurveyOpt")
	public SetupResponse saveEmpSurveyOpt(@RequestBody IntermediateDTO req) {
		LOGGER.info("Inside InterMController | saveEmpSurveyOpt ");
		return ims.saveEmpSurveyOpt(req);
	}

	@GetMapping(value = "getMaximumSurveySelect")
	public SetupResponse getMaximumSurveySelect() {
		LOGGER.info("Inside InterMController | getMaximumSurveySelect ");
		return ims.getMaximumSurveySelect();
	}
	
	@GetMapping(value = "getNumberOfResponses")
	public SetupResponse getNumberOfResponses() {
		LOGGER.info("Inside InterMController | getNumberOfResponses ");
		return ims.getNumberOfResponses();
	}
	
	@GetMapping(value = "getAllEmpInSurvey")
	public SetupResponse getAllEmpInSurvey() {
		LOGGER.info("Inside InterMController | getAllEmpInSurvey ");
		return ims.getAllEmpInSurvey();
	}

	@GetMapping(value = "getMaximumQuestionSelect")
	public SetupResponse getMaximumQuestionSelect() {
		LOGGER.info("Inside InterMController | getMaximumQuestionSelect ");
		return ims.getMaximumQuestionSelect();
	}

	@GetMapping(value = "getMaximumOptionSelect")
	public SetupResponse getMaximumOptionSelect() {
		LOGGER.info("Inside InterMController | getMaximumOptionSelect ");
		return ims.getMaximumOptionSelect();
	}

	@GetMapping(value = "getCompletionRate/{id}")
	public SetupResponse getCompletionRate(@PathVariable int id) {
		LOGGER.info("Inside InterMController | getCompletionRate ");
		return ims.getCompletionRate(id);
	}
	
	@PutMapping(value = "updateStatus")
	public SetupResponse updateStatus() {
		LOGGER.info("Inside InterMController | updateStatus ");
		return ims.updateStatus();
	}


}
