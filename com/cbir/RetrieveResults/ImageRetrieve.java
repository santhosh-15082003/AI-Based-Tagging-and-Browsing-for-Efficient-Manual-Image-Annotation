package com.cbir.RetrieveResults;

import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cbir.Design.JImagePanel;

public class ImageRetrieve implements ActionListener {

	JFrame qryfrm, zf;
	JPanel qpan, kpan, rpan, span, zpan;
	Container qcon;

	JButton but, zcl;

	ImageSearch is = new ImageSearch();
	SourceSearch ss = new SourceSearch();

	// ------ Kpan---------

	JLabel labl;
	JTextField keyt;
	JButton search, clear;

	// ------Rpan---------

	JLabel iml;
	List relist;
	JButton show, save;

	// ------vpan

	JPanel pict;
	JLabel fnam;
	JTextField fnt;
	JButton exit, zoom;

	public void Query_Window() {
		JFrame.setDefaultLookAndFeelDecorated(true);

		qryfrm = new JFrame("Image Search Engine");
		qcon = qryfrm.getContentPane();
		qcon.setLayout(null);

		qpan = new JPanel();
		qpan.setLayout(null);
		qpan.setBounds(0, 0, 800, 580);
		// qpan.setBackground(new Color(255,225,200));

		kpan = new JPanel();
		kpan.setLayout(null);
		kpan.setBounds(0, 0, 800, 205);
		// kpan.setBackground(new Color(255,225,200));
		kpan.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createLineBorder(Color.BLACK), "Search"));
		// kpan.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		rpan = new JPanel();
		rpan.setLayout(null);
		rpan.setBounds(0, 202, 378, 330);
		// rpan.setBackground(new Color(255,225,200));
		rpan.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createLineBorder(Color.BLACK), "Result"));
		// rpan.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		span = new JPanel();
		span.setLayout(null);
		span.setBounds(380, 202, 410, 330);
		// span.setBackground(new Color(255,225,200));
		span.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createLineBorder(Color.BLACK), "View"));

		// ---- Kpan----------------------------------

		labl = new JLabel("Image Retrievel");
		labl.setBounds(290, 30, 300, 30);
		labl.setFont(new Font(null, Font.TYPE1_FONT, 25));

		keyt = new JTextField();
		keyt.setBounds(160, 90, 420, 30);
		keyt.setOpaque(false);
		keyt.setForeground(Color.BLUE);
		// keyt.setBackground(new Color(255,225,200));

		keyt.setFont(new Font(null, Font.TRUETYPE_FONT, 16));

		search = new JButton("Search");
		search.setBounds(260, 140, 100, 25);
		search.addActionListener(this);

		clear = new JButton("Clear");
		clear.setBounds(400, 140, 100, 25);
		clear.addActionListener(this);

		kpan.add(labl);
		kpan.add(keyt);
		kpan.add(search);
		kpan.add(clear);

		// ------ rpan-----------------------------

		iml = new JLabel("Image Retrievel Result");
		iml.setFont(new Font(null, Font.BOLD, 14));
		iml.setBounds(20, 35, 150, 25);

		relist = new List();
		relist.setForeground(Color.RED);
		relist.setFont(new Font(null, Font.TRUETYPE_FONT, 14));
		// relist.setBackground(new Color(255,225,200));
		relist.setBounds(20, 70, 180, 220);

		show = new JButton("Show");
		show.setBounds(250, 120, 80, 25);
		show.addActionListener(this);

		save = new JButton("Save");
		save.setBounds(250, 200, 80, 25);
		save.addActionListener(this);

		rpan.add(iml);
		rpan.add(relist);
		rpan.add(save);
		rpan.add(show);

		// -------Vpan-------------------

		pict = new JPanel();
		pict.setBounds(50, 20, 310, 240);
		pict.setLayout(null);
		// pict.setBackground(new Color(255,225,200));
		pict.setBorder(BorderFactory.createTitledBorder(BorderFactory
				.createLineBorder(Color.BLACK), ""));

		fnt = new JTextField();
		fnt.setBounds(80, 220, 150, 15);
		fnt.setOpaque(false);
		// fnt.setBackground(new Color(255,225,200));
		fnt.setEditable(false);

		zoom = new JButton("ZOOM");
		zoom.setBounds(50, 280, 80, 25);
		zoom.addActionListener(this);

		exit = new JButton("EXIT");
		exit.setBounds(280, 280, 80, 25);
		exit.addActionListener(this);

		pict.add(fnt);

		span.add(pict);
		span.add(exit);
		span.add(zoom);

		qpan.add(kpan);
		qpan.add(rpan);
		qpan.add(span);

		qryfrm.add(qpan);
		qryfrm.setSize(800, 580);
		qryfrm.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == exit) {
			qryfrm.setVisible(false);

			// System.exit(0);
		}

		if (ae.getSource() == search) {

			System.out.println("Search Clicked");
			relist.removeAll();

			is.Search_Method(keyt.getText(), this);

		}
		if (ae.getSource() == clear) {

			System.out.println("Clear Button clicked");

			keyt.setText("");

		}

		if (ae.getSource() == show) {

			Show_Pic();

		}

		if (ae.getSource() == zoom) {

			System.out.println("Zoom Button clicked");
			Zoom_Pict();
		}

		if (ae.getSource() == zcl) {

			zf.setVisible(false);
		}

		if (ae.getSource() == save) {
			Save_Image();

		}

	}

	public void Show_Pic() {
		pict.removeAll();
		pict.add(fnt);
		qryfrm.repaint();

		String name = relist.getSelectedItem();

		if (name != null) {
			String pat = ss.SourceSearch_Method(name);
			if (pat != null) {
				System.out.println("Location To get ::::" + pat);

				try {
					File f = new File(pat);
					BufferedImage loa = ImageIO.read(f);

					JPanel imgpanel = new JImagePanel(loa, 0, 0, 290, 200);

					int ht = loa.getHeight();
					int wt = loa.getWidth();

					String da = "Dimension  : " + wt + " x " + ht;
					fnt.setText(da);

					imgpanel.setBounds(10, 10, 290, 200);
					pict.add(imgpanel);
					qryfrm.repaint();

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else
				JOptionPane.showMessageDialog(null, "Result not found !",
						"Oops !", JOptionPane.INFORMATION_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "No Item Selected !",
					"Error !", JOptionPane.ERROR_MESSAGE);

	}

	public void Zoom_Pict() {

		JFrame.setDefaultLookAndFeelDecorated(true);

		zf = new JFrame("Zoom");

		Container c = zf.getContentPane();
		c.setLayout(null);

		zpan = new JPanel();
		zpan.setLayout(null);

		zcl = new JButton("Close");
		zcl.addActionListener(this);

		String name = relist.getSelectedItem();

		if (name != null) {
			String pat = ss.SourceSearch_Method(name);
			if (pat != null) {
				System.out.println("Location To get ::::" + pat);

				try {
					File f = new File(pat);
					BufferedImage loa = ImageIO.read(f);

					int ht = loa.getHeight();
					int wt = loa.getWidth();
					if (ht > 525) {
						ht = 525;

					}

					if (wt > 700) {

						wt = 700;

					}

					JPanel imgpanel1 = new JImagePanel(loa, 0, 0, wt, ht);

					imgpanel1.setBounds(10, 10, wt, ht);

					zpan.setBounds(0, 0, (wt + 50), (ht + 80));

					zpan.add(imgpanel1);

					zcl.setBounds(wt - ((wt / 2) + 40), ht + 20, 80, 25);

					zpan.add(zcl);
					zf.add(zpan);
					zf.setSize((wt + 50), (ht + 80));
					zf.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else
				JOptionPane.showMessageDialog(null, "Result not found !",
						"Oops !", JOptionPane.INFORMATION_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "No Item Selected !",
					"Error !", JOptionPane.ERROR_MESSAGE);

	}

	public void Save_Image() {

		String name = relist.getSelectedItem();

		if (name != null) {
			String pat = ss.SourceSearch_Method(name);
			if (pat != null) {
				System.out.println("Location To get ::::" + pat);

				try {
					File f = new File(pat);
					BufferedImage loa = ImageIO.read(f);

					FileDialog fd = new FileDialog(qryfrm, "Save File",
							FileDialog.SAVE);
					fd.setFile("image1.jpg");
					fd.setVisible(true);

					File f1 = new File(fd.getDirectory(), fd.getFile());

					boolean flag = ImageIO.write(loa, "jpg", f1);

					if (flag)
						JOptionPane.showMessageDialog(null, "Image Saved !",
								"Hurey !", JOptionPane.INFORMATION_MESSAGE);

					else
						JOptionPane.showMessageDialog(null, "Error Occured !",
								"Oops !", JOptionPane.ERROR_MESSAGE);

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else
				JOptionPane.showMessageDialog(null,
						"Result not found for selected item !", "Oops !",
						JOptionPane.INFORMATION_MESSAGE);
		} else
			JOptionPane.showMessageDialog(null, "No Item Selected !",
					"Error !", JOptionPane.ERROR_MESSAGE);

	}

	/*
	 * public static void main(String args[]) {
	 * 
	 * ImageRetrieve ir=new ImageRetrieve(); ir.Query_Window();
	 * 
	 * 
	 * }
	 */
}