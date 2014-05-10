/**
 * 
 */
package fr.gsmp.nage.services.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gsmp.plongee.nage.dao.data.Participants;
import fr.gsmp.plongee.nage.services.manager.CategorieAgeManager;
import fr.gsmp.plongee.nage.services.manager.CategorieManager;
import fr.gsmp.plongee.nage.services.manager.CourseManager;
import fr.gsmp.plongee.nage.services.manager.ParticipantsManager;

/**
 * @author simon
 *
 */
public class ParticipantsManagerImplTest {

	private ParticipantsManager pm;
	private CourseManager cm;
	private CategorieManager catman;
	private CategorieAgeManager catageman;


	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextServices.xml");

		pm = (ParticipantsManager) ctx.getBean("participantsManagerImpl");
		cm = (CourseManager) ctx.getBean("courseManagerImpl");
		catman = (CategorieManager) ctx.getBean("categorieManagerImpl");
		catageman =(CategorieAgeManager) ctx.getBean("categorieAgeManagerImpl");

	}

	/**
	 * Test method for {@link fr.gsmp.plongee.nage.services.manager.impl.ParticipantsManagerImpl#getParticipantById(java.lang.Integer)}.
	 */
	@Test
	public void testGetParticipantById() {
		System.out.println("testGetParticipantById");

		pm.getParticipantById(2);
	}

	/**
	 * Test method for {@link fr.gsmp.plongee.nage.services.manager.impl.ParticipantsManagerImpl#getParticipantByLicenceNumber(java.lang.String)}.
	 */
	@Test
	public void testGetParticipantByLicenceNumber() {
		System.out.println("testGetParticipantByLicenceNumber");

		pm.getParticipantByLicenceNumber("A-101235");
	}

	/**
	 * Test method for {@link fr.gsmp.plongee.nage.services.manager.impl.ParticipantsManagerImpl#getAllParticipants()}.
	 */
	@Test
	public void testGetAllParticipants() {
		System.out.println("testGetAllParticipants");

		List<Participants> list = pm.getAllParticipants();
		for (Participants participants : list) {
			System.out.println(participants.getParticipantid()+"\t|"+participants.getParticipantnom()+" "+participants.getParticipantprenom()+"\t\t|"+participants.getParticipanttemps()+"\t|"+participants.getCourse().getCoursenom());
		}
	}

	/**
	 * Test method for {@link fr.gsmp.plongee.nage.services.manager.impl.ParticipantsManagerImpl#getAllPArticipantsByCourse(fr.gsmp.plongee.nage.dao.data.Course)}.
	 */
	@Test
	public void testGetAllPArticipantsByCourse() {
		List<Participants> list = pm.getAllPArticipantsByCourse(cm.getCourseById(8));
		
		
		System.out.println("testGetAllPArticipantsByCourse");
		for (Participants participants : list) {
			System.out.println(participants.getParticipantid()+"\t|"+participants.getParticipantnom()+" "+participants.getParticipantprenom()+"\t\t|"+participants.getParticipanttemps()+"\t|"+participants.getCourse().getCoursenom());
		}	
	}

	/**
	 * Test method for {@link fr.gsmp.plongee.nage.services.manager.impl.ParticipantsManagerImpl#getAllCompetParticipants()}.
	 */
	@Test
	public void testGetAllCompetParticipants() {
		System.out.println("testGetAllCompetParticipants");
		List<Participants> list = pm.getAllCompetParticipants();
		for (Participants participants : list) {
			System.out.println(participants.getParticipantid()+"\t|"+participants.getParticipantnom()+" "+participants.getParticipantprenom()+"\t\t|"+participants.getParticipanttemps()+"\t|"+participants.getCourse().getCoursenom());
		}
	}

	/**
	 * Test method for {@link fr.gsmp.plongee.nage.services.manager.impl.ParticipantsManagerImpl#getAllLoisirParticipants()}.
	 */
	@Test
	public void testGetAllLoisirParticipants() {
		System.out.println("testGetAllLoisirParticipants");

		List<Participants> list = pm.getAllLoisirParticipants();
		for (Participants participants : list) {
			System.out.println(participants.getParticipantid()+"\t|"+participants.getParticipantnom()+" "+participants.getParticipantprenom()+"\t\t|"+participants.getParticipanttemps()+"\t|"+participants.getCourse().getCoursenom());
		}
	}

	/**
	 * Test method for {@link fr.gsmp.plongee.nage.services.manager.impl.ParticipantsManagerImpl#getAllParticipantsByAgeCategorie(fr.gsmp.plongee.nage.dao.data.Categorieage)}.
	 */
	@Test
	public void testGetAllParticipantsByAgeCategorie() {
		System.out.println("testGetAllParticipantsByAgeCategorie");

		List<Participants> list = pm.getAllParticipantsByAgeCategorie(catageman.getCategorieageById(2));
		for (Participants participants : list) {
			System.out.println(participants.getParticipantid()+"\t|"+participants.getParticipantnom()+" "+participants.getParticipantprenom()+"\t\t|"+participants.getParticipanttemps()+"\t|"+participants.getCourse().getCoursenom());
		}
	}

	/**
	 * Test method for {@link fr.gsmp.plongee.nage.services.manager.impl.ParticipantsManagerImpl#getAllParticipantsByCategorie(fr.gsmp.plongee.nage.dao.data.Categorie)}.
	 */
	@Test
	public void testGetAllParticipantsByCategorie() {
		System.out.println("testGetAllParticipantsByCategorie");

		List<Participants> list = pm.getAllParticipantsByCategorie(catman.getCategorieById(2));
		for (Participants participants : list) {
			System.out.println(participants.getParticipantid()+"\t|"+participants.getParticipantnom()+" "+participants.getParticipantprenom()+"\t\t|"+participants.getParticipanttemps()+"\t|"+participants.getCourse().getCoursenom());
		}
	}

	/**
	 * Test method for {@link fr.gsmp.plongee.nage.services.manager.impl.ParticipantsManagerImpl#delete(fr.gsmp.plongee.nage.dao.data.Participants)}.
	 */
	@Test
	public void testDelete() {
		
	}

	/**
	 * Test method for {@link fr.gsmp.plongee.nage.services.manager.impl.ParticipantsManagerImpl#save(fr.gsmp.plongee.nage.dao.data.Participants)}.
	 */
	@Test
	public void testSave() {
		
	}

}
