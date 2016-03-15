package com.jftt;

import java.io.*;
import java.util.Scanner;

public class FileTest {
	
	public static void main(String[] args)
	{
		BufferedReader br=null;
		BufferedWriter bw=null;
		Scanner input=new Scanner(System.in);
		System.out.println("输入原文件路径：如d:\\First.java");
		String copyPath=input.next();
		System.out.println("输入复制的路径：如d:\\copy.java");
		String newPath=input.next();
		File copyFile=new File(copyPath);
		File newFile=new File(newPath);
		
		try {
			br=new BufferedReader(new FileReader(copyFile));
			bw=new BufferedWriter(new FileWriter(newFile));
			
			String s=null;
			while((s=br.readLine())!=null)
			{
				bw.write(s);
				bw.newLine();
				bw.flush();
			}
			System.out.print("copy success");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(br!=null)
				{
					br.close();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			try {
				if(bw!=null)
				{
					bw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
