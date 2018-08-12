package fileTool;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class ReadFileTools {
	public static String readFileToStr(String filePath) throws Exception{
		InputStreamReader isr = new InputStreamReader(
				new FileInputStream(filePath));
		BufferedReader bufferedReader = new BufferedReader(isr);
		String strLine = "";
		String str = "";
		try {
			while ((strLine = bufferedReader.readLine()) != null) {
				str = str + strLine;
			}
		} finally {
			bufferedReader.close();
		}
		
		return str;
	}
	
	public static List<String> readFileToStrList(String filePath) throws Exception{
		InputStreamReader isr = new InputStreamReader(
				new FileInputStream(filePath));
		BufferedReader bufferedReader = new BufferedReader(isr);
		String strLine = "";
		List<String> strList = new ArrayList<String>();
		try {
			while ((strLine = bufferedReader.readLine()) != null) {
				strList.add(strLine);
			}
		} finally {
			bufferedReader.close();
		}
		
		return strList;
	}
	
	public static String readURLToStr(String urlPath) throws Exception{
		URL url=new URL(urlPath); 
		InputStream is=url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bufferedReader = new BufferedReader(isr);
		String strLine = "";
		String str = "";
		try {
			while ((strLine = bufferedReader.readLine()) != null) {
				str = str + strLine;
			}
		} finally {
			bufferedReader.close();
		}
		
		return str;
	}
	
	public static List<String> readURLToStrList(String urlPath) throws Exception{
		URL url=new URL(urlPath); 
		InputStream is=url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bufferedReader = new BufferedReader(isr);
		String strLine = "";
		List<String> strList = new ArrayList<String>();
		try {
			while ((strLine = bufferedReader.readLine()) != null) {
				strList.add(strLine);
			}
		} finally {
			bufferedReader.close();
		}
		
		return strList;
	}

    /**
     * 加载XML文件
     * */
	public static Document readXMLToDoc(String filePath) throws FileNotFoundException, DocumentException {
	FileInputStream initDateFile = new FileInputStream(filePath);
	SAXReader saxReader = new SAXReader();
	Document doc= saxReader.read(initDateFile);
	return doc;
    }
}
