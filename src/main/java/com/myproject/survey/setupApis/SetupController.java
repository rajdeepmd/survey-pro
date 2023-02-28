package com.myproject.survey.setupApis;

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
import com.myproject.survey.dto.SetupDTO;
import com.myproject.survey.response.SetupResponse;

@RestController
@RequestMapping(value = "setup")
@CrossOrigin
public class SetupController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SetupController.class);

	@Autowired
	SetupService ssi;

	@PostMapping(value = "/saveCompanyDetails")
	public SetupResponse saveCompanyDetails(@RequestBody SetupDTO req) {
		LOGGER.info("Inside saveCompanyDetails ");
		System.out.println("inside controller | saveCompanyDetails");
		return ssi.saveCompanyDetails(req);
	}

	@PutMapping(value = "/updateCompanyDetails")
	public SetupResponse updateCompanyDetails(@RequestBody SetupDTO req) {
		LOGGER.info("Inside updateCompanyDetails ");
		System.out.println("inside controller | updateCompanyDetails");
		return ssi.updateCompanyDetails(req);
	}

	@GetMapping(value = "/GetCompanyDetails")
	public SetupResponse GetCompanyDetails() {
		LOGGER.info("Inside GetCompanyDetails ");
		System.out.println("inside controller | GetCompanyDetails");
		return ssi.GetCompanyDetails();
	}

	@PostMapping(value = "/saveBranchDetails")
	public SetupResponse saveBranchDetails(@RequestBody SetupDTO req) {
		LOGGER.info("Inside saveBranchDetails ");
		System.out.println("inside controller | saveBranchDetails");
		return ssi.saveBranchDetails(req);
	}

	@PutMapping(value = "/updateBranchDetails")
	public SetupResponse updateBranchDetails(@RequestBody SetupDTO req) {
		LOGGER.info("Inside updateBranchDetails ");
		System.out.println("inside controller | updateBranchDetails");
		return ssi.updateBranchDetails(req);
	}

	@GetMapping(value = "/getBranchDetails")
	public SetupResponse getBranchDetails() {
		LOGGER.info("Inside getBranchDetails ");
		System.out.println("inside controller | getBranchDetails");
		return ssi.getBranchDetails();
	}

	@PostMapping(value = "/saveDepartmentDetails")
	public SetupResponse saveDepartmentDetails(@RequestBody SetupDTO req) {
		LOGGER.info("Inside saveDepartmentDetails ");
		System.out.println("inside controller | saveDepartmentDetails");
		return ssi.saveDepartmentDetails(req);
	}

	@PutMapping(value = "/updateDepartmentDetails")
	public SetupResponse updateDepartmentDetails(@RequestBody SetupDTO req) {
		LOGGER.info("Inside updateDepartmentDetails ");
		System.out.println("inside controller | updateDepartmentDetails");
		return ssi.updateDepartmentDetails(req);
	}

	@GetMapping(value = "/getDepartmentDetails")
	public SetupResponse getDepartmentDetails() {
		LOGGER.info("Inside getDepartmentDetails ");
		System.out.println("inside controller | getDepartmentDetails");
		return ssi.getDepartmentDetails();
	}

	@DeleteMapping(value = "deleteDepartmentDetails")
	public SetupResponse deleteDepartmentDetails(@RequestBody SetupDTO req) {
		LOGGER.info("Inside deleteDepartmentDetails ");
		System.out.println("inside controller | deleteDepartmentDetails");
		return ssi.deleteDepartmentDetails(req);
	}

	@PostMapping(value = "/saveEmployeeDetails")
	public SetupResponse saveEmployeeDetails(@RequestBody SetupDTO req) {
		LOGGER.info("Inside saveEmployeeDetails ");
		System.out.println("inside controller | saveEmployeeDetails");
		return ssi.saveEmployeeDetails(req);
	}

	@PutMapping(value = "/updateEmployeeDetails")
	public SetupResponse updateEmployeeDetails(@RequestBody SetupDTO req) {
		LOGGER.info("Inside updateEmployeeDetails ");
		System.out.println("inside controller | updateEmployeeDetails");
		return ssi.updateEmployeeDetails(req);
	}

	@GetMapping(value = "/getEmployeeDetails")
	public SetupResponse getEmployeeDetails() {
		LOGGER.info("Inside getEmployeeDetails ");
		System.out.println("inside controller | getEmployeeDetails");
		return ssi.getEmployeeDetails();
	}

	@DeleteMapping(value = "deleteEmployeeDetails")
	public SetupResponse deleteEmployeeDetails(@RequestBody SetupDTO req) {
		LOGGER.info("Inside deleteEmployeeDetails ");
		System.out.println("inside controller | deleteEmployeeDetails");
		return ssi.deleteEmployeeDetails(req);
	}

}
