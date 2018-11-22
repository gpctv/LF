package com.lifung.dao;
// default package
// Generated 2018/4/19 ?? 06:11:16 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class ItfConfig.
 * @see .ItfConfig
 * @author Hibernate Tools
 */
@Transactional
public class ItfConfigDAO {

	private static final Log log = LogFactory.getLog(ItfConfigDAO.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(ItfConfig transientInstance) {
		log.debug("persisting ItfConfig instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ItfConfig instance) {
		log.debug("attaching dirty ItfConfig instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ItfConfig instance) {
		log.debug("attaching clean ItfConfig instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ItfConfig persistentInstance) {
		log.debug("deleting ItfConfig instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ItfConfig merge(ItfConfig detachedInstance) {
		log.debug("merging ItfConfig instance");
		try {
			ItfConfig result = (ItfConfig) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ItfConfig findById(ItfConfigId id) {
		log.debug("getting ItfConfig instance with id: " + id);
		try {
			ItfConfig instance = (ItfConfig) sessionFactory.getCurrentSession().get("ItfConfig", id);
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

	public List findByExample(ItfConfig instance) {
		log.debug("finding ItfConfig instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("ItfConfig").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
