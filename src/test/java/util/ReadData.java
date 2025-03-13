// Import statements 
package util; 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet; 
import org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.FormulaEvaluator; 
import org.apache.poi.ss.usermodel.Row; 
  
// Main class 
public class ReadData { 
  
    // Main driver method 
    public static  Map<String, String> fecth() 
    { 
  
        // Try block to check for exceptions 
        try { 
  
            // Reading file from local directory 
            FileInputStream file = new FileInputStream( 
                new File("src/test/resources/testData.xls")); 
  
            // Create Workbook instance holding reference to 
           
            HSSFWorkbook workbook = new HSSFWorkbook(file); 
  
            // Get first/desired sheet from the workbook 
            HSSFSheet sheet = workbook.getSheet("data");  // HSSFSheet sheet = workbook.getSheetAt(0)
           // String firstData=sheet.getRow(0).getCell(0).getStringCellValue();
            
            // Iterate through each rows one by one 
            Iterator<Row> rowIterator = sheet.iterator(); 
            Map<String,String> testData= new HashMap<String,String>();
            
            // Till there is an element condition holds true
            int i=0;
            while (rowIterator.hasNext()) {
            	rowIterator.next();
            	testData.put(sheet.getRow(i).getCell(0).getStringCellValue(), sheet.getRow(i).getCell(1).getStringCellValue())	;
            	i++;
            } 
            System.out.println(testData);
            file.close(); 
            return testData;

        } 
  
        // Catch block to handle exceptions 
        catch (Exception e) { 
        	return null;
  
        } 
    } 
}