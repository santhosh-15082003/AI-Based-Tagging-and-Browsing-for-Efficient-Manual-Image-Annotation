package com.cbir.SVMTraining;

import java.awt.List;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.cbir.Design.DataBase;


public class DataStorage 
{
	
	//TrainingProcess tp=new TrainingProcess();
	List datalist;
	
	
	DataBase db=new DataBase();
	Connection connect=null;
	Statement st=null;
	
	
	public void DataLoad(List list,String fp,String fn)
	{
		try{
			
		datalist=list;
		String filepath=fp;
		String filename=fn;
		
		System.out.println(" Data List : "+datalist+":::: File Name ="+filename+"::::::FIle Path ="+filepath);
		
		int y=datalist.getItemCount();
		
		
		for(int i=0;i<y;i++)
		{
			String item=datalist.getItem(i);
			
			String data=item+"="+filename+"\n";
			
			byte[] b=data.getBytes();
			
			FileOutputStream fos=new FileOutputStream(new File(Path("content.txt")),true);
			fos.write(b);
			fos.close();
		
		}
		
		
		String loc=filename+"="+filepath+"\n";
		byte[] b1=loc.getBytes();
		
	/*	FileOutputStream fos1=new FileOutputStream(new File(Path("location.txt")),true);
		fos1.write(b1);
		fos1.close();
		
		*/
		
		connect=db.getDataBase();
		st=connect.createStatement();
		
		String qry="insert into location values('"+filename+"','"+filepath+"')";
		
		boolean res=st.execute(qry);
		
		
		if(!res)
			JOptionPane.showMessageDialog(null,"Successfully Added !","Message",JOptionPane.INFORMATION_MESSAGE);
		
		else
			JOptionPane.showMessageDialog(null,"Error : "+"\n Data Insertion Failed !","Error",JOptionPane.ERROR_MESSAGE);
			
		}
		catch(Exception e)
		{
			
			JOptionPane.showMessageDialog(null," Error Occured  :"+"\n "+e.getMessage(),"Error !",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			
		}
	}
	
	public String Path(String filename)
	{
		File f1=new File("DataStorage.java");
		
		String targ=f1.getAbsolutePath();
		
		targ=targ.replace(File.separatorChar,'/');
		targ=targ.replaceAll(f1.getPath(),"com/cbir/SVMTraining/"+filename);
		
		return targ;
	}
	
}