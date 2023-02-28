package com.myproject.survey.setupApis;

import java.util.List;

import com.myproject.survey.dto.SetupDTO;

public interface SetupDao {

	boolean saveCompanyDetails(SetupDTO req);

	boolean updateCompanyDetails(SetupDTO req);

	boolean saveBranchDetails(SetupDTO req);

	boolean updateBranchDetails(SetupDTO req);

	boolean saveDepartmentDetails(SetupDTO req);

	boolean updateDepartmentDetails(SetupDTO req);

	boolean deleteDepartmentDetails(SetupDTO req);

	boolean saveEmployeeDetails(SetupDTO req);

	boolean updateEmployeeDetails(SetupDTO req);

	boolean deleteEmployeeDetails(SetupDTO req);

	List<SetupDTO> GetCompanyDetails();

	List<SetupDTO> getDepartmentDetails();

	List<SetupDTO> getBranchDetails();

	List<SetupDTO> getEmployeeDetails();

}
