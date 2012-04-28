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
 * Categorie entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see fr.gsmp.plongee.nage.dao.data.Categorie
 * @author MyEclipse Persistence Tools
 */

public class CategorieDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CategorieDAO.class);
	// property constants
	public static final String CATEGORIENAME = "categoriename";

	protected void initDao() {
		// do nothing
	}

	public void save(Categorie transientInstance) {
		log.debug("saving Categorie instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Categorie persistentInstance) {
		log.debug("deleting Categorie instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Categorie findById(java.lang.Integer id) {
		log.debug("getting Categorie instance with id: " + id);
		try {
			Categorie instance = (Categorie) getHibernateTemplate().get(
					"fr.gsmp.plongee.nage.dao.data.Categorie", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Categorie instance) {
		log.debug("finding Categorie instance by example");
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
		log.debug("finding Categorie instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Categorie as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCategoriename(Object categoriename) {
		return findByProperty(CATEGORIENAME, categoriename);
	}

	public List findAll() {
		log.debug("finding all Categorie instances");
		try {
			String queryString = "from Categorie";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Categorie merge(Categorie detachedInstance) {
		log.debug("merging Categorie instance");
		try {
			Categorie result = (Categorie) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Categorie instance) {
		log.debug("attaching dirty Categorie instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Categorie instance) {
		log.debug("attaching clean Categorie instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CategorieDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CategorieDAO) ctx.getBean("CategorieDAO");
	}
}