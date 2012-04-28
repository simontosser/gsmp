package fr.gsmp.plongee.nage.dao.data;

import java.util.Date;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
public class Course extends AbstractCourse implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String coursenom, Integer courselongueur) {
		super(coursenom, courselongueur);
	}

	/** full constructor */
	public Course(String coursenom, Integer courselongueur, Date coursedate,
			Set participantses) {
		super(coursenom, courselongueur, coursedate, participantses);
	}

}
