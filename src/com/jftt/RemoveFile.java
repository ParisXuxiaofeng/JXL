package com.jftt;

import java.io.*;

public class RemoveFile {

	public static void remove(File f)
	{
		File[] files=f.listFiles();
		
		for(int i=0;i<files.length;i++)
		{
			if(!files[i].isHidden()&&files[i].isDirectory())
			{
				remove(files[i]);
			}
			else
			{
				System.out.println(files[i].toString()+"-file-"+files[i].delete());
			}
		}
		System.out.println(f+"-f-"+f.delete());
	}
	
	public static void main(String[] args)
	{
		File f=new File("d:\\1");
		if(f.exists())
		{
			remove(f);
		}
		else
		{
			System.out.print("not exist");
		}
	}
}
