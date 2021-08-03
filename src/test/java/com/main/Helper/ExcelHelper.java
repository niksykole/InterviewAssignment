package com.main.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelHelper {	
			public static File oFile;
			public static FileInputStream oFileInputStream;
			public static XSSFWorkbook oXSSFWorkbook;
			public static XSSFSheet oXSSFSheet;
			public static Row rHearderRow;
			public static int iLastRowcount;
			public static int iLastColcount;

			public static List<Map<String,String>> listExcelData = new ArrayList<>();


			public static void getExcelData() throws IOException {
				oFile = new File("src/test/resources/TestData/VerifyGoogleSearch.xlsx");
				oFileInputStream = new FileInputStream(oFile);
				oXSSFWorkbook = new XSSFWorkbook(oFileInputStream);
				oXSSFSheet = oXSSFWorkbook.getSheet("GoogleSearch");
				rHearderRow = oXSSFSheet.getRow(0);
				iLastRowcount = oXSSFSheet.getLastRowNum();
				iLastColcount = oXSSFSheet.getRow(0).getLastCellNum();
				for(int i=1;i<=iLastRowcount;i++) {
					Map<String,String> oMap = new HashMap<String, String>();
					for(int j=0;j<iLastColcount;j++) {
						oMap.put(rHearderRow.getCell(j).getStringCellValue(), oXSSFSheet.getRow(i).getCell(j).getStringCellValue());
					}			 
					listExcelData.add(oMap);
				}
				
			}
	


}
