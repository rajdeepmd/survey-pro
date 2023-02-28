package com.myproject.survey.setupApis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.myproject.survey.dto.SetupDTO;
import com.myproject.survey.model.setup.Branch;
import com.myproject.survey.model.setup.Company;
import com.myproject.survey.model.setup.Departments;
import com.myproject.survey.model.setup.Employee;
import com.myproject.survey.util.BaseRepositorySurvey;

@Component
@Transactional
public class SetupDaoImpl extends BaseRepositorySurvey implements SetupDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(SetupDaoImpl.class);

	@Override
	public boolean saveCompanyDetails(SetupDTO req) {
		LOGGER.info("Inside saveCompanyDetails ");
		if (req.getCompanyName() != null) {
			Session session = getCurrentSession();
			Company com = new Company();
			com.setCompanyName(req.getCompanyName());
			session.save(com);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCompanyDetails(SetupDTO req) {
		LOGGER.info("Inside updateCompanyDetails ");
		if (req.getCompanyName() != null) {
			Session session = getCurrentSession();
			Company obj = session.get(Company.class, req.getId());
			obj.setCompanyName(req.getCompanyName());
			session.update(obj);
			return true;
		}
		return false;
	}

	@Override
	public List<SetupDTO> GetCompanyDetails() {
		LOGGER.info("Inside GetCompanyDetails ");
		List<SetupDTO> list = new ArrayList<>();
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session.createNativeQuery("select id,company_name from company").getResultList();
		for (Object[] x : getList) {
			LOGGER.info("Inside GetCompanyDetails | for");
			SetupDTO obj = new SetupDTO();
			if (x[0] != null) {
				obj.setId(Integer.parseInt(String.valueOf(x[0])));
			}
			if (x[1] != null) {
				obj.setCompanyName(String.valueOf(x[1]));
			}
			list.add(obj);
		}
		return list;
	}

	@Override
	public boolean saveBranchDetails(SetupDTO req) {
		LOGGER.info("Inside saveBranchDetails ");
		if (req.getCompanyId() > 0) {
			Session session = getCurrentSession();
			Branch obj = new Branch();
			obj.setBranchName(req.getBranchName());
			obj.setCom(new Company(req.getCompanyId()));
			session.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBranchDetails(SetupDTO req) {
		LOGGER.info("Inside updateBranchDetails ");
		Session session = getCurrentSession();
		Branch obj = session.get(Branch.class, req.getId());
		if (req.getBranchName() != null) {
			obj.setBranchName(req.getBranchName());
		}
		if (req.getCompanyId() > 0) {
			obj.setCom(new Company(req.getCompanyId()));
		}
		session.update(obj);
		return true;
	}

	@Override
	public List<SetupDTO> getBranchDetails() {
		LOGGER.info("Inside getBranchDetails ");
		List<SetupDTO> list = new ArrayList<>();
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session.createNativeQuery("select id, brach_name,com_id from branch").getResultList();
		if (getList != null) {
			for (Object[] x : getList) {
				LOGGER.info("Inside getBranchDetails | for");
				SetupDTO obj = new SetupDTO();
				if (x[0] != null) {
					obj.setId(Integer.parseInt(String.valueOf(x[0])));
				}
				if (x[1] != null) {
					obj.setBranchName(String.valueOf(x[1]));
				}
				if (x[2] != null) {
					obj.setCompanyId(Integer.parseInt(String.valueOf(x[2])));
				}
				list.add(obj);
			}
			return list;
		}
		return null;
	}

	@Override
	public boolean saveDepartmentDetails(SetupDTO req) {
		LOGGER.info("Inside saveDepartmentDetails ");
		Session session = getCurrentSession();
		Departments dep = new Departments();
		dep.setDepartmentName(req.getDepartmentName());
		if (req.getCompanyId() > 0) {
			dep.setCompany(new Company(req.getCompanyId()));
		}
		if (req.getBranchId() > 0) {
			dep.setBranch(new Branch(req.getBranchId()));
		}
		session.save(dep);
		return true;
	}

	@Override
	public boolean updateDepartmentDetails(SetupDTO req) {
		LOGGER.info("Inside updateDepartmentDetails ");
		Session session = getCurrentSession();
		Departments obj = session.get(Departments.class, req.getId());
		if (req.getDepartmentName() != null) {
			obj.setDepartmentName(req.getDepartmentName());
		}
		if (req.getCompanyId() > 0) {
			obj.setCompany(new Company(req.getCompanyId()));
		}
		if (req.getBranchId() > 0) {
			obj.setBranch(new Branch(req.getBranchId()));
		}
		session.update(obj);
		return true;
	}

	@Override
	public List<SetupDTO> getDepartmentDetails() {
		LOGGER.info("Inside getDepartmentDetails ");
		List<SetupDTO> list = new ArrayList<>();
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session
				.createNativeQuery("select id, department_name,branch_id,com_id from departments").getResultList();
		if (getList != null) {
			for (Object[] x : getList) {
				LOGGER.info("Inside getDepartmentDetails | for");
				SetupDTO obj = new SetupDTO();
				if (x[0] != null) {
					obj.setId(Integer.parseInt(String.valueOf(x[0])));
				}
				if (x[1] != null) {
					obj.setDepartmentName(String.valueOf(x[1]));
				}
				if (x[2] != null) {
					obj.setBranchId(Integer.parseInt(String.valueOf(x[2])));
				}
				if (x[3] != null) {
					obj.setCompanyId(Integer.parseInt(String.valueOf(x[3])));
				}
				list.add(obj);
			}
			return list;
		}
		return null;
	}

	@Override
	public boolean deleteDepartmentDetails(SetupDTO req) {
		LOGGER.info("Inside deleteDepartmentDetails ");
		if (req.getId() > 0) {
			Session session = getCurrentSession();
			session.createNativeQuery("delete e,d from employee as e join departments as d "
					+ "on d.id=e.department_id where department_id=:departmentID")
					.setParameter("departmentID", req.getId()).executeUpdate();

			session.createNativeQuery("delete from departments where id=:ID").setParameter("ID", req.getId())
					.executeUpdate();
			return true;
		}
		return false;
	}

	@Override
	public boolean saveEmployeeDetails(SetupDTO req) {
		LOGGER.info("Inside saveEmployeeDetails ");

		Session session = getCurrentSession();
		Employee emp = new Employee();
		if (req.getfName() != null) {
			emp.setfName(req.getfName());
		}
		if (req.getlName() != null) {
			emp.setlName(req.getlName());
		}
		if (req.getIsActive() != null) {
			emp.setIsActive(req.getIsActive());
		}
		if (req.getJoiningDate() != null) {
			emp.setDoj(req.getJoiningDate());
		}
		if (req.getdOB() != null) {
			emp.setDob(req.getdOB());
		}
		if (req.getEmailId() != null) {
			emp.setEmailId(req.getEmailId());
		}
		if (req.getContactNo() != null) {
			emp.setContactNo(req.getContactNo());
		}
		if (req.getMiddleName() != null) {
			emp.setMiddelName(req.getMiddleName());
		}
		if (req.getDepartmentId() > 0) {
			emp.setDepartment(new Departments(req.getDepartmentId()));
		}
		if (req.getCompanyId() > 0) {
			emp.setCompany(new Company(req.getCompanyId()));
		}
		if (req.getBranchId() > 0) {
			emp.setBranch(new Branch(req.getBranchId()));
		}
		session.save(emp);
		return true;
	}

	@Override
	public boolean updateEmployeeDetails(SetupDTO req) {
		LOGGER.info("Inside updateEmployeeDetails ");
		Session session = getCurrentSession();
		Employee obj = session.get(Employee.class, req.getId());
		if (req.getfName() != null) {
			obj.setfName(req.getfName());
		}
		if (req.getlName() != null) {
			obj.setlName(req.getlName());
		}
		if (req.getMiddleName() != null) {
			obj.setMiddelName(req.getMiddleName());
		}
		if (req.getContactNo() != null) {
			obj.setContactNo(req.getContactNo());
		}
		if (req.getEmailId() != null) {
			obj.setEmailId(req.getEmailId());
		}
		if (req.getIsActive() != null) {
			obj.setIsActive(req.getIsActive());
		}
		if (req.getJoiningDate() != null) {
			obj.setDoj(req.getJoiningDate());
		}
		if (req.getdOB() != null) {
			obj.setDob(req.getdOB());
		}
		if (req.getDepartmentId() > 0) {
			obj.setDepartment(new Departments(req.getDepartmentId()));
		}
		if (req.getCompanyId() > 0) {
			obj.setCompany(new Company(req.getCompanyId()));
		}
		if (req.getBranchId() > 0) {
			obj.setBranch(new Branch(req.getBranchId()));
		}
		session.update(obj);
		return true;
	}

	@Override
	public List<SetupDTO> getEmployeeDetails() {
		LOGGER.info("Inside getEmployeeDetails ");
		List<SetupDTO> list = new ArrayList<>();
		Session session = getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Object[]> getList = session
				.createNativeQuery("select id, contact_no, dob, doj, email_id, f_name, is_active, "
						+ "l_name, middle_name, branch_id, company_id, department_id from employee")
				.getResultList();
		if (getList != null) {
			for (Object[] x : getList) {
				LOGGER.info("Inside getEmployeeDetails | for");
				SetupDTO obj = new SetupDTO();
				if (x[0] != null) {
					obj.setId(Integer.parseInt(String.valueOf(x[0])));
				}
				if (x[1] != null) {
					obj.setContactNo(String.valueOf(x[1]));
				}
				if (x[2] != null) {
					obj.setdOB(LocalDate.parse(String.valueOf(x[2])));
				}
				if (x[3] != null) {
					obj.setJoiningDate(LocalDate.parse(String.valueOf(x[3])));
				}
				if (x[4] != null) {
					obj.setEmailId(String.valueOf(x[4]));
				}
				if (x[5] != null) {
					obj.setfName(String.valueOf(x[5]));
				}
				if (x[6] != null) {
					obj.setIsActive(String.valueOf(x[6]));
				}
				if (x[7] != null) {
					obj.setlName(String.valueOf(x[7]));
				}
				if (x[8] != null) {
					obj.setMiddleName(String.valueOf(x[8]));
				}
				if (x[9] != null) {
					obj.setBranchId(Integer.parseInt(String.valueOf(x[9])));
				}
				if (x[10] != null) {
					obj.setCompanyId(Integer.parseInt(String.valueOf(x[10])));
				}
				if (x[11] != null) {
					obj.setDepartmentId(Integer.parseInt(String.valueOf(x[11])));
				}
				list.add(obj);
			}
			return list;
		}
		return null;
	}

	@Override
	public boolean deleteEmployeeDetails(SetupDTO req) {
		LOGGER.info("Inside deleteEmployeeDetails ");
		if (req.getId() > 0) {
			Session session = getCurrentSession();
			Employee obj = session.load(Employee.class, req.getId());
			session.delete(obj);
			return true;
		}
		return false;
	}

}
