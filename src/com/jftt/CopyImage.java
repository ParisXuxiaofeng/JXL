package com.jftt;

import java.io.*;
import java.util.Scanner;

public class CopyImage {

	public static void main(String[] args)
	{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		Scanner input=new Scanner(System.in);
		System.out.println("输入源文件路径,如：d:\\1.jpg");
		String a=input.next();
		System.out.println("输入复制路径，如：d:\\copy.jpg");
		String b=input.next();
		File file=new File(a);
		File copyFile=new File(b);
		
		try {
			fis=new FileInputStream(file);
			fos=new FileOutputStream(copyFile);
			byte[] arr=new byte[1024];
			int len=0;
			while((len=fis.read(arr))!=-1)
			{
				fos.write(arr,0,len);
			}
			System.out.print("success");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(fis!=null)
				{
					fis.close();
				}
				if(fos!=null)
				{
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
