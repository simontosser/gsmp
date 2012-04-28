/**
 * 
 */
package fr.gsmp.plongee.nage.services.manager.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import fr.gsmp.plongee.nage.dao.data.Course;
import fr.gsmp.plongee.nage.services.manager.CourseManager;

/**
 * @author simon
 * 
 */
public class CourseManagerImpl extends ManagerImpl implements CourseManager { 

	


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.gsmp.plongee.nage.services.manager.CourseManager#getCourseById(java
	 * .lang.Integer)
	 */
	@Override
	public Course getCourseById(Integer courseid) {
		Criteria criteria = session.createCriteria(Course.class);
		criteria.add(Restrictions.eq("courseid",courseid));
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return  (Course) criteria.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.gsmp.plongee.nage.services.manager.CourseManager#save(fr.gsmp.plongee
	 * .nage.dao.data.Course)
	 */
	@Override
	public void save(Course course) {
		Transaction tx = session.beginTransaction();
		session.save(course);
		tx.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.gsmp.plongee.nage.services.manager.CourseManager#delete(fr.gsmp.plongee
	 * .nage.dao.data.Course)
	 */
	@Override
	public void delete(Course course) {
		Transaction tx = session.beginTransaction();
		session.delete(course);
		tx.commit();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gsmp.plongee.nage.services.manager.CourseManager#getAllCourses()
	 */
	@Override
	public List<Course> getAllCourses() {
		Criteria criteria = session.createCriteria(Course.class);
		return criteria.list();
	}



}