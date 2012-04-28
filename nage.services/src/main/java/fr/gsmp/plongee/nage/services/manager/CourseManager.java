/**
 * 
 */
package fr.gsmp.plongee.nage.services.manager;

import java.util.List;

import fr.gsmp.plongee.nage.dao.data.Course;

/**
 * @author simon
 *
 */
public interface CourseManager {
	/**
	 * 
	 * @param courseid
	 * @return
	 */
	Course getCourseById(Integer courseid);
	
	/**
	 * 
	 * @param course
	 */
	void save(Course course);
	
	/**
	 * 
	 * @param course
	 */
	void delete(Course course);
	
	/**
	 * 
	 * @return
	 */
	List<Course> getAllCourses();
	
}
