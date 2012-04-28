/**
 * 
 */
package fr.gsmp.plongee.nage.app.models;

import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.gsmp.plongee.nage.dao.data.Participants;

/**
 * @author simon
 * 
 */
public class ResultParticipantsModel extends AbstractTableModel {

	private List<Participants> participants;

	public ResultParticipantsModel() {
		super();
	}

	private final String[] entetes = { "Nom", "Prénom", "Temps", "Club",
			"COmpet", "Equipement","Categorie age","Sexe","Numéro tuba" };

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return participants.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return entetes.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			// Nom
			return participants.get(rowIndex).getParticipantnom();

		case 1:
			// Prenom
			return participants.get(rowIndex).getParticipantprenom();

		case 2:
			// Annee
			return participants.get(rowIndex).getParticipanttemps();

		case 3:
			// Club
			return participants.get(rowIndex).getParticipantclub();

		case 4:
			// Licence
			return participants.get(rowIndex).getParticipantcompet();
		case 5:
			return participants.get(rowIndex).getCategorie();
		case 6:
			return participants.get(rowIndex).getCategorieage();
		case 7:
			return participants.get(rowIndex).getSexe();
		case 8:
			return participants.get(rowIndex).getTubaNumber();
			
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 2:
		case 0:
		case 1:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
			return String.class;

		default:
			return Object.class;
		}
	}

	/**
	 * @return the participants
	 */
	public List<Participants> getParticipants() {
		return participants;
	}

	/**
	 * @param participants
	 *            the participants to set
	 */
	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}

}
