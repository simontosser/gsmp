package fr.gsmp.plongee.nage.dao.data;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCategorieage entity provides the base persistence definition of the
 * Categorieage entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCategorieage implements java.io.Serializable {

	// Fields
	private Integer categorieid;
	private String categorienom;
	private Integer agemini;
	private Integer agemax;
	private Set participantses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCategorieage() {
	}

	/** minimal constructor */
	public AbstractCategorieage(String categorienom) {
		this.categorienom = categorienom;
	}

	/** full constructor */
	public AbstractCategorieage(String categorienom, Integer agemini,
			Integer agemax, Set participantses) {
		this.categorienom = categorienom;
		this.agemini = agemini;
		this.agemax = agemax;
		this.participantses = participantses;
	}

	// Property accessors

	public Integer getCategorieid() {
		return this.categorieid;
	}

	public void setCategorieid(Integer categorieid) {
		this.categorieid = categorieid;
	}

	public String getCategorienom() {
		return this.categorienom;
	}

	public void setCategorienom(String categorienom) {
		this.categorienom = categorienom;
	}

	public Integer getAgemini() {
		return this.agemini;
	}

	public void setAgemini(Integer agemini) {
		this.agemini = agemini;
	}

	public Integer getAgemax() {
		return this.agemax;
	}

	public void setAgemax(Integer agemax) {
		this.agemax = agemax;
	}

	public Set getParticipantses() {
		return this.participantses;
	}

	public void setParticipantses(Set participantses) {
		this.participantses = participantses;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agemax == null) ? 0 : agemax.hashCode());
		result = prime * result + ((agemini == null) ? 0 : agemini.hashCode());
		result = prime * result
				+ ((categorieid == null) ? 0 : categorieid.hashCode());
		result = prime * result
				+ ((categorienom == null) ? 0 : categorienom.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return categorienom;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractCategorieage other = (AbstractCategorieage) obj;
		if (agemax == null) {
			if (other.agemax != null)
				return false;
		} else if (!agemax.equals(other.agemax))
			return false;
		if (agemini == null) {
			if (other.agemini != null)
				return false;
		} else if (!agemini.equals(other.agemini))
			return false;
		if (categorieid == null) {
			if (other.categorieid != null)
				return false;
		} else if (!categorieid.equals(other.categorieid))
			return false;
		if (categorienom == null) {
			if (other.categorienom != null)
				return false;
		} else if (!categorienom.equals(other.categorienom))
			return false;
		return true;
	}

}