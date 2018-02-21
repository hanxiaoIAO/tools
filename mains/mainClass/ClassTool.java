package mainClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
//import java.util.HashMap;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassTool {
	List<JarFile> jarFileList = new ArrayList<JarFile>();
	
	public ClassTool(String path){
		findJarFile(path);
	}
	
	private void findJarFile(String path){
		File file = new File(path);
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(int i = 0,length = files.length;i<length;i++){
				path = files[i].getAbsolutePath();
				findJarFile(path);
			}
		}else{
			if(file.getName().toLowerCase().endsWith("jar")){
				JarFile jar = null;
				try {
					jar = new JarFile(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				jarFileList.add(jar);
			}
		}
	}

	private String findClass(JarFile jarFile,String className){
		Enumeration<JarEntry> jarEntrys = jarFile.entries();
		String jarName = jarFile.getName();
		String qualifiedName = "";
		while(jarEntrys.hasMoreElements()){
			JarEntry jarEntry = jarEntrys.nextElement();
			if(jarEntry.isDirectory()){
				continue;
			}else{
				String entryName = jarEntry.getName();
				entryName = entryName.replace("/", ".");
				if(entryName.contains(className)&&entryName.endsWith("class")){
					qualifiedName = qualifiedName+entryName+"\n";
				}
			}
		}
		return qualifiedName.equalsIgnoreCase("")?"":jarName+":\n"+qualifiedName+"\n";
	}
	
	public String findClass(String className){
		String str = "";
		for(JarFile jarFile:jarFileList){
			str = str+findClass(jarFile,className);
		}
		return str.equalsIgnoreCase("")?"Not Found!":str;
	}
	
	public List<JarFile> getjarFileList(){
		return jarFileList;
	}
	
	public static void main(String[] args){
		if(args.length ==0){
			String searchPath = "E:\\web\\BokeERPWeb\\webapps\\BokeERP";
			String className = "com.bokesoft.oss.spring.context.EnhancedXmlWebApplicationContext";
			ClassTool classTool = new ClassTool(searchPath);
			System.out.println(classTool.findClass(className));
		}
	}
}
