package com.lifung.dao;
// default package
// Generated 2018/7/25 ?? 05:32:43 by Hibernate Tools 3.4.0.CR1

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
 * Home object for domain model class Transmitlog3.
 * @see .Transmitlog3
 * @author Hibernate Tools
 */
@Transactional
public class Transmitlog3DAO {

	private static final Log log = LogFactory.getLog(Transmitlog3DAO.class);
 
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(Transmitlog3 transientInstance) {
		log.debug("persisting Transmitlog3 instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Transmitlog3 instance) {
		log.debug("attaching dirty Transmitlog3 instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Transmitlog3 instance) {
		log.debug("attaching clean Transmitlog3 instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Transmitlog3 persistentInstance) {
		log.debug("deleting Transmitlog3 instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Transmitlog3 merge(Transmitlog3 detachedInstance) {
		log.debug("merging Transmitlog3 instance");
		try {
			Transmitlog3 result = (Transmitlog3) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Transmitlog3 findById(java.lang.String id) {
		log.debug("getting Transmitlog3 instance with id: " + id);
		try {
			Transmitlog3 instance = (Transmitlog3) sessionFactory.getCurrentSession().get("Transmitlog3", id);
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

	public List findByExample(Transmitlog3 instance) {
		log.debug("finding Transmitlog3 instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("Transmitlog3")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
