package com.cbir.SVMFeatureAggregation;

import java.awt.Container;
import java.awt.FileDialog;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cbir.Design.JImagePanel;
import com.cbir.SVMTraining.DataStorage;

public class FeatureAggregation implements ActionListener {

	Container cont;

	JFrame anfrm;

	JPanel anpan, lsp, rsp, bot, mini, minpan;

	JLabel arr, objl, tfl, imgl;

	JLabel rimg, simg, frnol, oblis;

	JLabel rl, gl, bl;

	JTextField tf, imgt, frnot;

	JTextField rt1, gt1, bt1;

	JTextArea ta;

	List obj;

	JButton open, close, anno, nex, pre, load, add, del, refresh;

	File f;

	FileDialog fd1;

	BufferedImage[] buf;

	JPanel panel;

	Comparator com = new Comparator();

	DataStorage dstr = new DataStorage();

	int subht;

	int subwd;

	int no2;

	int redavg1 = 0;

	int gravg1 = 0;

	int bluavg1 = 0;

	int framenum = 0;

	String data1 = "";

	public void Annotate_Window() {

		JFrame.setDefaultLookAndFeelDecorated(true);

		// -----------------------------------------------------------

		anfrm = new JFrame("AI Feature Aggregation ");
		cont = anfrm.getContentPane();
		cont.setLayout(null);

		anpan = new JPanel();
		anpan.setLayout(null);
		anpan.setBounds(0, 0, 750, 600);

		lsp = new JPanel();
		lsp.setLayout(null);
		lsp.setBounds(40, 50, 250, 220);
		lsp.setBorder(BorderFactory.createTitledBorder(""));

		rsp = new JPanel();
		rsp.setLayout(null);
		rsp.setBounds(430, 50, 250, 220);
		rsp.setBorder(BorderFactory.createTitledBorder(""));

		bot = new JPanel();
		bot.setLayout(null);
		bot.setBounds(40, 280, 390, 250);
		bot.setBorder(BorderFactory.createTitledBorder(""));

		mini = new JPanel();
		mini.setLayout(null);
		mini.setBounds(180, 10, 200, 150);
		mini.setBorder(BorderFactory.createTitledBorder(""));

		// -------- anpan Panel----------

		rimg = new JLabel("Raw Image");
		rimg.setBounds(40, 30, 80, 20);

		simg = new JLabel("Sliced Image");
		simg.setBounds(430, 30, 80, 20);

		oblis = new JLabel("Labels List");
		oblis.setBounds(500, 290, 100, 20);

		obj = new List();

		obj.setBounds(500, 315, 150, 100);

		del = new JButton("Delete");
		del.setBounds(532, 425, 80, 20);
		del.addActionListener(this);

		open = new JButton("Open");
		open.setBounds(310, 100, 100, 25);
		open.addActionListener(this);

		arr = new JLabel(" ============>");
		arr.setBounds(310, 150, 120, 20);

		anno = new JButton("Input");
		anno.setBounds(310, 197, 100, 25);
		anno.addActionListener(this);

		refresh = new JButton("Refresh");
		refresh.setBounds(450, 500, 100, 25);
		refresh.addActionListener(this);

		load = new JButton("Load");
		load.setBounds(560, 500, 80, 25);
		load.addActionListener(this);

		close = new JButton("Close");
		close.setBounds(650, 500, 80, 25);
		close.addActionListener(this);

		// ----lsp Panel----------------------

		ta = new JTextArea();
		ta.setOpaque(false);
		ta.setBounds(40, 160, 160, 50);
		ta.setEditable(false);

		// ---- bot Panel---------------

		frnol = new JLabel("Frame No :");
		frnol.setBounds(80, 10, 70, 20);

		frnot = new JTextField();
		frnot.setBounds(150, 10, 20, 20);
		frnot.setEditable(false);

		pre = new JButton("<<  Prev");
		pre.setBounds(5, 55, 80, 20);
		pre.addActionListener(this);
		pre.setEnabled(false);

		nex = new JButton("Next  >>");
		nex.setBounds(93, 55, 80, 20);
		nex.addActionListener(this);
		nex.setEnabled(false);

		rl = new JLabel("R");
		rl.setBounds(30, 100, 20, 20);

		gl = new JLabel("G");
		gl.setBounds(90, 100, 20, 20);

		bl = new JLabel("B");
		bl.setBounds(150, 100, 20, 20);

		rt1 = new JTextField();
		rt1.setBounds(20, 120, 30, 20);
		rt1.setOpaque(false);
		rt1.setEditable(false);

		gt1 = new JTextField();
		gt1.setBounds(80, 120, 30, 20);
		gt1.setOpaque(false);
		gt1.setEditable(false);

		bt1 = new JTextField();
		bt1.setBounds(140, 120, 30, 20);
		bt1.setOpaque(false);
		bt1.setEditable(false);

		imgl = new JLabel("Image Label :");
		imgl.setBounds(70, 180, 90, 20);

		imgt = new JTextField();
		imgt.setOpaque(false);
		imgt.setBounds(180, 180, 150, 20);

		add = new JButton("Add");
		add.setBounds(180, 220, 80, 20);
		add.addActionListener(this);

		bot.add(mini);

		bot.add(frnol);
		bot.add(frnot);
		bot.add(pre);
		bot.add(nex);
		bot.add(imgl);
		bot.add(imgt);
		bot.add(add);
		bot.add(rl);
		bot.add(gl);
		bot.add(bl);
		bot.add(rt1);
		bot.add(gt1);
		bot.add(bt1);

		anpan.add(rimg);
		anpan.add(simg);
		anpan.add(open);
		anpan.add(close);
		anpan.add(load);
		anpan.add(anno);
		anpan.add(arr);
		anpan.add(obj);
		anpan.add(oblis);
		anpan.add(del);
		anpan.add(refresh);

		anpan.add(lsp);
		anpan.add(rsp);
		anpan.add(bot);

		lsp.add(ta);

		anfrm.add(anpan);
		anfrm.setSize(750, 600);
		anfrm.setVisible(true);

	}

	public void OpenRawImage() {

		try {

			fd1 = new FileDialog(anfrm, "Open Image", FileDialog.LOAD);
			fd1.setVisible(true);

			String fff = fd1.getDirectory();
			if (fff != null) {

				String ff = fd1.getFile();

				System.out.println("Selected File ::" + ff);

				StringTokenizer stok = new StringTokenizer(ff, ".");
				stok.nextToken();
				String extn = stok.nextToken();

				if (extn.equalsIgnoreCase("bmp")
						|| extn.equalsIgnoreCase("jpg")
						|| extn.equalsIgnoreCase("png")
						|| extn.equalsIgnoreCase("gif")) {

					f = new File(fd1.getDirectory(), fd1.getFile());

					System.out.println("Raw Image File :" + f);

					BufferedImage loadImg = ImageIO.read(f);

					panel = new JImagePanel(loadImg, 0, 0, 200, 150);

					String fnam = fd1.getFile();

					StringTokenizer st = new StringTokenizer(fnam, ".");
					st.nextToken();
					String type = st.nextToken();

					int ht = loadImg.getHeight();
					int wd = loadImg.getWidth();

					String dim = wd + " x " + ht;

					String detail = "File Name  : " + fnam + "\nDimension  : "
							+ dim + "\nType    : " + type;

					ta.setText(detail);

					panel.setLayout(null);
					panel.setBounds(20, 5, 200, 150);

					lsp.add(panel);

					anfrm.repaint();

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

	public void ImageSlice_Method() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					Path("split.txt")));
			String no = br.readLine();
			no2 = Integer.parseInt(no);

			BufferedImage Img = ImageIO.read(f);

			int minw = (220 / no2);
			int minh = (170 / no2);

			int ht1 = Img.getHeight();
			int wd1 = Img.getWidth();

			subht = Img.getHeight() / no2;
			subwd = Img.getWidth() / no2;

			JPanel[] p1 = new JPanel[no2 * no2];
			JLabel[] l = new JLabel[no2 * no2];

			buf = new BufferedImage[no2 * no2];

			int count = 0;
			int px = 10;
			int py = 120;

			int px1 = 8;
			int py1 = 20;

			int x[] = new int[no2];

			x[0] = 0;
			int y[] = new int[no2];

			y[0] = 0;
			for (int i = 1; i < no2; i++) {
				x[i] = x[i - 1] + subwd;
				y[i] = y[i - 1] + subht;

				System.out.println("X =" + x[i] + " ; Y =" + y[i]);

			}

			for (int i = 0; i < no2; i++) {
				for (int j = 0; j < no2; j++) {

					// System.out.println(count +"Image Cutting
					// width="+x[j]+"::height ="+y[i]);
					buf[count] = Img.getSubimage(x[j], y[i], subwd, subht);

					p1[count] = new JImagePanel(buf[count], 0, 0, minw, minh);
					p1[count].setBounds(px1, py1, minw, minh);

					/*
					 * l[count]=new JLabel(""+(count+1));
					 * l[count].setBounds(px1,py1,17,11);
					 * l[count].setForeground(Color.ORANGE);
					 * l[count].setFont(new Font(null,Font.TYPE1_FONT,11));
					 * 
					 * rsp.add(l[count]);
					 */

					rsp.add(p1[count]);

					px1 = px1 + minw + 2;

					anfrm.repaint();

					count++;
				}

				px1 = 8;
				py1 = py1 + minh + 2;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void CompareSlice(BufferedImage buf1[]) {

		Vector vec = com.GetRefRGBs();

		for (int imgcount = 0; imgcount < (no2 * no2); imgcount++) {

			int r[][] = new int[subwd][subht];
			int g[][] = new int[subwd][subht];
			int b[][] = new int[subwd][subht];

			int redt = 0;
			int bluet = 0;
			int greent = 0;

			int redavg;
			int gravg;
			int bluavg;

			for (int i = 0; i < subwd; i++) {
				for (int j = 0; j < subht; j++) {

					int RGB = buf1[imgcount].getRGB(i, j);

					int alpha = (RGB >> 24) & 0xff;
					int red = (RGB >> 16) & 0xff;
					int green = (RGB >> 8) & 0xff;
					int blue = (RGB) & 0xff;

					r[i][j] = red;
					g[i][j] = green;
					b[i][j] = blue;

					redt += red;
					bluet += blue;
					greent += green;

				}
			}

			redavg = redt / (subwd * subht);
			gravg = greent / (subwd * subht);
			bluavg = bluet / (subwd * subht);

			int vecsize = vec.size();

			for (int k = 0; k < vecsize; k++) {

				Vector v = (Vector) vec.get(k);

				String rr1 = (String) v.get(0);
				int rr = Integer.parseInt(rr1);

				String gg1 = (String) v.get(1);
				int gg = Integer.parseInt(gg1);

				String bb1 = (String) v.get(2);
				int bb = Integer.parseInt(bb1);

				String vlab = (String) v.get(3);

				if ((((rr) > redavg) && (redavg > (rr)))
						&& (((gg) > gravg) && (gravg > (gg)))
						&& (((bb) > bluavg) && (bluavg > (bb)))) {

					System.out.println(" Red =" + redavg + ";" + rr
							+ ":: Green =" + gravg + ";" + gg + "::Blue ="
							+ bluavg + ";" + bb);
					System.err.println(" Matching Occurs :" + vlab);

					// PrintList(vlab);
					PrintList(vlab);

				}

				else if ((((rr + 1) > redavg) && (redavg > (rr - 1)))
						&& (((gg + 1) > gravg) && (gravg > (gg - 1)))
						&& (((bb + 1) > bluavg) && (bluavg > (bb - 1)))) {

					System.out.println(" Red =" + redavg + ";" + rr
							+ ":: Green =" + gravg + ";" + gg + "::Blue ="
							+ bluavg + ";" + bb);
					System.err.println(" Matching Occurs :" + vlab);

					// PrintList(vlab);
					PrintList(vlab);

				}

				else if ((((rr + 2) > redavg) && (redavg > (rr - 2)))
						&& (((gg + 2) > gravg) && (gravg > (gg - 2)))
						&& (((bb + 2) > bluavg) && (bluavg > (bb - 2)))) {

					System.out.println(" Red =" + redavg + ";" + rr
							+ ":: Green =" + gravg + ";" + gg + "::Blue ="
							+ bluavg + ";" + bb);
					System.err.println(" Matching Occurs :" + vlab);

					// PrintList(vlab);
					PrintList(vlab);

				}

				/*
				 * else if( ( ((rr+3)>redavg) && (redavg>(rr-3)) )
				 * &&(((gg+3)>gravg) && (gravg>(gg-3)))&&(((bb+3)>bluavg) &&
				 * (bluavg>(bb-3)))) {
				 * 
				 * System.out.println(" Red ="+redavg+";"+rr+":: Green
				 * ="+gravg+";"+gg+"::Blue ="+bluavg+";"+bb);
				 * System.err.println(" Matching Occurs :"+vlab);
				 * 
				 * //PrintList(vlab); PrintList(vlab); }
				 */
			}
			// ------------------------------------------

		}

	}

	public String Path(String filename) {
		File f1 = new File("Annotate.java");

		String targ = f1.getAbsolutePath();

		targ = targ.replace(File.separatorChar, '/');
		targ = targ.replaceAll(f1.getPath(), "com/cbir/SVMTraining/" + filename);

		System.out.println("Annotate ------- PAth ::: " + targ);
		return targ;
	}

	public void PrintList(String s) {
		int itemno = obj.getItemCount();
		System.out.println("PrintList:"+s);
		boolean flag = true;

		{

			obj.add(s);
			for (int i = 0; i < itemno; i++) {

				String s1 = obj.getItem(i);

				if (s.equalsIgnoreCase(s1))
					flag = false;

			}

			
		}

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == close) {

			anfrm.setVisible(false);

			// System.exit(0);
		}

		if (ae.getSource() == open) {
			System.out.println("Open Clicked");

			OpenRawImage();
		}

		if (ae.getSource() == anno) {
			System.out.println("Input Clicked");

			ImageSlice_Method();
			CompareSlice(buf);
			nex.setEnabled(true);

		}

		if (ae.getSource() == add) {
			System.out.println("ADD  Clicked");

			LabelingMethod();

		}

		if (ae.getSource() == pre) {
			System.out.println("Previous Clicked");

			framenum--;

			if (framenum >= 1) {
				frnot.setText("  " + framenum);

				mini.remove(minpan);
				minpan = null;
				anfrm.repaint();

				GetImageRGB(buf, framenum);

			}

			if (framenum == 1) {

				pre.setEnabled(false);

			}

			if (framenum < (no2 * no2)) {

				nex.setEnabled(true);

			}

		}

		if (ae.getSource() == nex) {
			System.out.println("Next Clicked");

			if (framenum < (no2 * no2)) {
				framenum++;
				System.out.println("Next Pressed");

				frnot.setText("  " + framenum);

				if (framenum == 1) {
					GetImageRGB(buf, framenum);
				}

				else if (framenum > 1) {
					pre.setEnabled(true);

					mini.remove(minpan);
					minpan = null;
					anfrm.repaint();

					GetImageRGB(buf, framenum);

				}

			}
			if (framenum >= (no2 * no2)) {
				nex.setEnabled(false);
			}

		}

		if (ae.getSource() == load) {
			System.out.println("Load Clicked");

			dstr.DataLoad(obj, f.toString(), fd1.getFile());

		}

		if (ae.getSource() == del) {
			System.out.println("Delete Clicked");

			String str = obj.getSelectedItem();
			
			if (str == null) {
				JOptionPane.showMessageDialog(null, " No Item Selected ! ",
						" Error !", JOptionPane.ERROR_MESSAGE);
			} else
				obj.remove(str);

		}

		if (ae.getSource() == refresh) {
			System.out.println("Resfresh Clicked");

			framenum = 0;

			RefreshWindow();

		}

	}

	public void LabelingMethod() {

		try {

			/*
			 * BufferedWriter bw=new BufferedWriter(new
			 * FileWriter(Path("featueData.txt"))); bw.write(data);
			 * 
			 * bw.close();
			 */

			data1 = "" + redavg1 + "," + gravg1 + "," + bluavg1 + "="
					+ imgt.getText() + "\n";

			System.out.println(" Data to be Stored :::" + data1);

			byte[] b1 = data1.getBytes();

			FileOutputStream fos = new FileOutputStream(new File(
					Path("featureData.txt")), true);
			fos.write(b1);

			fos.close();

			PrintList(imgt.getText());

			System.out.println(" Data written in the txt file:::");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void GetImageRGB(BufferedImage bufimg[], int h) {

		minpan = new JImagePanel(bufimg[h - 1], 0, 0, 190, 140);

		minpan.setBounds(5, 5, 190, 140);

		// -----------------------------------------

		int r[][] = new int[subwd][subht];
		int g[][] = new int[subwd][subht];
		int b[][] = new int[subwd][subht];

		int redt = 0;
		int bluet = 0;
		int greent = 0;

		for (int i = 0; i < subwd; i++) {
			for (int j = 0; j < subht; j++) {

				int RGB = bufimg[h - 1].getRGB(i, j);
				// int RGB1=buf1.getRGB(i,j);

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

		redavg1 = redt / (subwd * subht);
		gravg1 = greent / (subwd * subht);
		bluavg1 = bluet / (subwd * subht);

		rt1.setText(" " + redavg1);
		gt1.setText(" " + gravg1);
		bt1.setText(" " + bluavg1);

		// ------------------------------------------

		mini.add(minpan);

		anfrm.repaint();

	}

	public void RefreshWindow() {

		/*
		 * obj.removeAll();
		 * 
		 * lsp.remove(panel);
		 * 
		 * buf=null;
		 */

		anfrm.setVisible(false);

		Annotate_Window();

	}

	/*
	 * public static void main(String args[]) {
	 * 
	 * Annotate a=new Annotate(); a.Annotate_Window(); }
	 */

}