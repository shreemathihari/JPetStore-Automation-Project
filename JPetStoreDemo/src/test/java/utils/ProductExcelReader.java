package utils;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ProductExcelReader {
 
    private static final String FILE_PATH =
            "src/test/resources/testdata/Product.xlsx";
 
    public static String getData(String testId, int columnNumber) {
 
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {
 
            Sheet sheet = workbook.getSheetAt(0);
 
            for (Row row : sheet) {
 
                if (row.getRowNum() == 0) {
                    continue;
                }
 
                String id = row.getCell(0).getStringCellValue();
 
                if (id.equalsIgnoreCase(testId)) {
                    return row.getCell(columnNumber)
                              .getStringCellValue();
                }
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return "";
    }
}
