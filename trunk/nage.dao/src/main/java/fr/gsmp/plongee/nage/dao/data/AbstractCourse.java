package fr.gsmp.plongee.nage.dao.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCourse entity provides the base persistence definition of the Course
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCourse implements java.io.Serializable {

	// Fields



	private Integer courseid;
	private String coursenom;
	private Integer courselongueur;
	private Date coursedate;
	private Set participantses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCourse() {
	}

	/** minimal constructor */
	public AbstractCourse(String coursenom, Integer courselongueur) {
		this.coursenom = coursenom;
		this.courselongueur = courselongueur;
	}

	/** full constructor */
	public AbstractCourse(String coursenom, Integer courselongueur,
			Date coursedate, Set participantses) {
		this.coursenom = coursenom;
		this.courselongueur = courselongueur;
		this.coursedate = coursedate;
		this.participantses = participantses;
	}

	// Property accessors

	public Integer getCourseid() {
		return this.courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public String getCoursenom() {
		return this.coursenom;
	}

	public void setCoursenom(String coursenom) {
		this.coursenom = coursenom;
	}

	public Integer getCourselongueur() {
		return this.courselongueur;
	}

	public void setCourselongueur(Integer courselongueur) {
		this.courselongueur = courselongueur;
	}

	public Date getCoursedate() {
		return this.coursedate;
	}

	public void setCoursedate(Date coursedate) {
		this.coursedate = coursedate;
	}

	public Set getParticipantses() {
		return this.participantses;
	}

	public void setParticipantses(Set participantses) {
		this.participantses = participantses;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  coursenom + " "+courselongueur;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coursedate == null) ? 0 : coursedate.hashCode());
		result = prime * result
				+ ((courseid == null) ? 0 : courseid.hashCode());
		result = prime * result
				+ ((courselongueur == null) ? 0 : courselongueur.hashCode());
		result = prime * result
				+ ((coursenom == null) ? 0 : coursenom.hashCode());
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
		AbstractCourse other = (AbstractCourse) obj;
		if (coursedate == null) {
			if (other.coursedate != null)
				return false;
		} else if (!coursedate.equals(other.coursedate))
			return false;
		if (courseid == null) {
			if (other.courseid != null)
				return false;
		} else if (!courseid.equals(other.courseid))
			return false;
		if (courselongueur == null) {
			if (other.courselongueur != null)
				return false;
		} else if (!courselongueur.equals(other.courselongueur))
			return false;
		if (coursenom == null) {
			if (other.coursenom != null)
				return false;
		} else if (!coursenom.equals(other.coursenom))
			return false;
		return true;
	}

}