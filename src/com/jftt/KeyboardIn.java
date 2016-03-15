package com.jftt;

import java.io.*;

public class KeyboardIn {

	public static void main(String[] args)
	{
		InputStream in=System.in;
		StringBuilder sb=new StringBuilder();
		
		while(true)
		{
			try {
				int ch=in.read();
				if(ch=='\r')
				continue;
				if(ch=='\n')
				{
					String s=sb.toString();
					if("over".equals(s))
					break;
					System.out.println(s.toUpperCase());
					sb.delete(0, sb.length());
				}
				else
				{
					sb.append((char)ch);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
