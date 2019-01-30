package com.lifung.dao;
// default package
// Generated 2018/12/27 ?? 04:04:59 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Transmitlog2.
 * @see .Transmitlog2
 * @author Hibernate Tools
 */
public class Transmitlog2DAO {

	private static final Log log = LogFactory.getLog(Transmitlog2DAO.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void persist(Transmitlog2 transientInstance) {
		log.debug("persisting Transmitlog2 instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Transmitlog2 instance) {
		log.debug("attaching dirty Transmitlog2 instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Transmitlog2 instance) {
		log.debug("attaching clean Transmitlog2 instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Transmitlog2 persistentInstance) {
		log.debug("deleting Transmitlog2 instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Transmitlog2 merge(Transmitlog2 detachedInstance) {
		log.debug("merging Transmitlog2 instance");
		try {
			Transmitlog2 result = (Transmitlog2) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Transmitlog2 findById(java.lang.String id) {
		log.debug("getting Transmitlog2 instance with id: " + id);
		try {
			Transmitlog2 instance = (Transmitlog2) sessionFactory.getCurrentSession().get("Transmitlog2", id);
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

	public List findByExample(Transmitlog2 instance) {
		log.debug("finding Transmitlog2 instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("Transmitlog2")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
