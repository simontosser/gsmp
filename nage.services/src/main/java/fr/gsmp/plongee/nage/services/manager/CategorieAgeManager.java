/**
 * 
 */
package fr.gsmp.plongee.nage.services.manager;

import java.util.List;

import fr.gsmp.plongee.nage.dao.data.Categorieage;

/**
 * @author simon
 *
 */
public interface CategorieAgeManager {
	/**
	 * 
	 * @param id
	 * @return
	 */
	Categorieage getCategorieageById(Integer id);
	
	/**
	 * 
	 * @param age
	 * @return
	 */
	Categorieage getCategorieageByAge(Integer age);
	
	/**
	 * 
	 * @return
	 */
	List<Categorieage> getAllCategorieage();
	
	/**
	 * 
	 * @param categorieage
	 */
	void delete(Categorieage categorieage);
	
	/**
	 * 
	 * @param categorieage
	 */
	void save(Categorieage categorieage);
}
