package fr.gsmp.plongee.nage.dao.data;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Participants entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see fr.gsmp.plongee.nage.dao.data.Participants
 * @author MyEclipse Persistence Tools
 */

public class ParticipantsDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ParticipantsDAO.class);
	// property constants
	public static final String PARTICIPANTNOM = "participantnom";
	public static final String PARTICIPANTPRENOM = "participantprenom";
	public static final String PARTICIPANTCLUB = "participantclub";
	public static final String PARTICIPANTLICENCE = "participantlicence";
	public static final String PARTICIPANTCOMPET = "participantcompet";

	protected void initDao() {
		// do nothing
	}

	public void save(Participants transientInstance) {
		log.debug("saving Participants instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Participants persistentInstance) {
		log.debug("deleting Participants instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Participants findById(java.lang.Integer id) {
		log.debug("getting Participants instance with id: " + id);
		try {
			Participants instance = (Participants) getHibernateTemplate().get(
					"fr.gsmp.plongee.nage.dao.data.Participants", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Participants instance) {
		log.debug("finding Participants instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Participants instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Participants as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByParticipantnom(Object participantnom) {
		return findByProperty(PARTICIPANTNOM, participantnom);
	}

	public List findByParticipantprenom(Object participantprenom) {
		return findByProperty(PARTICIPANTPRENOM, participantprenom);
	}

	public List findByParticipantclub(Object participantclub) {
		return findByProperty(PARTICIPANTCLUB, participantclub);
	}

	public List findByParticipantlicence(Object participantlicence) {
		return findByProperty(PARTICIPANTLICENCE, participantlicence);
	}

	public List findByParticipantcompet(Object participantcompet) {
		return findByProperty(PARTICIPANTCOMPET, participantcompet);
	}

	public List findAll() {
		log.debug("finding all Participants instances");
		try {
			String queryString = "from Participants";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Participants merge(Participants detachedInstance) {
		log.debug("merging Participants instance");
		try {
			Participants result = (Participants) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Participants instance) {
		log.debug("attaching dirty Participants instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Participants instance) {
		log.debug("attaching clean Participants instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ParticipantsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ParticipantsDAO) ctx.getBean("ParticipantsDAO");
	}
}