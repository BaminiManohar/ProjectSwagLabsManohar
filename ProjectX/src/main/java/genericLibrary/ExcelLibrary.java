package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary implements FrameWorkConstant {


	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static Workbook book;

	public static String readSingleData(String sheetName, int rowVal, int cellVal) {

		// 1.convert External File into Java Understandable

		try {
			fis = new FileInputStream(ExcelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2.Create an workBook Using WorkBook Factory

		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		// 3.Read the Data

		String data = book.getSheet(sheetName).getRow(rowVal).getCell(cellVal).getStringCellValue();

		System.out.println(data);

		System.out.println("Readed the data Succesfuly");
		return data;

	}

	public static void writeInTheFile(String sheetName1, int rowVal1, int cellVal1, String passTheSetValue1) {

		// 1.convert External File into Java Understandable

		try {
			fis = new FileInputStream(ExcelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2.Create an workBook Using WorkBook Factory

		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3.Read the Data

		book.createSheet(sheetName1).createRow(rowVal1).createCell(cellVal1).setCellValue(passTheSetValue1);

		// java understandable to external file

		try {
			fos = new FileOutputStream(ExcelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// write

		try {
			book.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("new Data Written Succesfully");
	}

}
