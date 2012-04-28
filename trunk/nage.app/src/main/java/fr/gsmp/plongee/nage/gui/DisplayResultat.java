/*
 * DisplayResultat.java
 *
 * Created on __DATE__, __TIME__
 */

package fr.gsmp.plongee.nage.gui;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gsmp.plongee.nage.app.models.ResultParticipantsModel;
import fr.gsmp.plongee.nage.dao.data.Categorie;
import fr.gsmp.plongee.nage.dao.data.Categorieage;
import fr.gsmp.plongee.nage.dao.data.Course;
import fr.gsmp.plongee.nage.dao.data.Participants;
import fr.gsmp.plongee.nage.services.manager.CategorieAgeManager;
import fr.gsmp.plongee.nage.services.manager.CategorieManager;
import fr.gsmp.plongee.nage.services.manager.CourseManager;
import fr.gsmp.plongee.nage.services.manager.ParticipantsManager;

/**
 * 
 * @author __USER__
 */
public class DisplayResultat extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8668349425005570425L;
	private CourseManager cm;
	private CategorieManager catm;
	private CategorieAgeManager catagem;
	private ParticipantsManager pm;
	private List<Participants> listP = new ArrayList<Participants>();

	/**
	 * @return the cm
	 */
	public CourseManager getCm() {
		return cm;
	}

	/**
	 * @param cm
	 *            the cm to set
	 */
	public void setCm(CourseManager cm) {
		this.cm = cm;
	}

	/**
	 * @return the catm
	 */
	public CategorieManager getCatm() {
		return catm;
	}

	/**
	 * @param catm
	 *            the catm to set
	 */
	public void setCatm(CategorieManager catm) {
		this.catm = catm;
	}

	/**
	 * @return the catagem
	 */
	public CategorieAgeManager getCatagem() {
		return catagem;
	}

	/**
	 * @param catagem
	 *            the catagem to set
	 */
	public void setCatagem(CategorieAgeManager catagem) {
		this.catagem = catagem;
	}

	/**
	 * @return the pm
	 */
	public ParticipantsManager getPm() {
		return pm;
	}

	/**
	 * @param pm
	 *            the pm to set
	 */
	public void setPm(ParticipantsManager pm) {
		this.pm = pm;
	}

	/**
	 * @return the categorieComboBox
	 */
	public javax.swing.JComboBox getCategorieComboBox() {
		return categorieComboBox;
	}

	/**
	 * @param categorieComboBox
	 *            the categorieComboBox to set
	 */
	public void setCategorieComboBox(javax.swing.JComboBox categorieComboBox) {
		this.categorieComboBox = categorieComboBox;
	}

	/**
	 * @return the categorieLabel
	 */
	public javax.swing.JLabel getCategorieLabel() {
		return categorieLabel;
	}

	/**
	 * @param categorieLabel
	 *            the categorieLabel to set
	 */
	public void setCategorieLabel(javax.swing.JLabel categorieLabel) {
		this.categorieLabel = categorieLabel;
	}

	/** Creates new form DisplayResultat */
	public DisplayResultat(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextServices.xml");

		cm = (CourseManager) ctx.getBean("courseManagerImpl");
		catm = (CategorieManager) ctx.getBean("categorieManagerImpl");
		catagem = (CategorieAgeManager) ctx.getBean("categorieAgeManagerImpl");
		pm = (ParticipantsManager) ctx.getBean("participantsManagerImpl");
		initComponents();
	}

	private void loadResult() {
		
		Boolean compet = null;
		if( sexeComboBox1.getSelectedItem()!=null &&  sexeComboBox1.getSelectedItem().equals("oui"))
			compet =true;
		else if( sexeComboBox1.getSelectedItem()!=null &&  sexeComboBox1.getSelectedItem().equals("non"))
			compet = false;
		listP = pm.getAllParticipantByParams(
				(Course) courseComboBox.getSelectedItem(),
				(Categorie) equipementComboBox.getSelectedItem(),
				(Categorieage) categorieComboBox.getSelectedItem(),
				(String) sexeComboBox.getSelectedItem(), compet);
		pm.getAllPArticipantsByCourse((Course) courseComboBox.getSelectedItem());
		ResultParticipantsModel pmodel = new ResultParticipantsModel();
		pmodel.setParticipants(listP);
		tableau.setModel(pmodel);

	}

	private void loadComboBox() {
		equipementComboBox.addItem(null);
		categorieComboBox.addItem(null);
		courseComboBox.addItem(null);
		for (Categorie categorie : catm.getAllCategorie())
			equipementComboBox.addItem(categorie);
		for (Categorieage categorie : catagem.getAllCategorieage())
			categorieComboBox.addItem(categorie);
		for (Course categorie : cm.getAllCourses())
			courseComboBox.addItem(categorie);

	}

	// GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		courseLabel = new javax.swing.JLabel();
		courseComboBox = new javax.swing.JComboBox();
		categorieLabel = new javax.swing.JLabel();
		categorieComboBox = new javax.swing.JComboBox();
		equipementLabel = new javax.swing.JLabel();
		equipementComboBox = new javax.swing.JComboBox();
		sexeLabel = new javax.swing.JLabel();
		sexeComboBox = new javax.swing.JComboBox();
		sexeLabel1 = new javax.swing.JLabel();
		sexeComboBox1 = new javax.swing.JComboBox();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableau = new javax.swing.JTable();
		pdfButton = new JButton();
		excelButton = new JButton();

		pdfButton.setText("Export PDF");
		excelButton.setText("Export Excel");

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridLayout(5, 0));

		courseLabel.setText("Course :");

		courseComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				courseComboBoxActionPerformed(evt);
			}
		});

		categorieLabel.setText("Categorie :");

		categorieComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						categorieComboBoxActionPerformed(evt);
					}
				});

		equipementLabel.setText("\u00c9quipement :");

		equipementComboBox
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						equipementComboBoxActionPerformed(evt);
					}
				});

		sexeLabel.setText("Sexe :");

		sexeComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { null, "Homme", "Femme" }));
		sexeComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sexeComboBoxActionPerformed(evt);
			}
		});

		sexeLabel1.setText("Compet :");

		sexeComboBox1.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { null, "oui", "non" }));
		sexeComboBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sexeComboBox1ActionPerformed(evt);
			}
		});
		loadComboBox();


		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 400, Short.MAX_VALUE)
						.addGroup(
								jPanel1Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel1Layout
														.createSequentialGroup()
														.addGap(0, 0,
																Short.MAX_VALUE)
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								courseLabel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								200,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								courseComboBox,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								200,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								categorieLabel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								200,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								categorieComboBox,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								200,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								equipementLabel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								200,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								equipementComboBox,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								200,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								sexeLabel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								200,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								sexeComboBox,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								200,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addComponent(
																				sexeLabel1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				200,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addGap(200,
																								200,
																								200)
																						.addComponent(
																								sexeComboBox1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								200,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGap(0, 0,
																Short.MAX_VALUE))));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGap(0, 306, Short.MAX_VALUE)
						.addGroup(
								jPanel1Layout
										.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												jPanel1Layout
														.createSequentialGroup()
														.addGap(0, 0,
																Short.MAX_VALUE)
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(
																				courseLabel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				30,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				courseComboBox,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				30,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(
																				categorieLabel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				30,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				categorieComboBox,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				30,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(
																				equipementLabel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				30,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				equipementComboBox,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				30,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								sexeLabel,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								30,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(
																								sexeLabel1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								30,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								sexeComboBox,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								30,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(
																								sexeComboBox1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								30,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGap(0, 0,
																Short.MAX_VALUE))));

		getContentPane().add(jPanel1);

		tableau.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(tableau);

		getContentPane().add(jScrollPane1);
		getContentPane().add(excelButton);
		getContentPane().add(pdfButton);

		excelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				excelButtonActionPerformed(evt);
			}

			private void excelButtonActionPerformed(ActionEvent evt) {
				try {
					final JRXlsExporter exporter = new JRXlsExporter();
					
					exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.TRUE);
					exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
					exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
					exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
					exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.FALSE);
					exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
					exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.TRUE);
					
					
					String templateFile = "result.jrxml";
					String jasperFile = "result.jasper";
					JasperCompileManager.compileReportToFile(templateFile,
							jasperFile);
					FileInputStream inputStream = new FileInputStream(
							"result.jasper");
					final SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyyMMdd-HHmm");
					final String suffix = sdf.format(new Date());
					final File out = new File("resultat-" + suffix + ".xls");
					final HashMap params = new HashMap();
					params.put("course", courseComboBox.getSelectedItem()
							.toString());
					if (equipementComboBox.getSelectedItem() != null)
						params.put("equipement", equipementComboBox
								.getSelectedItem().toString());
					else
						params.put("equipement","");
					if (sexeComboBox.getSelectedItem() != null)
						params.put("sexe", sexeComboBox.getSelectedItem()
								.toString());
					else
						params.put("sexe","");
					if (categorieComboBox.getSelectedItem() != null)
						params.put("categorie", categorieComboBox
								.getSelectedItem().toString());
					else
						params.put("categorie","");
					final ArrayList jasperPrintList = new ArrayList();
					jasperPrintList.add(JasperFillManager.fillReport(
							inputStream, params,
							new JRBeanCollectionDataSource(listP)));
					exporter.setParameter(
							JRExporterParameter.JASPER_PRINT_LIST,
							jasperPrintList);
					exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
							out.getAbsolutePath());
					exporter.exportReport();

					java.awt.Desktop.getDesktop().open(out);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		pdfButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				pdfButtonActionPerformed(evt);
			}

			private void pdfButtonActionPerformed(ActionEvent evt) {
				try {
					final JRPdfExporter exporter = new JRPdfExporter();
					String templateFile = "result.jrxml";
					String jasperFile = "result.jasper";
					JasperCompileManager.compileReportToFile(templateFile,
							jasperFile);
					FileInputStream inputStream = new FileInputStream(
							"result.jasper");
					final SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyyMMdd-HHmm");
					final String suffix = sdf.format(new Date());
					final File out = new File("resultat-" + suffix + ".pdf");
					final HashMap params = new HashMap();
					params.put("course", courseComboBox.getSelectedItem()
							.toString());
					if (equipementComboBox.getSelectedItem() != null)
						params.put("equipement", equipementComboBox
								.getSelectedItem().toString());
					else
						params.put("equipement","");
					if (sexeComboBox.getSelectedItem() != null)
						params.put("sexe", sexeComboBox.getSelectedItem()
								.toString());
					else
						params.put("sexe","");
					if (categorieComboBox.getSelectedItem() != null)
						params.put("categorie", categorieComboBox
								.getSelectedItem().toString());
					else
						params.put("categorie","");
					final ArrayList jasperPrintList = new ArrayList();
					jasperPrintList.add(JasperFillManager.fillReport(
							inputStream, params,
							new JRBeanCollectionDataSource(listP)));
					exporter.setParameter(
							JRExporterParameter.JASPER_PRINT_LIST,
							jasperPrintList);
					exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
							out.getAbsolutePath());
					exporter.exportReport();

					java.awt.Desktop.getDesktop().open(out);
					

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		loadResult();
		pack();
	}// </editor-fold>
		// GEN-END:initComponents
	
	
	

	private void sexeComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		this.loadResult();
	}

	private void equipementComboBoxActionPerformed(
			java.awt.event.ActionEvent evt) {
		this.loadResult();
	}

	private void sexeComboBoxActionPerformed(ActionEvent evt) {
		this.loadResult();

	}

	private void categorieComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
		this.loadResult();
	}

	private void courseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
		this.loadResult();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				DisplayResultat dialog = new DisplayResultat(
						new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	// GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JComboBox categorieComboBox;
	private javax.swing.JLabel categorieLabel;
	private javax.swing.JComboBox courseComboBox;
	private javax.swing.JLabel courseLabel;
	private javax.swing.JComboBox equipementComboBox;
	private javax.swing.JLabel equipementLabel;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable tableau;
	private javax.swing.JComboBox sexeComboBox;
	private javax.swing.JComboBox sexeComboBox1;
	private javax.swing.JLabel sexeLabel;
	private javax.swing.JLabel sexeLabel1;
	private JButton pdfButton;
	private JButton excelButton;
	// End of variables declaration//GEN-END:variables

}