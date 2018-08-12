package fileTool;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.List;

public class WriteFileTools {
	public static void WriteToFile(InputStream is,String path) throws Exception{
		//从输入流中获取字节数组
		byte[] buffer = new byte[1024];
		int length = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((length = is.read(buffer)) != -1) {
			bos.write(buffer,0,length);
		}
		bos.close();
		
		File file = new File(path);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(bos.toByteArray());
		if (fos != null) {
			fos.close();
		}
		if (is != null) {
			is.close();
		}
	}
	
	public static void WriteToFile(String str,String path) throws Exception{
		File file = new File(path);
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(str);
		bw.close();
		fw.close();
	}
	
	public static void WriteToFile(List<String> strList,String path) throws Exception{
		String fileString = "";
		for(String str:strList){
			fileString = fileString+str;
		}
		WriteToFile(fileString,path);
	}

}
