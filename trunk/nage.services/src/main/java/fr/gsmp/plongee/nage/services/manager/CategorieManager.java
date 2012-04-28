/**
 * 
 */
package fr.gsmp.plongee.nage.services.manager;

import java.util.List;

import fr.gsmp.plongee.nage.dao.data.Categorie;

/**
 * @author simon
 *
 */
public interface CategorieManager {
	
	/**
	 * Categorie getCategorieById(Integer caetegorieid);
	 * @return
	 */
	List<Categorie> getAllCategorie();
	
	
	Categorie getCategorieById(Integer id);
	
	/**
	 * 
	 * @param categorie
	 */
	void delete(Categorie categorie);
	
	/**
	 * 
	 * @param categorie
	 */
	void save(Categorie categorie);
}
