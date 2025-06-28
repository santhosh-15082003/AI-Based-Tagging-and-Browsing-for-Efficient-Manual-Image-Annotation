package com.cbir.SVMFeatureAggregation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Comparator
{
	
	
	
	
	public Vector GetRefRGBs()
	{
		Vector vec=new Vector();
		try{
		
			BufferedReader read=new BufferedReader(new FileReader(Path("featureData.txt")));
	
			String data=read.readLine();
	
			while(data!=null)
			{
		
				Vector rgb=new Vector();
				StringTokenizer str=new StringTokenizer(data,"=");
				String rgb1=str.nextToken();
				String value1=str.nextToken();
		
		
				StringTokenizer str1=new StringTokenizer(rgb1,",");
				String re=str1.nextToken();
				String gr=str1.nextToken();
				String bl=str1.nextToken();
		
				rgb.add(re);
				rgb.add(gr);
				rgb.add(bl);
				rgb.add(value1);
		
				vec.add(rgb);
		
				//System.out.println(data);
				data=read.readLine();
		  
			}	
	
	
			System.out.println(" Vector ="+vec);
		
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
	
	return vec;
	
	}
	
	public String Path(String filename)
	{
		File f1=new File("Comparator.java");
		
		String targ=f1.getAbsolutePath();
		
		targ=targ.replace(File.separatorChar,'/');
		targ=targ.replaceAll(f1.getPath(),"com/cbir/SVMTraining/"+filename);
		
		System.out.println(" Comparator ----Path :::: = "+targ);
		
		return targ;
	}
	
	
	
	
}