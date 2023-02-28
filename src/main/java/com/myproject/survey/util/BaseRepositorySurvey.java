package com.myproject.survey.util;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

public class BaseRepositorySurvey {
	@PersistenceContext
	EntityManager entityManager;

	protected Session getCurrentSession() {
		return entityManager.unwrap(Session.class);
	}

}
