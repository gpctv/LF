package com.lifung.dao;
// default package
// Generated 2019/2/23 ?? 09:42:23 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Rdtprinter.
 * @see .Rdtprinter
 * @author Hibernate Tools
 */
public class RdtprinterDAO {

	private static final Log log = LogFactory.getLog(RdtprinterDAO.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void persist(Rdtprinter transientInstance) {
		log.debug("persisting Rdtprinter instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Rdtprinter instance) {
		log.debug("attaching dirty Rdtprinter instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Rdtprinter instance) {
		log.debug("attaching clean Rdtprinter instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Rdtprinter persistentInstance) {
		log.debug("deleting Rdtprinter instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Rdtprinter merge(Rdtprinter detachedInstance) {
		log.debug("merging Rdtprinter instance");
		try {
			Rdtprinter result = (Rdtprinter) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Rdtprinter findById(java.lang.String id) {
		log.debug("getting Rdtprinter instance with id: " + id);
		try {
			Rdtprinter instance = (Rdtprinter) sessionFactory.getCurrentSession().get("Rdtprinter", id);
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

	public List findByExample(Rdtprinter instance) {
		log.debug("finding Rdtprinter instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("Rdtprinter").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
