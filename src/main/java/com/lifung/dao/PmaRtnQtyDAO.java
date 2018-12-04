package com.lifung.dao;
// default package
// Generated 2018/11/29 ?? 03:38:52 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class PmaRtnQty.
 * @see .PmaRtnQty
 * @author Hibernate Tools
 */
public class PmaRtnQtyDAO {

	private static final Log log = LogFactory.getLog(PmaRtnQtyDAO.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(PmaRtnQty transientInstance) {
		log.debug("persisting PmaRtnQty instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PmaRtnQty instance) {
		log.debug("attaching dirty PmaRtnQty instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PmaRtnQty instance) {
		log.debug("attaching clean PmaRtnQty instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PmaRtnQty persistentInstance) {
		log.debug("deleting PmaRtnQty instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PmaRtnQty merge(PmaRtnQty detachedInstance) {
		log.debug("merging PmaRtnQty instance");
		try {
			PmaRtnQty result = (PmaRtnQty) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PmaRtnQty findById(java.lang.String id) {
		log.debug("getting PmaRtnQty instance with id: " + id);
		try {
			PmaRtnQty instance = (PmaRtnQty) sessionFactory.getCurrentSession().get("com.lifung.dao.PmaRtnQty", id);
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

	public List findByExample(PmaRtnQty instance) {
		log.debug("finding PmaRtnQty instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.lifung.dao.PmaRtnQty").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
