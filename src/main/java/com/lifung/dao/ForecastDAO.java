package com.lifung.dao;
// default package
// Generated 2018/11/19 ?? 08:35:42 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Forecast.
 * @see .Forecast
 * @author Hibernate Tools
 */
public class ForecastDAO {

	private static final Log log = LogFactory.getLog(ForecastDAO.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void persist(Forecast transientInstance) {
		log.debug("persisting Forecast instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Forecast instance) {
		log.debug("attaching dirty Forecast instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate("com.lifung.dao.Forecast",instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Forecast instance) {
		log.debug("attaching clean Forecast instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Forecast persistentInstance) {
		log.debug("deleting Forecast instance");
		try {
			sessionFactory.getCurrentSession().delete("com.lifung.dao.Forecast",persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Forecast merge(Forecast detachedInstance) {
		log.debug("merging Forecast instance");
		try {
			Forecast result = (Forecast) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Forecast findById(ForecastId id) {
		log.debug("getting Forecast instance with id: " + id);
		try {
			Forecast instance = (Forecast) sessionFactory.getCurrentSession().get("com.lifung.dao.Forecast", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Forecast instance) {
		log.debug("finding Forecast instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.lifung.dao.Forecast").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
