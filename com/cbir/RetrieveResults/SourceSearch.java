package com.cbir.RetrieveResults;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.cbir.Design.DataBase;

public class SourceSearch
{
	
	ImageSearch is=new ImageSearch();
	DataBase db=new DataBase();
	
	Connection connect=null;
	Statement st=null;
	ResultSet rs=null;
	
	
	public String SourceSearch_Method(String s)
	{
		String locat="";
		
		try{
			
			connect=db.getDataBase();
			st=connect.createStatement();
			
			String qry="select fileloc from location where filename='"+s+"'";
			
			rs=st.executeQuery(qry);
			
			if(rs.next())
			{
			locat=rs.getString("fileloc");
			}
			
			else
				JOptionPane.showMessageDialog(null,"Result not found !","Oops !",JOptionPane.INFORMATION_MESSAGE);
			
			System.out.println("Location from DataBase  ="+locat);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return locat;
		
	}
	
	
	
	
	
}