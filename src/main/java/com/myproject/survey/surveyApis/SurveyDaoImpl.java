package com.myproject.survey.surveyApis;

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
import com.myproject.survey.dto.SurveyDTO;
import com.myproject.survey.model.MasterSurvey;
import com.myproject.survey.model.MasterSurveyQuestions;
import com.myproject.survey.model.MasterSurveyQuestionsOpts;
import com.myproject.survey.util.BaseRepositorySurvey;

@Component
@Transactional
public class SurveyDaoImpl extends BaseRepositorySurvey implements SurveyDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(SurveyDaoImpl.class);

	DateTimeFormatter DATE_FORMAT = new DateTimeFormatterBuilder().appendPattern("uuuu-MM-dd HH:mm:ss.S").toFormatter();

	@Override
	public boolean saveSurvey(SurveyDTO req) {
		LOGGER.info("Inside saveCompanyDetails ");
		if (req.getSurveyName() != null && req.getCreatedBy() > 0 && req.getDepartmentId() > 0
				&& req.getBranchId() > 0) {
			Session session = getCurrentSession();
			MasterSurvey ms = new MasterSurvey();
			ms.setSurveyTitle(req.getSurveyName());
			ms.setCreatedBy(req.getCreatedBy());
			ms.setDepartmenyId(req.getDepartmentId());
			ms.setBranchId(req.getBranchId());
			session.save(ms);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSurvey(SurveyDTO req) {
		LOGGER.info("Inside updateSurvey ");
		if (req.getId() > 0) {
			Session session = getCurrentSession();
			MasterSurvey ms = session.get(MasterSurvey.class, req.getId());
			if (req.getSurveyName() != null) {
				ms.setSurveyTitle(req.getSurveyName());
			}
			if (req.getUpdatedBy() > 0) {
				ms.setUpdatedBy(req.getUpdatedBy());
			}
			if (req.getDepartmentId() > 0) {
				ms.setDepartmenyId(req.getDepartmentId());
			}
			if (req.getBranchId() > 0) {
				ms.setBranchId(req.getBranchId());
			}
			session.update(ms);
			return true;
		}
		return false;
	}

	@Override
	public List<SurveyDTO> getSurvey() {
		LOGGER.info("Inside getSurvey ");
		List<SurveyDTO> list = new ArrayList<>();
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session.createNativeQuery("select id, created_by, branch_id, created_date, "
				+ "depatment_id, survey_title, updated_by, updated_date from master_survey").getResultList();
		if (getList != null) {
			for (Object[] x : getList) {
				LOGGER.info("Inside getSurvey | for");
				SurveyDTO obj = new SurveyDTO();
				if (x[0] != null) {
					obj.setId(Integer.parseInt(String.valueOf(x[0])));
				}
				if (x[1] != null) {
					obj.setCreatedBy(Integer.parseInt(String.valueOf(x[1])));
				}
				if (x[2] != null) {
					obj.setBranchId(Integer.parseInt(String.valueOf(x[2])));
				}
				if (x[3] != null) {
					obj.setCreatedDate(LocalDateTime.parse(String.valueOf(x[3]), DATE_FORMAT));
				}
				if (x[4] != null) {
					obj.setDepartmentId(Integer.parseInt(String.valueOf(x[4])));
				}
				if (x[5] != null) {
					obj.setSurveyName(String.valueOf(x[5]));
				}
				if (x[6] != null) {
					obj.setUpdatedBy(Integer.parseInt(String.valueOf(x[6])));
				}
				if (x[7] != null) {
					obj.setUpdatedDate(LocalDateTime.parse(String.valueOf(x[7]), DATE_FORMAT));
				}
				list.add(obj);
			}
			return list;
		}
		return null;
	}

	@Override
	public boolean deleteSurvey(SurveyDTO req) {
		LOGGER.info("Inside deleteSurvey ");
		if (req.getId() > 0) {
			Session session = getCurrentSession();
			session.createNativeQuery(
					"delete o from  master_survey as m join  survey_questions as s on m.id = s.survey_id "
							+ " join survey_questions_options as o on o.question_id = s.id where m.id=:qid")
					.setParameter("qid", req.getId()).executeUpdate();

			session.createNativeQuery(
					"delete s from survey_questions as s join master_survey as m on s.survey_id = m.id where m.id=:id")
					.setParameter("id", req.getId()).executeUpdate();

			session.createNativeQuery("delete from master_survey where id=:id").setParameter("id", req.getId())
					.executeUpdate();
			return true;
		}
		return false;
	}

	@Override
	public boolean saveQuestion(SurveyDTO req) {
		LOGGER.info("Inside saveQuestion ");
		Session session = getCurrentSession();
		MasterSurveyQuestions mQue = new MasterSurveyQuestions();
		mQue.setQuetion(req.getQuestion());
		mQue.setCreatedBy(req.getCreatedBy());
		if (req.getSurveyId() > 0) {
			mQue.setSurveyId(new MasterSurvey(req.getSurveyId()));
		}
		session.save(mQue);
		return true;
	}

	@Override
	public boolean updateQuestion(SurveyDTO req) {
		LOGGER.info("Inside updateQuestion ");
		Session session = getCurrentSession();
		if (req.getId() > 0) {
			MasterSurveyQuestions ms = session.load(MasterSurveyQuestions.class, req.getId());
			ms.setUpdatedBy(req.getUpdatedBy());
			if (req.getQuestion() != null) {
				ms.setQuetion(req.getQuestion());
			}
			if (req.getSurveyId() > 0) {
				ms.setSurveyId(new MasterSurvey(req.getSurveyId()));
			}
			session.update(ms);
			return true;
		}
		return false;
	}

	@Override
	public List<SurveyDTO> getQuestion() {
		LOGGER.info("Inside getQuestion ");
		List<SurveyDTO> list = new ArrayList<>();
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session.createNativeQuery("select id, created_by, created_date, "
				+ "question, updated_by, updated_date, survey_id from survey_questions").getResultList();
		if (getList != null) {
			for (Object[] x : getList) {
				LOGGER.info("Inside getQuestion | for");
				SurveyDTO obj = new SurveyDTO();
				if (x[0] != null) {
					obj.setId(Integer.parseInt(String.valueOf(x[0])));
				}
				if (x[1] != null) {
					obj.setCreatedBy(Integer.parseInt(String.valueOf(x[1])));
				}
				if (x[2] != null) {
					obj.setCreatedDate(LocalDateTime.parse(String.valueOf(x[2]), DATE_FORMAT));
				}
				if (x[3] != null) {
					obj.setQuestion(String.valueOf(x[3]));
				}
				if (x[4] != null) {
					obj.setUpdatedBy(Integer.parseInt(String.valueOf(x[4])));
				}
				if (x[5] != null) {
					obj.setUpdatedDate(LocalDateTime.parse(String.valueOf(x[5]), DATE_FORMAT));
				}
				if (x[6] != null) {
					obj.setSurveyId(Integer.parseInt(String.valueOf(x[6])));
				}
				list.add(obj);
			}
			return list;
		}
		return null;
	}

	@Override
	public boolean deleteQuestion(SurveyDTO req) {
		if (req.getId() > 0) {
			LOGGER.info("Inside deleteQuestion ");
			Session session = getCurrentSession();
			session.createNativeQuery("delete from survey_questions_options where question_id=:qid")
					.setParameter("qid", req.getId()).executeUpdate();
			session.createNativeQuery("delete from survey_questions where id=:Id").setParameter("Id", req.getId())
					.executeUpdate();
			return true;
		}
		return false;
	}

	@Override
	public boolean saveQuestionOption(SurveyDTO req) {
		LOGGER.info("Inside saveQuestionOption ");
		Session session = getCurrentSession();
		MasterSurveyQuestionsOpts mQue = new MasterSurveyQuestionsOpts();
		mQue.setOptionName(req.getOptionName());
		mQue.setCreatedBy(req.getCreatedBy());
		if (req.getQuestionId() > 0) {
			mQue.setQuestionId(new MasterSurveyQuestions(req.getQuestionId()));
		}
		session.save(mQue);
		return true;
	}

	@Override
	public boolean updateQuestionOption(SurveyDTO req) {
		LOGGER.info("Inside updateQuestionOption ");
		if (req.getId() > 0) {
			Session session = getCurrentSession();
			MasterSurveyQuestionsOpts ms = session.load(MasterSurveyQuestionsOpts.class, req.getId());
			if (req.getOptionName() != null) {
				ms.setOptionName(req.getOptionName());
			}
			if (req.getCreatedBy() > 0) {
				ms.setCreatedBy(req.getCompanyId());
			}
			if (req.getQuestionId() > 0) {
				ms.setQuestionId(new MasterSurveyQuestions(req.getQuestionId()));
			}
			session.update(ms);
			return true;
		}
		return false;
	}

	@Override
	public List<SurveyDTO> getQuestionOption() {
		LOGGER.info("Inside getQuestionOption ");
		List<SurveyDTO> list = new ArrayList<>();
		Session session = getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> getList = session
				.createNativeQuery("select id, created_by, created_date,"
						+ " option_name, updated_by, updated_date, question_id from survey_questions_options")
				.getResultList();
		if (getList != null) {
			for (Object[] x : getList) {
				LOGGER.info("Inside getQuestionOption | for");
				SurveyDTO obj = new SurveyDTO();
				if (x[0] != null) {
					obj.setId(Integer.parseInt(String.valueOf(x[0])));
				}
				if (x[1] != null) {
					obj.setCreatedBy(Integer.parseInt(String.valueOf(x[1])));
				}
				if (x[2] != null) {
					obj.setCreatedDate(LocalDateTime.parse(String.valueOf(x[2]), DATE_FORMAT));
				}
				if (x[3] != null) {
					obj.setOptionName(String.valueOf(x[3]));
				}
				if (x[4] != null) {
					obj.setUpdatedBy(Integer.parseInt(String.valueOf(x[4])));
				}
				if (x[5] != null) {
					obj.setUpdatedDate(LocalDateTime.parse(String.valueOf(x[5]), DATE_FORMAT));
				}
				if (x[6] != null) {
					obj.setQuestionId(Integer.parseInt(String.valueOf(x[6])));
				}
				list.add(obj);
			}
			return list;
		}
		return null;
	}

	@Override
	public boolean deleteQuestionOption(SurveyDTO req) {
		LOGGER.info("Inside deleteQuestionOption ");
		if (req.getId() > 0) {
			Session session = getCurrentSession();
			MasterSurveyQuestionsOpts obj = session.load(MasterSurveyQuestionsOpts.class, req.getId());
			session.delete(obj);
			return true;
		}
		return false;
	}

}
