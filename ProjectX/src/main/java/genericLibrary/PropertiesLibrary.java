package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesLibrary implements FrameWorkConstant{

	static FileInputStream fis;
	static FileOutputStream fos;
	static Properties property;
	
	
	
	public static String fetchData(String key) {
		
		try {
			fis = new FileInputStream(propertyPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return property.getProperty(key);

	}
	
	public static void writeData(String key, String value, String message) {
		
		  
		
		try {
			fis = new FileInputStream(propertyPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties propertiesObj = new Properties();
		try {
			propertiesObj.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String s = propertiesObj.getProperty(key);
		
		propertiesObj.put(key, value);
		
		try {
			fos = new FileOutputStream(propertyPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			propertiesObj.store(fos, message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
