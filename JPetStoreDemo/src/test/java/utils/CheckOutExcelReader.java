package utils;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CheckOutExcelReader {

    public static String getData(String testId, int columnNumber) {

        String filePath =
                "src/test/resources/testdata/CheckOut.xlsx";

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            DataFormatter formatter = new DataFormatter();

            for (Row row : sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }

                String id = formatter.formatCellValue(row.getCell(0));

                if (id.equalsIgnoreCase(testId)) {

                    if (row.getCell(columnNumber) == null) {
                        workbook.close();
                        fis.close();
                        return "";
                    }

                    String value =
                            formatter.formatCellValue(
                                    row.getCell(columnNumber));

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