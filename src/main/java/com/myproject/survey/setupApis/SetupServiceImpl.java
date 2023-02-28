package com.myproject.survey.setupApis;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myproject.survey.dto.SetupDTO;
import com.myproject.survey.response.SetupResponse;
import com.myproject.survey.util.SurveyConstants;

@Service
public class SetupServiceImpl extends SurveyConstants implements SetupService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SetupServiceImpl.class);

	@Autowired
	SetupDao daoi;

	@Override
	public SetupResponse saveCompanyDetails(SetupDTO req) {
		LOGGER.info("Inside SetupServiceImpl | saveCompanyDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			boolean flag = daoi.saveCompanyDetails(req);
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
	public SetupResponse updateCompanyDetails(SetupDTO req) {
		LOGGER.info("Inside updateCompanyDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			boolean flag = daoi.updateCompanyDetails(req);
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
	public SetupResponse GetCompanyDetails() {
		LOGGER.info("Inside GetCompanyDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			List<SetupDTO> list = daoi.GetCompanyDetails();
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
	public SetupResponse saveBranchDetails(SetupDTO req) {
		LOGGER.info("Inside saveBranchDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			boolean flag = daoi.saveBranchDetails(req);
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
	public SetupResponse updateBranchDetails(SetupDTO req) {
		LOGGER.info("Inside updateBranchDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			boolean flag = daoi.updateBranchDetails(req);
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
	public SetupResponse getBranchDetails() {
		LOGGER.info("Inside getBranchDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			List<SetupDTO> list = daoi.getBranchDetails();
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
	public SetupResponse saveDepartmentDetails(SetupDTO req) {
		LOGGER.info("Inside saveDepartmentDetails ");

		SetupResponse responce = new SetupResponse();

		try {
			boolean flag = daoi.saveDepartmentDetails(req);
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
	public SetupResponse updateDepartmentDetails(SetupDTO req) {
		LOGGER.info("Inside updateDepartmentDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			boolean flag = daoi.updateDepartmentDetails(req);
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
	public SetupResponse getDepartmentDetails() {
		LOGGER.info("Inside getDepartmentDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			List<SetupDTO> list = daoi.getDepartmentDetails();
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
	public SetupResponse deleteDepartmentDetails(SetupDTO req) {
		LOGGER.info("Inside deleteDepartmentDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			boolean flag = daoi.deleteDepartmentDetails(req);
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
	public SetupResponse saveEmployeeDetails(SetupDTO req) {
		LOGGER.info("Inside saveEmployeeDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			boolean flag = daoi.saveEmployeeDetails(req);
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
	public SetupResponse updateEmployeeDetails(SetupDTO req) {
		LOGGER.info("Inside updateEmployeeDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			boolean flag = daoi.updateEmployeeDetails(req);
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
	public SetupResponse getEmployeeDetails() {
		LOGGER.info("Inside getEmployeeDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			List<SetupDTO> list = daoi.getEmployeeDetails();
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
	public SetupResponse deleteEmployeeDetails(SetupDTO req) {
		LOGGER.info("Inside deleteEmployeeDetails ");
		SetupResponse responce = new SetupResponse();
		try {
			boolean flag = daoi.deleteEmployeeDetails(req);
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
