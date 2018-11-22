package com.lifung.dao;
// default package
// Generated 2018/8/10 ?? 11:32:26 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class DeviceProfile.
 * @see .DeviceProfile
 * @author Hibernate Tools
 */
public class DeviceProfileDAO {

	private static final Log log = LogFactory.getLog(DeviceProfileDAO.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void persist(DeviceProfile transientInstance) {
		log.debug("persisting DeviceProfile instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DeviceProfile instance) {
		log.debug("attaching dirty DeviceProfile instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DeviceProfile instance) {
		log.debug("attaching clean DeviceProfile instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DeviceProfile persistentInstance) {
		log.debug("deleting DeviceProfile instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DeviceProfile merge(DeviceProfile detachedInstance) {
		log.debug("merging DeviceProfile instance");
		try {
			DeviceProfile result = (DeviceProfile) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DeviceProfile findById(java.lang.String id) {
		log.debug("getting DeviceProfile instance with id: " + id);
		try {
			DeviceProfile instance = (DeviceProfile) sessionFactory.getCurrentSession().get("DeviceProfile", id);
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

	public List findByExample(DeviceProfile instance) {
		log.debug("finding DeviceProfile instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("DeviceProfile")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
