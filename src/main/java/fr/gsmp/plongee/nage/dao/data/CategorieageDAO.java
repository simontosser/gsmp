package fr.gsmp.plongee.nage.dao.data;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Categorieage entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see fr.gsmp.plongee.nage.dao.data.Categorieage
 * @author MyEclipse Persistence Tools
 */

public class CategorieageDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CategorieageDAO.class);
	// property constants
	public static final String CATEGORIENOM = "categorienom";
	public static final String AGEMINI = "agemini";
	public static final String AGEMAX = "agemax";

	protected void initDao() {
		// do nothing
	}

	public void save(Categorieage transientInstance) {
		log.debug("saving Categorieage instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Categorieage persistentInstance) {
		log.debug("deleting Categorieage instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Categorieage findById(java.lang.Integer id) {
		log.debug("getting Categorieage instance with id: " + id);
		try {
			Categorieage instance = (Categorieage) getHibernateTemplate().get(
					"fr.gsmp.plongee.nage.dao.data.Categorieage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Categorieage instance) {
		log.debug("finding Categorieage instance by example");
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
		log.debug("finding Categorieage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Categorieage as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCategorienom(Object categorienom) {
		return findByProperty(CATEGORIENOM, categorienom);
	}

	public List findByAgemini(Object agemini) {
		return findByProperty(AGEMINI, agemini);
	}

	public List findByAgemax(Object agemax) {
		return findByProperty(AGEMAX, agemax);
	}

	public List findAll() {
		log.debug("finding all Categorieage instances");
		try {
			String queryString = "from Categorieage";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Categorieage merge(Categorieage detachedInstance) {
		log.debug("merging Categorieage instance");
		try {
			Categorieage result = (Categorieage) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Categorieage instance) {
		log.debug("attaching dirty Categorieage instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Categorieage instance) {
		log.debug("attaching clean Categorieage instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CategorieageDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CategorieageDAO) ctx.getBean("CategorieageDAO");
	}
}