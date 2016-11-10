package com.banking.banks;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcel {
	
	
	public ArrayList<SampleBranch> read(){
		ArrayList<SampleBranch> banks=new ArrayList<SampleBranch>();
		try{
		URL url=ReadExcel.class.getClassLoader().getResource("Subeler.xls");
		File subeler = new File(url.getPath());
		FileInputStream file = new FileInputStream(subeler);
		System.out.println(subeler.length());
		System.out.println(file.getChannel().size());
		//Create Workbook instance holding reference to .xlsx file
		
		 HSSFWorkbook workbook = new HSSFWorkbook(file);
		 

        //Get first/desired sheet from the workbook
		 HSSFSheet sheet = workbook.getSheetAt(0);

		 
		 int index=0;
		 SampleBranch branch=null;
		 
		 
		 
        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) 
        {
            Row row = rowIterator.next();
            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();
             branch=new SampleBranch();
            while (cellIterator.hasNext()) 
            {
                Cell cell = cellIterator.next();
                
                if(index==0||index==1||index==4)
                switch (cell.getCellType()) 
                {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print("sdsad" + "t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                    	String s=cell.getStringCellValue();
                    	if(index==0)
                    		branch.setBankname(s);
                    	else if(index==1)
                    		branch.setBranch(s);
                    	else if(index==4){
                    		branch.setCity(s);
                    		banks.add(branch);
                    	}
                    	//System.out.println(s+",");
                        break;
                }
                
                index++;
                
            }
            index=0;
            
           
        }
        file.close();
        
       return banks;
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    }
		return banks;
		
	    
	}
	
}
