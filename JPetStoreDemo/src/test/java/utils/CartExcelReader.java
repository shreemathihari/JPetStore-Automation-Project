package utils;
import java.io.FileInputStream;
 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class CartExcelReader {
 
    public static String getData(String testId, int columnNumber) {
 
        String filePath = "src/test/resources/testdata/Cart.xlsx";
 
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
 
            for (Row row : sheet) {
 
                if (row.getRowNum() == 0) {
                    continue;
                }
 
                String id = row.getCell(0).getStringCellValue();
 
                if (id.equalsIgnoreCase(testId)) {
 
                    String value = row.getCell(columnNumber)
                                      .toString();
 
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
 