package com.cbir.Design;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.SubstanceLookAndFeel;

import com.cbir.RetrieveResults.ImageRetrieve;
import com.cbir.SVMFeatureAggregation.FeatureAggregation;
import com.cbir.SVMTraining.TrainingProcess;

public class SVMHome implements ActionListener {

	JFrame main, login;
	JPanel logPan;

	Connection connect = null;
	Statement st = null;
	ResultSet rs = null;

	// --selection page------

	JFrame Fslct;
	JPanel Pslct;
	JLabel title;
	JRadioButton train, anno, qryprs, cngpas;
	JButton go, can;

	// === User Access

	JFrame usraccess;
	JPanel usPan;
	Container conusr;

	JLabel lold, lnew, lnewusr, lhead;
	JPasswordField Told, Tnew, Tnewpas;

	JButton pasok, pascan, createusr;

	DataBase db = new DataBase();
	FeatureAggregation an = new FeatureAggregation();
	ImageRetrieve ir = new ImageRetrieve();
	TrainingProcess tp = new TrainingProcess();

	public void Selection_Event() {
		JFrame.setDefaultLookAndFeelDecorated(true);

		Fslct = new JFrame();
		Container selectcon = Fslct.getContentPane();
		selectcon.setLayout(null);
		// selectcon.setBackground(new Color(36,41,45));

		Pslct = new JPanel();
		Pslct.setLayout(null);
		// Pslct.setBackground(new Color(36,41,45));

		title = new JLabel("AI BASED IMAGE ANNOTATION");
		title.setBounds(100, 20, 350, 25);
		// title.setForeground(Color.ORANGE);
		title.setFont(new Font(null, Font.HANGING_BASELINE, 20));

		train = new JRadioButton(" Image Training ");
		train.setBounds(150, 100, 200, 25);
		// train.setForeground(Color.RED);
		// train.setBackground(new Color(36,41,45));
		train.setFont(new Font(null, Font.TRUETYPE_FONT, 15));

		anno = new JRadioButton("Multilabelled ANNOTATION");
		anno.setBounds(150, 150, 200, 40);
		// anno.setForeground(Color.RED);
		// anno.setBackground(new Color(36,41,45));
		anno.setFont(new Font(null, Font.TRUETYPE_FONT, 15));

		qryprs = new JRadioButton(" Multilabelled RS Search Engine ");
		qryprs.setBounds(150, 200, 250, 40);
		// qryprs.setForeground(Color.RED);
		// qryprs.setBackground(new Color(36,41,45));
		qryprs.setFont(new Font(null, Font.TRUETYPE_FONT, 15));

		ButtonGroup bg5 = new ButtonGroup();

		bg5.add(train);
		bg5.add(anno);
		bg5.add(qryprs);
		bg5.add(cngpas);

		go = new JButton("Select");
		go.setBounds(100, 350, 100, 25);
		go.addActionListener(this);

		can = new JButton(" Cancel ");
		can.setBounds(300, 350, 100, 25);
		can.addActionListener(this);

		Pslct.add(title);
		Pslct.add(anno);
		Pslct.add(train);
		Pslct.add(qryprs);
		Pslct.add(go);
		Pslct.add(can);

		Pslct.setBounds(0, 0, 500, 500);
		Fslct.add(Pslct);
		Fslct.setSize(500, 500);
		Fslct.setTitle("IMAGE ANNOTATION::");
		Fslct.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == go) {

			if (train.isSelected()) {

				tp.Training_Window();

			}

			if (anno.isSelected()) {

				an.Annotate_Window();

			}

			if (qryprs.isSelected()) {

				ir.Query_Window();

			}

		}
		if (ae.getSource() == pascan) {
			System.exit(0);
		}

		if (ae.getSource() == can) {
			System.exit(0);
		}

	}

	public static void main(String agr[]) {

JFrame.setDefaultLookAndFeelDecorated(true);
		
		SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBarbyPinkTheme");
        SubstanceLookAndFeel.setCurrentButtonShaper("org.jvnet.substance.button.StandardButtonShaper");
		SubstanceLookAndFeel.setCurrentGradientPainter("SpecularGradientPainter");
		try {
            UIManager.setLookAndFeel(new SubstanceLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
          
            e.printStackTrace();
        }
		new SVMHome().Selection_Event();

	}

}