/**
 * 
 */
package fr.gsmp.plongee.nage.services.manager.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import fr.gsmp.plongee.nage.dao.data.Categorieage;
import fr.gsmp.plongee.nage.services.manager.CategorieAgeManager;

/**
 * @author simon
 *
 */
public class CategorieAgeManagerImpl extends ManagerImpl implements
		CategorieAgeManager {

	/* (non-Javadoc)
	 * @see fr.gsmp.plongee.nage.services.manager.CategorieAgeManager#getCategorieageById(java.lang.Integer)
	 */
	@Override
	public Categorieage getCategorieageById(Integer id) {
		Criteria criteria = session.createCriteria(Categorieage.class);
		criteria.add(Restrictions.eq("categorieid",id));
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return  (Categorieage) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see fr.gsmp.plongee.nage.services.manager.CategorieAgeManager#getCategorieageByAge(java.lang.Integer)
	 */
	@Override
	public Categorieage getCategorieageByAge(Integer age) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.gsmp.plongee.nage.services.manager.CategorieAgeManager#getAllCategorieage()
	 */
	@Override
	public List<Categorieage> getAllCategorieage() {
		Criteria criteria = session.createCriteria(Categorieage.class);
		return criteria.list();
	}

	/* (non-Javadoc)
	 * @see fr.gsmp.plongee.nage.services.manager.CategorieAgeManager#delete(fr.gsmp.plongee.nage.dao.data.Categorieage)
	 */
	@Override
	public void delete(Categorieage categorieage) {
		Transaction tx = session.beginTransaction();
		session.delete(categorieage);
		tx.commit();
	}

	/* (non-Javadoc)
	 * @see fr.gsmp.plongee.nage.services.manager.CategorieAgeManager#save(fr.gsmp.plongee.nage.dao.data.Categorieage)
	 */
	@Override
	public void save(Categorieage categorieage) {
		Transaction tx = session.beginTransaction();
		session.save(categorieage);
		tx.commit();
	}

}
