/**
 * 
 */
package fr.gsmp.plongee.nage.services.manager;

import java.util.List;

import fr.gsmp.plongee.nage.dao.data.Categorie;
import fr.gsmp.plongee.nage.dao.data.Categorieage;
import fr.gsmp.plongee.nage.dao.data.Course;
import fr.gsmp.plongee.nage.dao.data.Participants;

/**
 * @author simon
 * 
 */
public interface ParticipantsManager {
	/**
	 * 
	 * @param participantid
	 * @return
	 */
	Participants getParticipantById(Integer participantid);

	/**
	 * 
	 * @param licenceNumber
	 * @return
	 */
	Participants getParticipantByLicenceNumber(String licenceNumber);
	
	/**
	 * 
	 * @param participantid
	 * @return
	 */
	Participants getParticipantByTuba(Integer tubanumber);

	/**
	 * Participants getParticipantByTubaNumber(Integer licenceNumber);
	 * 
	 * @return
	 */
	List<Participants> getAllParticipants();

	/**
	 * 
	 * @param course
	 * @return
	 */
	List<Participants> getAllPArticipantsByCourse(Course course);

	/**
	 * 
	 * @return
	 */
	List<Participants> getAllCompetParticipants();

	/**
	 * 
	 * @return
	 */
	List<Participants> getAllLoisirParticipants();

	/**
	 * 
	 * @param categorie
	 * @return
	 */
	List<Participants> getAllParticipantsByAgeCategorie(Categorieage categorie);

	/**
	 * 
	 * @param categorie
	 * @return
	 */
	List<Participants> getAllParticipantsByCategorie(Categorie categorie);

	/**
	 * 
	 * @param participant
	 */
	void delete(Participants participant);

	/**
	 * 
	 * @param participant
	 */
	void save(Participants participant);

	/**
	 * 
	 * @param course
	 * @param equipement
	 * @param categorieAge
	 * @return
	 */
	List<Participants> getAllParticipantByParams(Course course,
			Categorie equipement, Categorieage categorieAge, String sexe, Boolean compet);
}
