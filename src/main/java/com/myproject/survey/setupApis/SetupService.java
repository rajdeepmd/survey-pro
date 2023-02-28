package com.myproject.survey.setupApis;

import com.myproject.survey.dto.SetupDTO;
import com.myproject.survey.response.SetupResponse;

public interface SetupService {

	SetupResponse saveCompanyDetails(SetupDTO req);

	SetupResponse updateCompanyDetails(SetupDTO req);

	SetupResponse saveBranchDetails(SetupDTO req);

	SetupResponse updateBranchDetails(SetupDTO req);

	SetupResponse saveDepartmentDetails(SetupDTO req);

	SetupResponse updateDepartmentDetails(SetupDTO req);

	SetupResponse deleteDepartmentDetails(SetupDTO req);

	SetupResponse saveEmployeeDetails(SetupDTO req);

	SetupResponse updateEmployeeDetails(SetupDTO req);

	SetupResponse deleteEmployeeDetails(SetupDTO req);

	SetupResponse GetCompanyDetails();

	SetupResponse getDepartmentDetails();

	SetupResponse getBranchDetails();

	SetupResponse getEmployeeDetails();

}
