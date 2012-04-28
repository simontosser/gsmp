/**
 * 
 */
package fr.gsmp.plongee.nage.services.manager.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import fr.gsmp.plongee.nage.dao.data.Categorie;
import fr.gsmp.plongee.nage.dao.data.Course;
import fr.gsmp.plongee.nage.services.manager.CategorieManager;

/**
 * @author simon
 *
 */
public class CategorieManagerImpl extends ManagerImpl implements CategorieManager {

	/* (non-Javadoc)
	 * @see fr.gsmp.plongee.nage.services.manager.CategorieManager#getAllCategorie()
	 */
	@Override
	public List<Categorie> getAllCategorie() {
		Criteria criteria = session.createCriteria(Categorie.class);
		return criteria.list();
	}

	/* (non-Javadoc)
	 * @see fr.gsmp.plongee.nage.services.manager.CategorieManager#delete(fr.gsmp.plongee.nage.dao.data.Categorie)
	 */
	@Override
	public void delete(Categorie categorie) {
		Transaction tx = session.beginTransaction();
		session.delete(categorie);
		tx.commit();
	}

	/* (non-Javadoc)
	 * @see fr.gsmp.plongee.nage.services.manager.CategorieManager#save(fr.gsmp.plongee.nage.dao.data.Categorie)
	 */
	@Override
	public void save(Categorie categorie) {
		Transaction tx = session.beginTransaction();
		session.save(categorie);
		tx.commit();
	}

	@Override
	public Categorie getCategorieById(Integer id) {
		Criteria criteria = session.createCriteria(Categorie.class);
		criteria.add(Restrictions.eq("categorieid",id));
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return  (Categorie) criteria.uniqueResult();
	}

}
