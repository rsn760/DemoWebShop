package commonLib;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcel {
	
	public Object[][] get_xl_data(String file_name, String sheet_name) throws Exception {
	    FileInputStream fis = null;
	    XSSFWorkbook wb = null;
	    Object[][] data = null;

	    try {
	        fis = new FileInputStream(file_name);
	        wb = new XSSFWorkbook(fis);
	        XSSFSheet sheet = wb.getSheet(sheet_name);

	        int rows = sheet.getPhysicalNumberOfRows();
	        int cols = sheet.getRow(0).getLastCellNum();
	        data = new Object[rows - 1][cols];

	        for (int row = 0; row < rows - 1; row++) {
	            for (int col = 0; col < cols; col++) {
	                DataFormatter format = new DataFormatter();
	                data[row][col] = format.formatCellValue(sheet.getRow(row + 1).getCell(col));
	            }
	        }
	    } finally {
	        if (wb != null) {
	            wb.close();
	        }
	        if (fis != null) {
	            fis.close();
	        }
	    }
	    return data;
	}


}
