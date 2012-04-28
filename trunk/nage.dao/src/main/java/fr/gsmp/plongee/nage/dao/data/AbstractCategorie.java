package fr.gsmp.plongee.nage.dao.data;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCategorie entity provides the base persistence definition of the
 * Categorie entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCategorie implements java.io.Serializable {

	// Fields

	private Integer categorieid;
	private String categoriename;
	private Set participantses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCategorie() {
	}

	/** minimal constructor */
	public AbstractCategorie(String categoriename) {
		this.categoriename = categoriename;
	}

	/** full constructor */
	public AbstractCategorie(String categoriename, Set participantses) {
		this.categoriename = categoriename;
		this.participantses = participantses;
	}

	// Property accessors

	public Integer getCategorieid() {
		return this.categorieid;
	}

	public void setCategorieid(Integer categorieid) {
		this.categorieid = categorieid;
	}

	public String getCategoriename() {
		return this.categoriename;
	}

	public void setCategoriename(String categoriename) {
		this.categoriename = categoriename;
	}

	public Set getParticipantses() {
		return this.participantses;
	}

	public void setParticipantses(Set participantses) {
		this.participantses = participantses;
	}
	@Override
	public String toString() {
		return categoriename;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categorieid == null) ? 0 : categorieid.hashCode());
		result = prime * result
				+ ((categoriename == null) ? 0 : categoriename.hashCode());
		return result;
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
		AbstractCategorie other = (AbstractCategorie) obj;
		if (categorieid == null) {
			if (other.categorieid != null)
				return false;
		} else if (!categorieid.equals(other.categorieid))
			return false;
		if (categoriename == null) {
			if (other.categoriename != null)
				return false;
		} else if (!categoriename.equals(other.categoriename))
			return false;
		return true;
	}
}