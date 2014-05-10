/**
 * 
 */
package fr.gsmp.plongee.nage.services.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import fr.gsmp.plongee.nage.dao.data.Categorie;
import fr.gsmp.plongee.nage.dao.data.Categorieage;
import fr.gsmp.plongee.nage.dao.data.Course;
import fr.gsmp.plongee.nage.dao.data.Participants;
import fr.gsmp.plongee.nage.services.manager.ParticipantsManager;

/**
 * @author simon
 * 
 */
public class ParticipantsManagerImpl extends ManagerImpl implements
		ParticipantsManager {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.gsmp.plongee.nage.services.manager.ParticipantsManager#getParticipantById
	 * (java.lang.Integer)
	 */
	@Override
	public Participants getParticipantById(Integer participantid) {
		Criteria criteria = session.createCriteria(Participants.class);
		criteria.add(Restrictions.eq("participantid", participantid));
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return (Participants) criteria.uniqueResult();
	}

	public Participants getParticipantByTuba(Integer participantid) {
		Criteria criteria = session.createCriteria(Participants.class);
		criteria.add(Restrictions.eq("tubaNumber", participantid));
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return (Participants) criteria.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gsmp.plongee.nage.services.manager.ParticipantsManager#
	 * getParticipantByLicenceNumber(java.lang.String)
	 */
	@Override
	public Participants getParticipantByLicenceNumber(String licenceNumber) {
		Criteria criteria = session.createCriteria(Participants.class);
		criteria.add(Restrictions.eq("participantlicence", licenceNumber));
		criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return (Participants) criteria.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.gsmp.plongee.nage.services.manager.ParticipantsManager#getAllParticipants
	 * ()
	 */
	@Override
	public List<Participants> getAllParticipants() {
		session = SessionFactoryUtils.getSession(
				(SessionFactory) sessionFactory, true);
		Criteria criteria = session.createCriteria(Participants.class);
		List<Participants> list = new ArrayList<Participants>();
		List<Participants> l = criteria.list();
		for (Participants participants : l) {
			session.refresh(participants);
			list.add(participants);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gsmp.plongee.nage.services.manager.ParticipantsManager#
	 * getAllPArticipantsByCourse(fr.gsmp.plongee.nage.dao.data.Course)
	 */
	@Override
	public List<Participants> getAllPArticipantsByCourse(Course course) {
		Criteria criteria = session.createCriteria(Participants.class);
		criteria.add(Restrictions.eq("course", course));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gsmp.plongee.nage.services.manager.ParticipantsManager#
	 * getAllCompetParticipants()
	 */
	@Override
	public List<Participants> getAllCompetParticipants() {
		Criteria criteria = session.createCriteria(Participants.class);
		criteria.add(Restrictions.eq("participantcompet", true));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gsmp.plongee.nage.services.manager.ParticipantsManager#
	 * getAllLoisirParticipants()
	 */
	@Override
	public List<Participants> getAllLoisirParticipants() {
		Criteria criteria = session.createCriteria(Participants.class);
		criteria.add(Restrictions.eq("participantcompet", false));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gsmp.plongee.nage.services.manager.ParticipantsManager#
	 * getAllParticipantsByAgeCategorie
	 * (fr.gsmp.plongee.nage.dao.data.Categorieage)
	 */
	@Override
	public List<Participants> getAllParticipantsByAgeCategorie(
			Categorieage categorie) {
		Criteria criteria = session.createCriteria(Participants.class);
		criteria.add(Restrictions.eq("categorieage", categorie));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.gsmp.plongee.nage.services.manager.ParticipantsManager#
	 * getAllParticipantsByCategorie(fr.gsmp.plongee.nage.dao.data.Categorie)
	 */
	@Override
	public List<Participants> getAllParticipantsByCategorie(Categorie categorie) {
		Criteria criteria = session.createCriteria(Participants.class);
		criteria.add(Restrictions.eq("categorie", categorie));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.gsmp.plongee.nage.services.manager.ParticipantsManager#delete(fr.gsmp
	 * .plongee.nage.dao.data.Participants)
	 */
	@Override
	public void delete(Participants participant) {
		Transaction tx = session.beginTransaction();
		session.delete(participant);
		tx.commit();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.gsmp.plongee.nage.services.manager.ParticipantsManager#save(fr.gsmp
	 * .plongee.nage.dao.data.Participants)
	 */
	@Override
	public void save(Participants participant) {
		Transaction tx = session.beginTransaction();
		session.save(participant);
		tx.commit();
	}

	@Override
	public List<Participants> getAllParticipantByParams(Course course,
			Categorie equipement, Categorieage categorieAge, String sexe,
			Boolean compet) {
		
		List<Participants> liste = new ArrayList<Participants>();
		Criteria criteria = session.createCriteria(Participants.class);
		criteria.add(Restrictions.eq("course", course));
		if (equipement != null)
			criteria.add(Restrictions.eq("categorie", equipement));
		if (categorieAge != null)
			criteria.add(Restrictions.eq("categorieage", categorieAge));
		if (sexe != null && !sexe.isEmpty())
			criteria.add(Restrictions.eq("sexe", sexe));
		if (compet != null)
			criteria.add(Restrictions.eq("participantcompet", compet));
		criteria.add(Restrictions.isNotNull("participanttemps"));
		criteria.addOrder(Order.asc("participanttemps"));
		
		liste.addAll(criteria.list());
		criteria = session.createCriteria(Participants.class);
		criteria.add(Restrictions.eq("course", course));
		if (equipement != null)
			criteria.add(Restrictions.eq("categorie", equipement));
		if (categorieAge != null)
			criteria.add(Restrictions.eq("categorieage", categorieAge));
		if (sexe != null && !sexe.isEmpty())
			criteria.add(Restrictions.eq("sexe", sexe));
		if (compet != null)
			criteria.add(Restrictions.eq("participantcompet", compet));
		criteria.add(Restrictions.isNull("participanttemps"));		
		liste.addAll(criteria.list());
		
		
		return liste;
	}

}
