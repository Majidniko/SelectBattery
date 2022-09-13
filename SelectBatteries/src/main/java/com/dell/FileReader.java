package com.dell;

import java.io.File;  
import java.io.FileInputStream;  
import java.util.Iterator;  

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class FileReader  
{  
	public static String CarBrand[]= new String[87];
	public static double Capacity[]=new double[87];
	public static double Charge[]=new double[87];

	public static String[] name()   
	{  
		int Counter1=0;
		try  
		{  
			// Read File 
			File file = new File("D:\\CarsBaInfo.xlsx");   
			FileInputStream fis = new FileInputStream(file);  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);  
			Iterator<Row> itr = sheet.iterator();  
			while (itr.hasNext())                 
			{  
				Row row = itr.next();  
				Iterator<Cell> cellIterator = row.cellIterator(); 
				while (cellIterator.hasNext())   
				{  
					Cell cell = cellIterator.next();  
					// Select car model from excel file
					if (cell.getColumnIndex()==1 ){
						switch (cell.getCellType())               
						{  
						case Cell.CELL_TYPE_STRING:  
							CarBrand[Counter1]=cell.getStringCellValue();
							break;  
						case Cell.CELL_TYPE_NUMERIC:  
							// skip if its not String
							break;  
						default:  
						}
					}
					// select batteries capacity column 
					else if (cell.getColumnIndex()==2 ){
						switch (cell.getCellType())               
						{  
						case Cell.CELL_TYPE_STRING:  
							// skip if its not number
							break;  
						case Cell.CELL_TYPE_NUMERIC: 
							Capacity[Counter1]=cell.getNumericCellValue();
							break;
						}  
					}
					// select time to charging info
					else if (cell.getColumnIndex()==7 ){
						switch (cell.getCellType())               
						{  
						case Cell.CELL_TYPE_STRING:  
							// skip if its not number
							break;  
						case Cell.CELL_TYPE_NUMERIC:   
							Charge[Counter1]=cell.getNumericCellValue();
							Counter1++;
							break;  
						default:  
						}  
					}
					
				}

			}
		}
		catch(Exception e)  
		{  
			e.printStackTrace();  
		}  
		return CarBrand;
	}  
	public static double[] capacity()   
	{  
		return Capacity;
	}  
	public static double[] ChargingTime()   
	{  

		return Charge;
	}  

}  
