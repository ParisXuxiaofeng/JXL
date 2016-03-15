package com.jftt;

import java.io.*;

public class RandomAccessFileTest {

	public static void writeFile() throws IOException
	{
		RandomAccessFile raf=new RandomAccessFile("d:\\file.txt","rw");
		raf.write("张三".getBytes());
		raf.writeInt(55);
		raf.write("李四".getBytes());
		raf.writeInt(49);
		raf.close();
	}
	
	public static void readFile() throws IOException
	{
		RandomAccessFile raf=new RandomAccessFile("d:\\file.txt","r");
		
		byte[] buf=new byte[4];
		raf.read(buf);
		System.out.println("name="+new String(buf));
		System.out.println("age="+raf.readInt());
		raf.close();
	}
	
	public static void main(String[] args) throws IOException
	{
//		writeFile();
//		System.out.println(Integer.toBinaryString(355));
		readFile();
	}
}
