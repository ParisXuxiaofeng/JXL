package com.jftt;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.DateFormats;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class JxlTest {

	public void createExcel(OutputStream os) throws WriteException,IOException
	{
		WritableWorkbook workbook =Workbook.createWorkbook(os);
		WritableSheet sheet= workbook.createSheet("first sheet", 0);
		sheet.mergeCells(0, 0, 2, 0);
		sheet.setRowView(0, 500);
		WritableFont font=new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
		WritableCellFormat format=new WritableCellFormat(font);
		format.setAlignment(Alignment.CENTRE);
		format.setVerticalAlignment(VerticalAlignment.CENTRE);
		Label title=new Label(0,0,"学生情况",format);
		sheet.addCell(title);
		
		WritableFont font1=new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,true,UnderlineStyle.SINGLE,Colour.RED);
		WritableCellFormat format1=new WritableCellFormat(font1);
		Label no=new Label(0,1,"学号",format1);
		sheet.addCell(no);
		Label name=new Label(1,1,"姓名",format1);
		sheet.addCell(name);
		Label birthday=new Label(2,1,"生日",format1);
		sheet.addCell(birthday);
		
		Label stuno1=new Label(0,2,"1");
		sheet.addCell(stuno1);
		Label stuname1=new Label(1,2,"张三");
		sheet.addCell(stuname1);
		Calendar c=Calendar.getInstance();
		Date date=c.getTime();
		WritableCellFormat cf1=new WritableCellFormat(DateFormats.FORMAT1);
		DateTime dt1=new DateTime(2,2,date,cf1);
		sheet.addCell(dt1);
		
		Label stuno2=new Label(0,3,"2");
		sheet.addCell(stuno2);
		Label stuname2=new Label(1,3,"李四");
		sheet.addCell(stuname2);
		DateTime dt2=new DateTime(2,3,date,cf1);
		sheet.addCell(dt2);
		
		workbook.write();
		workbook.close();
		os.close();
	}
}
