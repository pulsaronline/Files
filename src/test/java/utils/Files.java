package utils;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class Files {

    public static String readTextFromFile(File file) throws IOException {
    return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
}

    public static String readTextFromPath(String path) throws IOException {
    return readTextFromFile(getFile(path));
    }

    public static File getFile(String path) {
    return new File(path);
    }

    public static PDF getPdf(String path) throws IOException {
        return new PDF(getFile(path));
    }

    public static XLS getXls(String path) throws IOException {
        return new XLS(getFile(path));
    }
    public static String readXlsxFromPath(String path) {
        String result = "";
        XSSFWorkbook myExcelBook = null;

        try {
            myExcelBook = new XSSFWorkbook(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
        Iterator<Row> rows = myExcelSheet.iterator();

        while (((Iterator<?>) rows).hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();
                //перебираем возможные типы ячеек
                switch (cellType) {
//                    case Cell.CELL_TYPE_STRING:
//                        result += cell.getStringCellValue() + "=";
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC:
//                        result += "[" + cell.getNumericCellValue() + "]";
//                        break;
//
//                    case Cell.CELL_TYPE_FORMULA:
//                        result += "[" + cell.getNumericCellValue() + "]";
//                        break;
                    default:
                        result += cell.toString();
                        break;
                }
            }
        }

        try {
            myExcelBook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getDocx(String path) throws IOException, InvalidFormatException {
        File file = getFile(path);
        String filePath = file.getPath();
        String result;
            FileInputStream fileInputStream = new FileInputStream(filePath);
            XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(fileInputStream));
            XWPFWordExtractor extractor = new XWPFWordExtractor(docxFile);
            fileInputStream.close();
            result = extractor.getText();
        return result;
    }
}
