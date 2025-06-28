package com.cbir.RetrieveResults;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JOptionPane;


public class ImageSearch
{
	
	public TreeSet tree;
	public Vector keyvec,keyimg,rankinglist;
	public Hashtable rank;
	
	
	public void Search_Method(String keys,Object frame)
	{
		try{
			
			rankinglist=new Vector();
			
		ImageRetrieve obj=(ImageRetrieve)frame;
		String str;
		
		StringTokenizer tok=new StringTokenizer(keys,",");
		
		Vector key=new Vector();
		
			while(tok.hasMoreElements())
			{
				str=tok.nextToken().trim();
				System.out.println("String Tokens  - "+str);
				key.add(str);
			
			}
			
			System.out.println("Key Vectors ::::: "+key);
			
			Vector Content1=ReadContent("content.txt");
			
			//System.out.println("Content Vectors  ::::"+Content1);
		
		
		int keysize=key.size();
		int Contsize=Content1.size();
		
		System.out.println("Key Size  ::::"+keysize);
		
		tree=new TreeSet();
		
		if(keysize>0)
		{
		
			keyvec=new Vector();
		
		for(int i=0;i<keysize;i++)
		{
			String keystr=(String)key.get(i);
			
			keyimg=new Vector();
			
			for(int j=0;j<Contsize;j++)
			{
				
				Vector cc=(Vector)Content1.get(j);
				
				String str2=(String)cc.get(0);
				
				if(str2.equalsIgnoreCase(keystr))
				{
					String liststr=(String)cc.get(1);
					//CheckResultList(frame,liststr);
					
					
					tree.add(liststr);
					keyimg.add(liststr);
					
					
				}
				
			
				
			}
			keyvec.add(keyimg);
		}
		
		
		System.out.println(" Key Vector ******  "+keyvec);
		
		}
		
		else
			JOptionPane.showMessageDialog(null,"Enter Key Words  !"+"\n \nEg:  key1 , key2 , key3 . . .","Message",JOptionPane.INFORMATION_MESSAGE);
		
		
		
		
		
		
		int kv=keyvec.size();
		rank=new Hashtable();
		
		
		Iterator ite=tree.iterator();
		
		
		while(ite.hasNext())
		{
		
			String name=(String)ite.next();
			int cnt=0;
		
			for(int i=0;i<kv;i++)
			{
			
			Vector vv=(Vector)keyvec.get(i);
		
		    
			if(vv.contains(name))
			cnt++;
			
			}
		
			rank.put(name,""+cnt);
			
		}
		
		
		System.out.println("HAsh Table Values :::: "+rank.toString());
		
		Iterator ite1=tree.iterator();

		Vector ra=new Vector();
		
		while(ite1.hasNext())
		{
			
			Vector rr=new Vector();
			String nam=(String)ite1.next();
		
			String cnn=(String)rank.get(nam); 
			
		
			rr.add(nam);
			rr.add(cnn);
			
			ra.add(rr);
		}
		
		System.out.println("Rank Ve ctor :::: "+ra);
		
		int racnt=ra.size();
		
		for(int i=0;i<keysize;i++)
		{
			
			for(int j=0;j<racnt;j++)
			{
				Vector tem=(Vector)ra.get(j);
				String ccn=(String)tem.get(1);
				
				if(ccn.equalsIgnoreCase(""+(i+1)))
					rankinglist.add((String)tem.get(0));
					
				
		
			}
		}
		
		
		System.out.println("Ranking List Vector  :::: "+rankinglist);
		
		
		int ralis=rankinglist.size();
		
		
		for(int i=ralis-1;i>=0;i--)
		{
		
			String liststr=(String)rankinglist.get(i);
			
		//	CheckResultList(frame,liststr);
			obj.relist.add(liststr);
		}
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	public Vector ReadContent(String pa)
	{
		Vector Content=new Vector();
		try{
			
		
		BufferedReader  br=new BufferedReader(new FileReader(Path(pa)));
		
		String dat=br.readLine();
		
		
		
		while(dat!=null)
		{
			
			StringTokenizer tok1=new StringTokenizer(dat,"=");
			
			String cont=tok1.nextToken();
			String img=tok1.nextToken();
			
			Vector vcont=new Vector();
			vcont.add(cont);
			vcont.add(img);
			
			Content.add(vcont);
			
			
			
			dat=br.readLine();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return Content;
	}
	
	public String Path(String filename)
	{
		File f1=new File("ImageSearch.java");
		
		String targ=f1.getAbsolutePath();
		
		targ=targ.replace(File.separatorChar,'/');
		targ=targ.replaceAll(f1.getPath(),"com/cbir/SVMTraining/"+filename);
		
		return targ;
	}
	
	
	
	
}