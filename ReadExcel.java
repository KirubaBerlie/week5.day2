package week5.day2.assignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readData(String workbookName) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./data/" + workbookName + ".xlsx");
		System.out.println(wb.getSheetName(0));
		XSSFSheet ws = wb.getSheet("Sheet1");
		int rowCount = ws.getLastRowNum();
		short columnCount = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				String text = ws.getRow(i).getCell(j).getStringCellValue();
				data[i - 1][j] = text;
			}
		}

		wb.close();
		return data;
	}

}
