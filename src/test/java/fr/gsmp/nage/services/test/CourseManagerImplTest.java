/**
 * 
 */
package fr.gsmp.nage.services.test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gsmp.plongee.nage.dao.data.Course;
import fr.gsmp.plongee.nage.services.manager.CourseManager;

/**
 * @author simon
 * 
 */
public class CourseManagerImplTest {

	private CourseManager cm;
	private Course course;

	/**
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextServices.xml");

		cm = (CourseManager) ctx.getBean("courseManagerImpl");

		course = new Course();
		course.setCoursedate(new Date());
		course.setCoursenom("Course de test");
		course.setCourselongueur(5000);

		
	}

	/**
	 * Test method for
	 * {@link fr.gsmp.plongee.nage.services.manager.impl.CourseManagerImpl#save(fr.gsmp.plongee.nage.dao.data.Course)}
	 * .
	 */
	@Test
	public void testSave() {
			cm.save(course);
			cm.delete(course);
	}

	/**
	 * Test method for
	 * {@link fr.gsmp.plongee.nage.services.manager.impl.CourseManagerImpl#getAllCourses()}
	 * .
	 */
	@Test
	public void testGetAllCourses() {
		cm.getAllCourses();
	}

	/**
	 * Test method for
	 * {@link fr.gsmp.plongee.nage.services.manager.impl.CourseManagerImpl#getCourseById(java.lang.Integer)}
	 * .
	 */
	@Test
	public void testGetCourseById() {
		cm.save(course);
		Course c = cm.getCourseById(course.getCourseid());
		if (c == null)
			fail("Get course by id failled");
		cm.delete(c);
	}

	/**
	 * Test method for
	 * {@link fr.gsmp.plongee.nage.services.manager.impl.CourseManagerImpl#delete(fr.gsmp.plongee.nage.dao.data.Course)}
	 * .
	 */
	@Test
	public void testDelete() {
		cm.save(course);
		cm.delete(course);
	}

}
