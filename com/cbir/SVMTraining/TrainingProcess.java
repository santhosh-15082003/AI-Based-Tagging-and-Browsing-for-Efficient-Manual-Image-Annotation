package com.cbir.SVMTraining;

import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.cbir.Design.JImagePanel;

//import com.incors.plaf.alloy.AlloyLookAndFeel;

public class TrainingProcess implements ActionListener {
	JFrame train, split;

	Container tcon, scon;

	JPanel trPan, spPan, frapan;

	BufferedImage buf[];

	File f;

	int no1;

	int frnum = 0;

	int subht;

	int subwd;

	String data = "";

	String fnam = "";

	int redavg = 0;

	int gravg = 0;

	int bluavg = 0;

	DataStorage ds = new DataStorage();

	//--Training

	JButton open, exit, prev, next, ok, load, refr;

	JPanel botP, rsP, lsbot, lsup, mid, pic;

	JPanel p1[];

	JLabel l[];

	JLabel rl, gl, bl, fn, label, filena, listl;

	JTextField rt, gt, bt, fnt, labt, filet;

	List list;

	// Split---

	JButton spexit, spl;

	JTextArea detail;

	public void Training_Window() {

		JFrame.setDefaultLookAndFeelDecorated(true);

		

		//-----------------------------------------------------------

		train = new JFrame("Taining");
		tcon = train.getContentPane();
		tcon.setLayout(null);

		trPan = new JPanel();
		trPan.setLayout(null);
		//trPan.setBackground(new Color(255,225,200));
		trPan.setBounds(0, 0, 750, 550);

		botP = new JPanel();
		botP.setLayout(null);
		botP.setBounds(250, 455, 500, 60);
		//botP.setBackground(new Color(255,225,200));
		botP.setBorder(BorderFactory.createTitledBorder(""));

		lsbot = new JPanel();
		lsbot.setLayout(null);
		lsbot.setBounds(0, 300, 248, 220);
		//lsbot.setBackground(new Color(255,225,200));
		lsbot.setBorder(BorderFactory.createTitledBorder(""));

		lsup = new JPanel();
		lsup.setLayout(null);
		lsup.setBounds(0, 0, 248, 298);
		//lsup.setBackground(new Color(255,225,200));
		lsup.setBorder(BorderFactory.createTitledBorder(""));

		mid = new JPanel();
		mid.setLayout(null);
		mid.setBounds(250, 0, 500, 452);
		//mid.setBackground(new Color(255,225,200));
		mid.setBorder(BorderFactory.createTitledBorder(""));

		pic = new JPanel();
		pic.setLayout(null);
		pic.setBounds(150, 50, 200, 200);
		//pic.setBackground(new Color(255,225,200));
		pic.setBorder(BorderFactory.createTitledBorder(""));

		//---lsUP----------------------------

		listl = new JLabel("Labels List :");
		listl.setBounds(20, 70, 80, 20);

		list = new List();
		list.setBounds(50, 100, 120, 150);
		//list.setBackground(new Color(255,225,200));

		filena = new JLabel("File Name");
		filena.setBounds(20, 20, 60, 20);

		filet = new JTextField();
		filet.setOpaque(false);
		filet.setBounds(90, 20, 120, 20);
		filet.setEditable(false);

		load = new JButton("LOAD");
		load.setBounds(70, 265, 80, 25);
		load.addActionListener(this);

		lsup.add(listl);
		lsup.add(list);
		lsup.add(filena);
		lsup.add(filet);
		lsup.add(load);

		//----botP Panel---------------------

		open = new JButton("Open");
		open.setBounds(20, 20, 80, 25);
		open.addActionListener(this);

		refr = new JButton("Refresh");
		refr.setBounds(110, 20, 80, 25);
		refr.addActionListener(this);

		prev = new JButton("<< Prev");
		prev.setBounds(200, 20, 80, 25);
		prev.addActionListener(this);
		prev.setEnabled(false);

		next = new JButton("Next >>");
		next.setBounds(290, 20, 80, 25);
		next.addActionListener(this);
		next.setEnabled(false);

		exit = new JButton("Exit");
		exit.setBounds(380, 20, 80, 25);
		exit.addActionListener(this);

		//----mid Panel-----------------------------

		label = new JLabel("Image Label");
		label.setBounds(50, 300, 80, 20);

		labt = new JTextField();
		labt.setOpaque(false);
		labt.setBounds(140, 300, 150, 20);

		ok = new JButton("OK");
		ok.setBounds(310, 300, 80, 20);
		ok.addActionListener(this);

		fn = new JLabel("Frame No:");
		fn.setBounds(30, 50, 60, 20);

		fnt = new JTextField();
		fnt.setOpaque(false);
		fnt.setBounds(100, 50, 30, 20);
		fnt.setEditable(false);

		rl = new JLabel("RED");
		rl.setBounds(50, 420, 40, 20);

		rt = new JTextField();
		rt.setOpaque(false);
		rt.setBounds(90, 420, 50, 20);
		rt.setEditable(false);

		gl = new JLabel("GREEN");
		gl.setBounds(200, 420, 50, 20);

		gt = new JTextField();
		gt.setOpaque(false);
		gt.setBounds(250, 420, 50, 20);
		gt.setEditable(false);

		bl = new JLabel("BLUE");
		bl.setBounds(370, 420, 40, 20);

		bt = new JTextField();
		bt.setOpaque(false);
		bt.setBounds(410, 420, 50, 20);
		bt.setEditable(false);

		mid.add(fn);
		mid.add(fnt);
		mid.add(rl);
		mid.add(rt);
		mid.add(gl);
		mid.add(gt);
		mid.add(bl);
		mid.add(bt);
		mid.add(label);
		mid.add(labt);
		mid.add(ok);

		mid.add(pic);

		botP.add(open);
		botP.add(exit);
		botP.add(prev);
		botP.add(next);
		botP.add(refr);

		train.add(botP);
		train.add(lsup);
		train.add(mid);
		train.add(lsbot);
		train.add(trPan);

		train.setSize(750, 550);
		train.setVisible(true);

	}

	public void SplitImage_Window() {

		JFrame.setDefaultLookAndFeelDecorated(true);

		split = new JFrame("Split");
		scon = split.getContentPane();
		scon.setLayout(null);

		spPan = new JPanel();
		spPan.setLayout(null);
		spPan.setBounds(0, 0, 800, 600);

		detail = new JTextArea();
		detail.setBounds(230, 10, 250, 100);
		detail.setEditable(false);

		spl = new JButton("Split");
		spl.setBounds(520, 50, 100, 25);
		spl.addActionListener(this);

		spexit = new JButton("Exit");
		spexit.setBounds(660, 50, 100, 25);
		spexit.addActionListener(this);

		spPan.add(detail);
		spPan.add(spl);
		//spPan.add(spexit);

		split.add(spPan);
		split.setSize(800, 600);
		split.setVisible(true);

	}

	public void OpenImage() {

		try {

			FileDialog fd = new FileDialog(train, "Open Image", FileDialog.LOAD);
			fd.setVisible(true);

			String fff = fd.getDirectory();
			if (fff != null) {

				String ff = fd.getFile();

				System.out.println("Selected File ::" + ff);

				StringTokenizer stok = new StringTokenizer(ff, ".");
				stok.nextToken();
				String extn = stok.nextToken();

				if (extn.equalsIgnoreCase("bmp")
						|| extn.equalsIgnoreCase("jpg")
						|| extn.equalsIgnoreCase("png")
						|| extn.equalsIgnoreCase("gif")) {

					f = new File(fd.getDirectory(), fd.getFile());

					System.out.println(" Image File :" + f);

					BufferedImage loadImg = ImageIO.read(f);

					JPanel panel = new JImagePanel(loadImg, 0, 0, 150, 100);

					fnam = fd.getFile();

					StringTokenizer st = new StringTokenizer(fnam, ".");
					st.nextToken();
					String type = st.nextToken();

					int ht = loadImg.getHeight();
					int wd = loadImg.getWidth();

					String dim = wd + " x " + ht;

					String details = "File Name  : " + fnam + "\nDimension : "
							+ dim + "\nType  : " + type;

					panel.setLayout(null);

					panel.setBounds(10, 10, 150, 100);

					SplitImage_Window();
					detail.setText(details);
					spPan.add(panel);
					split.repaint();

				} else
					JOptionPane
							.showMessageDialog(
									null,
									"Unsuppoted File Format !\nSelect Only PNG/JPG/BMP/GIF Images ! ",
									"Oops!", JOptionPane.ERROR_MESSAGE);

			} else
				JOptionPane.showMessageDialog(null, "No File Selected !",
						"Oops !", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String Path(String filename) {
		File f1 = new File("TrainingProcess.java");

		String targ = f1.getAbsolutePath();

		targ = targ.replace(File.separatorChar, '/');
		targ = targ.replaceAll(f1.getPath(), "com/cbir/SVMTraining/" + filename);

		return targ;
	}

	public void SplitImage() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					Path("split.txt")));
			String no = br.readLine();
			no1 = Integer.parseInt(no);

			BufferedImage Img = ImageIO.read(f);

			int ssw = (700 / no1);
			int ssh = (500 / no1) - 20;

			int minw = (220 / no1);
			int minh = (150 / no1);

			int ht1 = Img.getHeight();
			int wd1 = Img.getWidth();

			subht = Img.getHeight() / no1;
			subwd = Img.getWidth() / no1;

			JPanel p[] = new JPanel[no1 * no1];
			p1 = new JPanel[no1 * no1];
			l = new JLabel[no1 * no1];

			buf = new BufferedImage[no1 * no1];

			int count = 0;
			int px = 10;
			int py = 120;

			int px1 = 2;
			int py1 = 10;

			int x[] = new int[no1];

			x[0] = 0;
			int y[] = new int[no1];

			y[0] = 0;
			for (int i = 1; i < no1; i++) {
				x[i] = x[i - 1] + subwd;
				y[i] = y[i - 1] + subht;

				System.out.println("X =" + x[i] + " ; Y =" + y[i]);

			}

			for (int i = 0; i < no1; i++) {
				for (int j = 0; j < no1; j++) {

					System.out.println(count + "Image Cutting width=" + x[j]
							+ "::height =" + y[i]);
					buf[count] = Img.getSubimage(x[j], y[i], subwd, subht);

					p[count] = new JImagePanel(buf[count], 0, 0, ssw, ssh);
					p[count].setBounds(px, py, ssw, ssh);

					p1[count] = new JImagePanel(buf[count], 0, 0, minw, minh);
					p1[count].setBounds(px1, py1, minw, minh);

					l[count] = new JLabel("" + (count + 1));
					l[count].setBounds(px1, py1, 15, 9);
					l[count].setForeground(Color.RED);
					l[count].setFont(new Font(null, Font.TRUETYPE_FONT, 10));

					lsbot.add(l[count]);
					lsbot.add(p1[count]);

					train.repaint();
					px1 = px1 + minw + 2;

					spPan.add(p[count]);
					split.repaint();

					px = px + ssw + 10;
					count++;

				}
				px = 10;
				py = py + ssh + 10;

				px1 = 2;
				py1 = py1 + minh + 2;

			}

			filet.setText(fnam);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void GetImageClip(BufferedImage bufimg[], int h) {

		frapan = new JImagePanel(bufimg[h - 1], 0, 0, 196, 146);

		frapan.setBounds(2, 20, 196, 146);

		//-----------------------------------------

		int r[][] = new int[subwd][subht];
		int g[][] = new int[subwd][subht];
		int b[][] = new int[subwd][subht];

		int redt = 0;
		int bluet = 0;
		int greent = 0;

		for (int i = 0; i < subwd; i++) {
			for (int j = 0; j < subht; j++) {

				int RGB = bufimg[h - 1].getRGB(i, j);
				//int RGB1=buf1.getRGB(i,j);

				int alpha = (RGB >> 24) & 0xff;
				int red = (RGB >> 16) & 0xff;
				int green = (RGB >> 8) & 0xff;
				int blue = (RGB) & 0xff;

				/*
				 * int alpha1 = (RGB1 >> 24) & 0xff; int red1= (RGB1>> 16) &
				 * 0xff; int green1 = (RGB1 >> 8) & 0xff; int blue1 = (RGB1) &
				 * 0xff;
				 */
				r[i][j] = red;
				g[i][j] = green;
				b[i][j] = blue;

				redt += red;
				bluet += blue;
				greent += green;

				/*
				 * r1[i][j]=red1; g1[i][j]=green1; b1[i][j]=blue1;
				 * 
				 * rt1+=red1; bt1+=blue1; gt1+=green1;
				 */

			}
		}

		redavg = redt / (subwd * subht);
		gravg = greent / (subwd * subht);
		bluavg = bluet / (subwd * subht);

		rt.setText(" " + redavg);
		gt.setText(" " + gravg);
		bt.setText(" " + bluavg);

		//------------------------------------------

		pic.add(frapan);

		train.repaint();

	}

	public void ManualLabeling() {

		try {

			/*
			 * BufferedWriter bw=new BufferedWriter(new
			 * FileWriter(Path("featueData.txt"))); bw.write(data);
			 * 
			 * bw.close();
			 */

			data = "" + redavg + "," + gravg + "," + bluavg + "="
					+ labt.getText() + "\n";

			System.out.println(" Data to be Stored :::" + data);

			byte[] b1 = data.getBytes();

			FileOutputStream fos = new FileOutputStream(new File(
					Path("featureData.txt")), true);
			fos.write(b1);

			fos.close();

			CheckList(labt.getText());

			System.out.println(" Data written in the txt file:::");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void CheckList(String s) {
		int itemno = list.getItemCount();

		boolean flag = true;

		if (itemno == 0) {
			list.add(s);
		} else {
			for (int i = 0; i < itemno; i++) {

				String s1 = list.getItem(i);

				if (s.equalsIgnoreCase(s1))
					flag = false;

			}

			if (flag)
				list.add(s);

		}

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == open) {
			next.setEnabled(true);
			OpenImage();
		}

		else if (ae.getSource() == exit) {

			train.setVisible(false);

			//System.exit(0);
		}

		else if (ae.getSource() == spexit) {

			prev.setEnabled(false);
			next.setEnabled(false);
			split.setVisible(false);

			for (int i = 0; i < (no1 * no1); i++) {
				lsbot.remove(p1[i]);
				lsbot.remove(l[i]);

				p1[i] = null;
				l[i] = null;
				train.repaint();
			}

			pic.remove(frapan);
			fnt.setText("");
			rt.setText("");
			bt.setText("");
			gt.setText("");
			filet.setText("");
			frapan = null;
			frnum = 0;

			list.removeAll();
			labt.setText("");

		}

		else if (ae.getSource() == spl) {

			SplitImage();

		}

		else if (ae.getSource() == prev) {

			System.out.println("Previous Pressed");

			frnum--;

			if (frnum >= 1) {
				fnt.setText("  " + frnum);

				pic.remove(frapan);
				frapan = null;
				train.repaint();

				GetImageClip(buf, frnum);

			}

			if (frnum == 1) {

				prev.setEnabled(false);

			}

			if (frnum < (no1 * no1)) {

				next.setEnabled(true);

			}

		}

		else if (ae.getSource() == next) {

			if (frnum < (no1 * no1)) {
				frnum++;
				System.out.println("Next Pressed");

				fnt.setText("  " + frnum);

				if (frnum == 1) {
					GetImageClip(buf, frnum);
				}

				else if (frnum > 1) {
					prev.setEnabled(true);

					pic.remove(frapan);
					frapan = null;
					train.repaint();

					GetImageClip(buf, frnum);

				}

			}
			if (frnum >= (no1 * no1)) {
				next.setEnabled(false);
			}

		}

		else if (ae.getSource() == ok) {

			System.out.println("Image Label OK button pressed");
			ManualLabeling();

		}

		else if (ae.getSource() == load) {

			System.out.println("Load button pressed");
			ds.DataLoad(list, f.toString(), filet.getText());

		}

		else if (ae.getSource() == refr) {

			System.out.println("Training Refresh button pressed");

			Refresh();

		}

	}

	public void Refresh() {

		split.setVisible(false);
		train.setVisible(false);
		frnum = 0;
		Training_Window();

	}

	/*
	 * public static void main(String ags[]) { TrainingProcess t=new
	 * TrainingProcess(); t.Training_Window(); // t.SplitImage_Window();
	 * 
	 *  }
	 *  
	 */
}