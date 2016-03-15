package com.jftt;

import java.io.*;
import java.util.*;

public class CopyContent {

	public static void getList(File f,List<File> list)
	{
		File[] files=f.listFiles();
		for(File file:files)
		{
			if(file.isDirectory())
				getList(file,list);
			else if(file.toString().endsWith("java"))
				list.add(file);
		}
	}
	
	public static void listFile(List<File> list)
	{
		BufferedWriter bw=null;
		BufferedReader br=null;
		
		try {
			bw=new BufferedWriter(new FileWriter("d:\\1\\Test.txt"));
			for(File f:list)
			{
				br=new BufferedReader(new FileReader(f));
				String s=null;
				while((s=br.readLine())!=null)
				{
					bw.write(s);
					bw.newLine();
					bw.flush();
				}
				
			}
			System.out.print("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(bw!=null)
			{
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		File f=new File("d:\\1");
		List<File> list=new ArrayList<File>();
		if(f.exists())
			getList(f,list);
		listFile(list);
	}

}
