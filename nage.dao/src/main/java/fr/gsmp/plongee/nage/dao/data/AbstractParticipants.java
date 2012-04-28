package fr.gsmp.plongee.nage.dao.data;

import java.sql.Time;
import java.util.Date;

/**
 * AbstractParticipants entity provides the base persistence definition of the
 * Participants entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractParticipants implements java.io.Serializable {

	// Fields

	private Integer participantid;
	private Course course;
	private Categorieage categorieage;
	private Categorie categorie;
	private String participantnom;
	private String participantprenom;
	private Date participantdatenaissance;
	private String participantclub;
	private String participantlicence;
	private Boolean participantcompet;
	private Time participanttemps;
	private Integer tubaNumber;
	private String enapNumber;
	private String sexe;

	// Constructors

	/** default constructor */
	public AbstractParticipants() {
	}

	/** full constructor */
	public AbstractParticipants(Course course, Categorieage categorieage,
			Categorie categorie, String participantnom,
			String participantprenom, Date participantdatenaissance,
			String participantclub, String participantlicence,
			Boolean participantcompet, Time participanttemps) {
		this.course = course;
		this.categorieage = categorieage;
		this.categorie = categorie;
		this.participantnom = participantnom;
		this.participantprenom = participantprenom;
		this.participantdatenaissance = participantdatenaissance;
		this.participantclub = participantclub;
		this.participantlicence = participantlicence;
		this.participantcompet = participantcompet;
		this.participanttemps = participanttemps;
	}

	// Property accessors

	public Integer getParticipantid() {
		return this.participantid;
	}

	public void setParticipantid(Integer participantid) {
		this.participantid = participantid;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Categorieage getCategorieage() {
		return this.categorieage;
	}

	public void setCategorieage(Categorieage categorieage) {
		this.categorieage = categorieage;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getParticipantnom() {
		return this.participantnom;
	}

	public void setParticipantnom(String participantnom) {
		this.participantnom = participantnom;
	}

	public String getParticipantprenom() {
		return this.participantprenom;
	}

	public void setParticipantprenom(String participantprenom) {
		this.participantprenom = participantprenom;
	}

	public Date getParticipantdatenaissance() {
		return this.participantdatenaissance;
	}

	public void setParticipantdatenaissance(Date participantdatenaissance) {
		this.participantdatenaissance = participantdatenaissance;
	}

	public String getParticipantclub() {
		return this.participantclub;
	}

	public void setParticipantclub(String participantclub) {
		this.participantclub = participantclub;
	}

	public String getParticipantlicence() {
		return this.participantlicence;
	}

	public void setParticipantlicence(String participantlicence) {
		this.participantlicence = participantlicence;
	}

	public Boolean getParticipantcompet() {
		return this.participantcompet;
	}

	public void setParticipantcompet(Boolean participantcompet) {
		this.participantcompet = participantcompet;
	}

	public Time getParticipanttemps() {
		return this.participanttemps;
	}

	public void setParticipanttemps(Time participanttemps) {
		this.participanttemps = participanttemps;
	}

	/**
	 * @return the tubaNumber
	 */
	public Integer getTubaNumber() {
		return tubaNumber;
	}

	/**
	 * @param tubaNumber the tubaNumber to set
	 */
	public void setTubaNumber(Integer tubaNumber) {
		this.tubaNumber = tubaNumber;
	}

	/**
	 * @return the enapNumber
	 */
	public String getEnapNumber() {
		return enapNumber;
	}

	/**
	 * @param enapNumber the enapNumber to set
	 */
	public void setEnapNumber(String enapNumber) {
		this.enapNumber = enapNumber;
	}

	/**
	 * @return the sexe
	 */
	public String getSexe() {
		return sexe;
	}

	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

}