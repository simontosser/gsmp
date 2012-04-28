package fr.gsmp.plongee.nage.dao.data;

import java.util.Set;

/**
 * Categorieage entity. @author MyEclipse Persistence Tools
 */
public class Categorieage extends AbstractCategorieage implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Categorieage() {
	}

	/** minimal constructor */
	public Categorieage(String categorienom) {
		super(categorienom);
	}

	/** full constructor */
	public Categorieage(String categorienom, Integer agemini,
			Integer agemax, Set participantses) {
		super(categorienom, agemini, agemax, participantses);
	}

}
