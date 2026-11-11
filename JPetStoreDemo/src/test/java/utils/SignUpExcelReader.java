package utils;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class SignUpExcelReader {
 
    public static String getData(String userId, int columnNumber) {
 
        String filePath = "src/test/resources/testdata/SignUp.xlsx";
 
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
 
            for (Row row : sheet) {
 
                if (row.getRowNum() == 0) {
                    continue;
                }
 
                String id = row.getCell(0).getStringCellValue();
 
                if (id.equalsIgnoreCase(userId)) {
 
                	DataFormatter formatter = new DataFormatter();

                	String value = formatter.formatCellValue(
                	        row.getCell(columnNumber)
                	);
 
                    workbook.close();
                    fis.close();
 
                    return value;
                }
            }
 
            workbook.close();
            fis.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return "";
    }
}
 