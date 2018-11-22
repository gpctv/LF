// default package
// Generated 2018/4/19 ?? 06:11:16 by Hibernate Tools 3.4.0.CR1
package com.lifung.dao;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class ItfGtwatcherConfig.
 * @see .ItfGtwatcherConfig
 * @author Hibernate Tools
 */
@Transactional
public class ItfGtwatcherConfigDAO {

	private static final Log log = LogFactory.getLog(ItfGtwatcherConfigDAO.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(ItfGtwatcherConfig transientInstance) {
		log.debug("persisting ItfGtwatcherConfig instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ItfGtwatcherConfig instance) {
		log.debug("attaching dirty ItfGtwatcherConfig instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ItfGtwatcherConfig instance) {
		log.debug("attaching clean ItfGtwatcherConfig instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ItfGtwatcherConfig persistentInstance) {
		log.debug("deleting ItfGtwatcherConfig instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ItfGtwatcherConfig merge(ItfGtwatcherConfig detachedInstance) {
		log.debug("merging ItfGtwatcherConfig instance");
		try {
			ItfGtwatcherConfig result = (ItfGtwatcherConfig) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ItfGtwatcherConfig findById(int id) {
		log.debug("getting ItfGtwatcherConfig instance with id: " + id);
		try {
			ItfGtwatcherConfig instance = (ItfGtwatcherConfig) sessionFactory.getCurrentSession()
					.get("com.lifung.dao.ItfGtwatcherConfig", id);
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

	public List findByExample(ItfGtwatcherConfig instance) {
		log.debug("finding ItfGtwatcherConfig instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("ItfGtwatcherConfig")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public void getEDI() {
		Query query=this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.ItfGtwatcherConfig.datastream");
		List<Object[]> list=query.list();
		for(Object[] o:list) {
			log.debug(o[0].toString());
		}
	}
}
