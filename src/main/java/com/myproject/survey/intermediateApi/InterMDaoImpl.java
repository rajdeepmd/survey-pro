package com.myproject.survey.intermediateApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.myproject.survey.dto.IntermediateDTO;
import com.myproject.survey.model.MasterSurvey;
import com.myproject.survey.model.MasterSurveyQuestions;
import com.myproject.survey.model.MasterSurveyQuestionsOpts;
import com.myproject.survey.model.intermediate.EmployeeSurveyDetails;
import com.myproject.survey.model.intermediate.EmployeeSurveyOption;
import com.myproject.survey.model.intermediate.EmployeeSurveyQuestions;
import com.myproject.survey.model.setup.Employee;
import com.myproject.survey.util.BaseRepositorySurvey;

@Component
@Transactional
public class InterMDaoImpl extends BaseRepositorySurvey implements InterMDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(InterMDaoImpl.class);
	DateTimeFormatter DATE_FORMAT = new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd HH:mm:ss.S").toFormatter();

	@Override
	public boolean assignSurveyToEmp(IntermediateDTO req) {
		LOGGER.info("Inside InterMDaoImpl | assignSurveyToEmp ");
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session.createNativeQuery(
				"select e.id as empId,d.id from employee as e inner join departments as d on d.id=e.department_id where e.department_id=:Id")
				.setParameter("Id", req.getDepartmentId()).getResultList();
		System.out.println(getList);
		if (getList != null) {
			for (Object[] x : getList) {
				System.out.println("emp id " + x[0]);
				EmployeeSurveyDetails emp = new EmployeeSurveyDetails();
				if (x[0] != null) {
					emp.setEmployee(new Employee(Integer.parseInt(String.valueOf(x[0]))));
				}
				if (req.getSurveyId() > 0) {
					emp.setSurvey(new MasterSurvey(req.getSurveyId()));
				}
				if (req.getStatus() != null) {
					emp.setStatus(req.getStatus());
				}
				if (req.getComplitionDate() != null) {
					emp.setCompletionDate(req.getComplitionDate());
				}
				session.save(emp);
			}
		}
		@SuppressWarnings("unchecked")
		List<Object[]> getList2 = session
				.createNativeQuery("select sq.id as qId,sd.id as sdId,sq.question,sd.emp_id from emp_survey_details "
						+ "as sd inner join master_survey as ms on ms.id=sd.survey_id inner join survey_questions as sq "
						+ "on ms.id=sq.survey_id  inner join employee as e on e.id=sd.emp_id inner join departments\r\n"
						+ "as d on d.id=e.department_id where sd.survey_id=:sId and e.department_id=:dId")
				.setParameter("sId", req.getSurveyId()).setParameter("dId", req.getDepartmentId()).getResultList();
//		System.out.println(req.getSurveyId());
		if (getList2 != null) {
			System.out.println(getList2);
			System.out.println("for");
			for (Object[] y : getList2) {
				System.out.println("0:" + y[0]);
				EmployeeSurveyQuestions emp = new EmployeeSurveyQuestions();
				if (y[0] != null) {
					emp.setQuestionId(new MasterSurveyQuestions(Integer.parseInt(String.valueOf(y[0]))));
					System.out.println("2");
				}
				if (y[1] != null) {
					emp.setEmpSurveyId(new EmployeeSurveyDetails(Integer.parseInt(String.valueOf(y[1]))));
					System.out.println("1");
				}
				session.save(emp);
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean saveEmpSurveyOpt(IntermediateDTO req) {
		LOGGER.info("Inside InterMDaoImpl | saveEmpSurveyOpt ");
		Session session = getCurrentSession();
//		List<IntermediateDTO> list = new ArrayList<>();
		if (req.getQuestionAnswerlist() != null) {
			System.out.println("in if");
			List<IntermediateDTO> List = req.getQuestionAnswerlist();
			for (IntermediateDTO x : List) {
				EmployeeSurveyOption emp = new EmployeeSurveyOption();
				System.out.println(x.getQuestionId());
				System.out.println(x.getSurveyOptId());
				if (x.getQuestionId() > 0) {
					System.out.println("req.getEmpSurveyId" + req.getEmpSurveyId());
					List<Object[]> getEmpSurvetQueIdList = session.createNativeQuery(
							"select sq.id,sq.emp_survey_id,sq.question_id from emp_survey_questions as sq where "
									+ "sq.emp_survey_id =:EmpSurveyId and sq.question_id=:QueId")
							.setParameter("EmpSurveyId", req.getEmpSurveyId()).setParameter("QueId", x.getQuestionId())
							.getResultList();
					System.out.println("ESIlist" + getEmpSurvetQueIdList);
					for (Object[] y : getEmpSurvetQueIdList) {
						System.out.println("Id" + y[0] + "emp_su_id" + y[1]);
						emp.setEmpSurveyQueId(new EmployeeSurveyQuestions(Integer.parseInt(String.valueOf(y[0]))));
					}
				}
				if (x.getSurveyOptId() > 0) {
					emp.setOptionId(new MasterSurveyQuestionsOpts(x.getSurveyOptId()));
				}
				session.save(emp);
			}
			return true;
		}
		return false;
	}

	@Override
	public List<IntermediateDTO> optionRateByQue(IntermediateDTO req) {
		LOGGER.info("Inside InterMDaoImpl | optionRateByQue ");
		List<IntermediateDTO> qlist = new ArrayList<>();
		Session session = getCurrentSession();
		IntermediateDTO obj1 = new IntermediateDTO();
		obj1.setSurveyName(req.getSurveyName());
		double queCount;
		double queRepeated;
		double per;
		System.out.println("survey_Id: " + req.getSurveyId());
//		@SuppressWarnings("unchecked")
//		List<Object[]> queCountList = session.createNativeQuery(
//				"select count(*),sq.question_id from emp_survey_questions as sq inner join emp_survey_details "
//						+ "as sd on sd.id=sq.emp_survey_id where sd.survey_id=:sId group by sq.question_id order by sq.question_id")
//				.setParameter("sId", req.getSurveyId()).getResultList();
		@SuppressWarnings("unchecked")
		List<Object[]> getOptionList = session.createNativeQuery(
				"select count(so.option_id), sum(count(so.option_id)) over(partition by sq.question_id),sqo.option_name,so.option_id,sq.question_id,q.question,\r\n"
				+ "sd.survey_id from emp_survey_option as so inner join emp_survey_questions as sq \r\n"
				+ "on sq.id=so.emp_survey_que_id inner join emp_survey_details as sd on sd.id =\r\n"
				+ "sq.emp_survey_id inner join survey_questions_options as sqo on sqo.id=so.option_id \r\n"
				+ "inner join survey_questions as q on q.id=sqo.question_id \r\n"
				+ "where sd.survey_id=:SURVEYID group by so.option_id")
				.setParameter("SURVEYID", req.getSurveyId()).getResultList();
//		for (Object[] x : queCountList) {
//			queCount = Integer.parseInt(String.valueOf(x[0]));
//			System.out.println("tataol: " + queCount);

			if (getOptionList != null) {
				System.out.println("optlist :" + getOptionList);
				for (Object[] z : getOptionList) {
					IntermediateDTO obj = new IntermediateDTO();
					if (z[0] != null) {
						queRepeated = Integer.parseInt(String.valueOf(z[0]));
						queCount = Integer.parseInt(String.valueOf(z[1]));

						System.out.println("no of re: " + queRepeated);
						per = (queRepeated / queCount) * 100;
						System.out.println("% = " + per);
						String percentage = String.format("%.2f", per);
						obj.setPercentage(percentage + "%");
					}
					if (z[2] != null) {
						obj.setOption(String.valueOf(z[2]));
					}
					if (z[5] != null) {
						obj.setQuestion(String.valueOf(z[5]));
					}
					qlist.add(obj);
				}
				return qlist;
			}
		
		return null;
	}

	@Override
	public List<IntermediateDTO> getMaximumSurveySelect() {
		LOGGER.info("Inside InterMDaoImpl | getMaximumSurveySelect ");
		List<IntermediateDTO> qlist = new ArrayList<>();
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session.createNativeQuery(
				"select count(*) as m,ms.survey_title,es.survey_id,ms.created_date from emp_survey_details as es inner join master_survey as ms \r\n"
						+ "on ms.id=es.survey_id group by es.survey_id limit 1")
				.getResultList();
		if (getList != null) {
			for (Object[] x : getList) {
				IntermediateDTO obj = new IntermediateDTO();
				if (x[0] != null) {
					obj.setNumberOfResponses(Integer.parseInt(String.valueOf(x[0])));
					System.out.println("if 1");
				}
				if (x[1] != null) {
					obj.setSurveyName(String.valueOf(x[1]));
					System.out.println("if 2");
				}
				if (x[2] != null) {
					obj.setSurveyId(Integer.parseInt(String.valueOf(x[2])));
					System.out.println("if 3");
				}
				if (x[3] != null) {
					obj.setCreatedDate(LocalDateTime.parse(String.valueOf(x[3]), DATE_FORMAT));
				}
				qlist.add(obj);
			}
			return qlist;
		}
		return null;
	}

	@Override
	public List<IntermediateDTO> getNumberOfResponses() {
		LOGGER.info("Inside InterMDaoImpl | getNumberOfResponses ");
		List<IntermediateDTO> qlist = new ArrayList<>();
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session.createNativeQuery(
				"select count(*) as m,ms.survey_title,es.survey_id,ms.created_date from emp_survey_details as es inner join master_survey as ms \r\n"
						+ "on ms.id=es.survey_id group by es.survey_id")
				.getResultList();
		if (getList != null) {
			for (Object[] x : getList) {
				IntermediateDTO obj = new IntermediateDTO();
				if (x[0] != null) {
					obj.setNumberOfResponses(Integer.parseInt(String.valueOf(x[0])));
					System.out.println("if 1");
				}
				if (x[1] != null) {
					obj.setSurveyName(String.valueOf(x[1]));
					System.out.println("if 2");
				}
				if (x[2] != null) {
					obj.setSurveyId(Integer.parseInt(String.valueOf(x[2])));
					System.out.println("if 3");
				}
				if (x[3] != null) {
					obj.setCreatedDate(LocalDateTime.parse(String.valueOf(x[3]), DATE_FORMAT));
				}
				qlist.add(obj);
			}
			return qlist;
		}
		return null;
	}

	@Override
	public List<IntermediateDTO> getAllEmpInSurvey() {
		LOGGER.info("Inside InterMDaoImpl | getNumberOfResponses ");
		List<IntermediateDTO> qlist = new ArrayList<>();
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session.createNativeQuery(
				"select es.survey_id,e.f_name,e.l_name, ms.survey_title,es.created_date from emp_survey_details"
						+ " as es inner join master_survey as ms on ms.id=es.survey_id inner join employee as e on "
						+ "e.id=es.emp_id order by  ms.survey_title")
				.getResultList();
		if (getList != null) {
			for (Object[] x : getList) {
				IntermediateDTO obj = new IntermediateDTO();
				if (x[0] != null) {
					obj.setSurveyId(Integer.parseInt(String.valueOf(x[0])));
					System.out.println("if 1");
				}
				if (x[1] != null) {
					obj.setfName(String.valueOf(x[1]));
					System.out.println("if 2");
				}
				if (x[2] != null) {
					obj.setlName(String.valueOf(x[2]));
					System.out.println("if 2");
				}
				if (x[3] != null) {
					obj.setSurveyName(String.valueOf(x[3]));
					System.out.println("if 2");
				}
				if (x[4] != null) {
					obj.setCreatedDate(LocalDateTime.parse(String.valueOf(x[4]), DATE_FORMAT));
				}
				qlist.add(obj);
			}
			return qlist;
		}
		return null;
	}

	@Override
	public List<IntermediateDTO> getMaximumQuestionSelect() {
		LOGGER.info("Inside InterMDaoImpl | getMaximumQuestionSelect ");
		List<IntermediateDTO> qlist = new ArrayList<>();
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session.createNativeQuery(
				"select sq.question,count(*) as number_of_many_time,ms.survey_title,sq.created_date from emp_survey_questions as esq inner join\r\n"
						+ " survey_questions as sq on sq.id=esq.question_id inner join emp_survey_details as sd on sd.id=esq.emp_survey_id\r\n"
						+ " inner join master_survey as ms on ms.id=sd.survey_id group by esq.question_id having count(esq.question_id)>=\r\n"
						+ "	(select distinct count(esq.question_id) as c from emp_survey_questions as esq inner join\r\n"
						+ "	survey_questions as sq on sq.id=esq.question_id group by esq.question_id order by c desc limit 1)")
				.getResultList();
		if (getList != null) {
			for (Object[] x : getList) {
				LOGGER.info("Inside InterMDaoImpl | getMaximumQuestionSelect | for loop ");
				IntermediateDTO obj = new IntermediateDTO();
				if (x[0] != null) {
					obj.setQuestion(String.valueOf(x[0]));
				}
				if (x[1] != null) {
					obj.setQuestionCount(Integer.parseInt(String.valueOf(x[1])));
				}
				if (x[2] != null) {
					obj.setSurveyName(String.valueOf(x[2]));
				}
				if (x[3] != null) {
					obj.setQueCreatedDate(LocalDateTime.parse(String.valueOf(x[3]), DATE_FORMAT));
				}
				qlist.add(obj);
			}
			return qlist;
		}
		return null;
	}

	@Override
	public List<IntermediateDTO> getMaximumOptionSelect() {
		LOGGER.info("Inside InterMDaoImpl | getMaximumOptionSelect ");
		List<IntermediateDTO> qlist = new ArrayList<>();
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session.createNativeQuery(
				"select so.option_name,count(option_id) as how_many_time_selected ,sq.question from emp_survey_option as eo\r\n"
						+ "inner join survey_questions_options as so on so.id=eo.option_id\r\n"
						+ "inner join survey_questions as sq on sq.id=so.question_id\r\n"
						+ "group by eo.option_id having count(option_id)>=(select distinct count(option_id) as c "
						+ "from emp_survey_option group by option_id order by c desc limit 1)")
				.getResultList();
		if (getList != null) {
			for (Object[] x : getList) {
				IntermediateDTO obj = new IntermediateDTO();
				if (x[0] != null) {
					obj.setOption(String.valueOf(x[0]));
				}
				if (x[1] != null) {
					obj.setOptionCount(Integer.parseInt(String.valueOf(x[1])));
				}
				if (x[2] != null) {
					obj.setQuestion(String.valueOf(x[2]));
				}
				qlist.add(obj);
			}
			return qlist;
		}
		return null;
	}

	@Override
	public List<IntermediateDTO> getCompletionRate(int id) {
		LOGGER.info("Inside InterMDaoImpl | getCompletionRate ");
		List<IntermediateDTO> qlist = new ArrayList<>();
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session.createNativeQuery(
				"select distinct ed.survey_id,ms.survey_title,(select count(*) from emp_survey_details as ed where ed.status='COMPLETE' and ed.survey_id=:ID group by ed.survey_id)/\r\n"
						+ "(select count(*) from emp_survey_details as ed where ed.survey_id=:ID group by ed.survey_id )  * 100 as completion_Rate \r\n"
						+ "from emp_survey_details as ed inner join master_survey as ms on ms.id=ed.survey_id where ed.survey_id=:ID")
				.setParameter("ID", id).getResultList();
		if (getList != null) {
			for (Object[] x : getList) {
				IntermediateDTO obj = new IntermediateDTO();
				if (x[0] != null) {
					System.out.println("if 1");
					obj.setSurveyId(Integer.parseInt(String.valueOf(x[0])));
				}
				if (x[1] != null) {
					System.out.println("if 2");
					obj.setSurveyName(String.valueOf(x[1]));
				}
				if (x[2] != null) {
					System.out.println("if 3");
					obj.setCompletionRate(Double.parseDouble(String.valueOf(x[2])));
				}
				qlist.add(obj);
			}
			return qlist;
		}
		return null;
	}

	@Override
	public boolean updateStatus() {
		LOGGER.info("Inside InterMDaoImpl | updateStatus ");
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session
				.createNativeQuery("select so.option_id,so.emp_survey_que_id,sd.status,sd.id\r\n"
						+ "from emp_survey_option as so right join emp_survey_questions as sq on sq.id=so.emp_survey_que_id join\r\n"
						+ "emp_survey_details as sd on sd.id=sq.emp_survey_id where so.emp_survey_que_id is null group by sd.id order by sd.id")
				.getResultList();
		if (getList != null) {
			System.out.println("list"+getList);
			for (Object[] x : getList) {
				LOGGER.info("Inside InterMDaoImpl | updateStatus | for loop ");
				EmployeeSurveyDetails obj = session.get(EmployeeSurveyDetails.class,
						Integer.parseInt(String.valueOf(x[3])));
				System.out.println("id selected");
				if (Integer.parseInt(String.valueOf(x[3])) > 0) {
					obj.setStatus("INCOMPLETE");
				}
				session.update(obj);
			}
			return true;
		}
		return false;
	}

}
