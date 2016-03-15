package com.jftt;

import java.io.*;
import java.util.*;

public class RunCount {
	public static void count()
	{
		try {
			Properties pro=new Properties();
			File file =new File("d:\\count.ini");
			if(!file.exists())
			{
				file.createNewFile();
			}
			FileInputStream fis =new FileInputStream(file);
			pro.load(fis);
			int count=0;
			String value=pro.getProperty("time");
			if(value!=null)
			{
				count=Integer.parseInt(value);
				if(count>=5)
				{
					System.out.println("you have no chance");
					return;
				}
			}
			count++;
			pro.setProperty("time", count+"");
			FileOutputStream fos=new FileOutputStream(file);
			pro.store(fos, "fos");
			fos.close();
			fis.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		count();
	}
}
