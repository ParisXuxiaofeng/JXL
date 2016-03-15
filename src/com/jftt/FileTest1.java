package com.jftt;

import java.io.*;

public class FileTest1 {
	public static String addLevel(int level)
	{
		StringBuffer sb=new StringBuffer();
		sb.append("|--");
		for(int i=0;i<level;i++)
		{
			sb.insert(0, " ");
		}
		return sb.toString();
	}
	
	public static void getlistFiles(File dir,int level)
	{
		System.out.println(addLevel(level++)+dir.getName());
		File[] files=dir.listFiles(new FilenameFilter(){
			public boolean accept(File dir,String name)
			{
				return true;
			}
		});
		for(int i=0;i<files.length;i++)
		{
			if(files[i].isDirectory())
				getlistFiles(files[i],level);
			else
			System.out.println(files[i].getName());
		}
	}
	
	public static void main(String[] args)
	{
		File dir=new File("d:\\1");
		getlistFiles(dir,0);
	}
	
}
