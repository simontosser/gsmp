package fr.gsmp.plongee.nage.dao.data;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

/**
 * Participants entity. @author MyEclipse Persistence Tools
 */
public class Participants extends AbstractParticipants implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Participants() {
	}

	/** minimal constructor */
	public Participants(Course course, Categorieage categorieage,
			Categorie categorie, String participantnom,
			String participantprenom, Date participantdatenaissance,
			String participantclub, String participantlicence,
			Boolean participantcompet, Time participanttemps){
		super(course, categorieage,
				categorie, participantnom,
				participantprenom, participantdatenaissance, participantclub,
				participantlicence, participantcompet, participanttemps);
	}

	/** full constructor */
/*	public Participants(Course course,
			Participants participantsByParticipantcategorie,
			Participants participantsByParticipantcategorieage,
			String participantnom, String participantprenom,
			Date participantdatenaissance, String participantclub,
			String participantlicence, Boolean participantcompet,
			Time participanttemps,
			Set participantsesForParticipantcategorieage,
			Set participantsesForParticipantcategorie) {
		super(course, participantsByParticipantcategorie,
				participantsByParticipantcategorieage, participantnom,
				participantprenom, participantdatenaissance, participantclub,
				participantlicence, participantcompet, participanttemps,
				participantsesForParticipantcategorieage,
				participantsesForParticipantcategorie);
	}*/

}
