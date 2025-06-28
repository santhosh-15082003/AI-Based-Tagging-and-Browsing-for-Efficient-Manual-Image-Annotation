package com.cbir.Design;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.swing.JOptionPane;

public class DataBase {

	Connection con = null;
	Properties prop = null;

	public Connection getDataBase() {

		try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager
					.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=cbir.mdb");
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "DataBase Connection Error :"
					+ "\n " + e.getMessage(), "Error !",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return con;
	}

	public String Path(String filename) {
		File f1 = new File("DataBase.java");

		String targ = f1.getAbsolutePath();

		targ = targ.replace(File.separatorChar, '/');

		targ = targ.replaceAll(f1.getPath(), "com/cbir/Design/" + filename);

		return targ;
	}

}