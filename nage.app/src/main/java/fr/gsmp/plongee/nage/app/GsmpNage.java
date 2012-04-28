/*
 * GsmpNage.java
 *
 * Created on __DATE__, __TIME__
 */

package fr.gsmp.plongee.nage.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gsmp.plongee.nage.app.models.ParticipantsModel;
import fr.gsmp.plongee.nage.dao.data.Participants;
import fr.gsmp.plongee.nage.gui.DisplayResultat;
import fr.gsmp.plongee.nage.gui.ParticipantForm;
import fr.gsmp.plongee.nage.gui.SaisieTemps;
import fr.gsmp.plongee.nage.services.manager.ParticipantsManager;

/**
 * 
 * @author __USER__
 */
public class GsmpNage extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5010157986151346400L;
	private ParticipantsManager pm;
	List<Participants> participants;
	private ParticipantsModel modele;

	private JFrame popup;

	/** Creates new form GsmpNage */
	public GsmpNage() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextServices.xml");

		pm = (ParticipantsManager) ctx.getBean("participantsManagerImpl");
		loadParticipants();
		initComponents();

	}

	private void loadParticipants() {
		participants = null;
		participants = pm.getAllParticipants();
		modele = new ParticipantsModel();
		modele.setParticipants(participants);
		if (participantTable != null)
			participantTable.setModel(modele);


	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		participantTable = new javax.swing.JTable();
		menuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		openMenuItem = new javax.swing.JMenuItem();
		saveMenuItem = new javax.swing.JMenuItem();
		saveAsMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		participantMenu = new javax.swing.JMenu();
		addParticipantMenuItem = new javax.swing.JMenuItem();
		courseMenu = new javax.swing.JMenu();
		saisieMenuItem = new javax.swing.JMenuItem();
		voirMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		
		participantTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				participantTableMouseClicked(evt);
			}
		});
		
		participantTable.setModel(modele);
		
		jScrollPane1.setViewportView(participantTable);

		fileMenu.setText("File");

		openMenuItem.setText("Open");
		fileMenu.add(openMenuItem);

		saveMenuItem.setText("Save");
		fileMenu.add(saveMenuItem);

		saveAsMenuItem.setText("Save As ...");
		fileMenu.add(saveAsMenuItem);

		exitMenuItem.setText("Exit");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		participantMenu.setText("Particpants");

		addParticipantMenuItem.setText("Ajouter un participant");
		addParticipantMenuItem
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						addParticipantMenuItemActionPerformed(evt);
					}
				});
		participantMenu.add(addParticipantMenuItem);

		menuBar.add(participantMenu);

		courseMenu.setText("Course");

		saisieMenuItem.setText("Saisie des r\u00e9sultats");
		saisieMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saisieMenuItemActionPerformed(evt);
			}
		});
		courseMenu.add(saisieMenuItem);

		voirMenuItem.setText("Voir les r\u00e9sultats");
		voirMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				voirMenuItemActionPerformed(evt);
			}
		});
		courseMenu.add(voirMenuItem);

		menuBar.add(courseMenu);

		setJMenuBar(menuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 788,
								Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(22, 22, 22)
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 527,
								Short.MAX_VALUE).addGap(30, 30, 30)));

		pack();
	}// </editor-fold>
		// GEN-END:initComponents

	private void voirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		DisplayResultat dr = new DisplayResultat(this, true);
		dr.setVisible(true);
	}

	private void saisieMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		SaisieTemps st = new SaisieTemps(this, true);
		st.setVisible(true);
	}

	private void addParticipantMenuItemActionPerformed(ActionEvent evt) {
		ParticipantForm participantForm = new ParticipantForm(this, true);

		participantForm.setTitle("Ajouter un participant");

		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadParticipants();
				participantTable.setModel(modele);

			}
		};
		participantForm.addActionListener(l);
		participantForm.setVisible(true);

	}

	private void participantTableMouseClicked(java.awt.event.MouseEvent evt) {
		Participants participant = participants.get(participantTable
				.getSelectedRow());
		
		
		ParticipantForm participantForm = new ParticipantForm(this, true);

		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				loadParticipants();
				participantTable.setModel(modele);
			}
		};
		participantForm.addActionListener(l);
		participantForm.setTitle(participant.getParticipantnom() + " "
				+ participant.getParticipantprenom());
		participantForm.setParticipant(participant);

		participantForm.setVisible(true);

	}

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitMenuItemActionPerformed
		System.exit(0);
	}// GEN-LAST:event_exitMenuItemActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GsmpNage().setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JMenuItem addParticipantMenuItem;
	private javax.swing.JMenu courseMenu;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenuItem openMenuItem;
	private javax.swing.JMenu participantMenu;
	private javax.swing.JTable participantTable;
	private javax.swing.JMenuItem saisieMenuItem;
	private javax.swing.JMenuItem saveAsMenuItem;
	private javax.swing.JMenuItem saveMenuItem;
	private javax.swing.JMenuItem voirMenuItem;
	// End of variables declaration//GEN-END:variables

}