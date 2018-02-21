package jarTool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JarCollection {	
	
	private List<Jar> jarList;
	
	public JarCollection(String path) throws Throwable{
		initJarFile(path);
	}

	private void initJarFile(String path) throws Throwable {
		jarList = new ArrayList<Jar>();
		File file = new File(path);
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(int i = 0,length = files.length;i<length;i++){
				path = files[i].getAbsolutePath();
				initJarFile(path);
			}
		}else{
			String qualifiedName = file.getAbsolutePath();
			if(isJarFile(qualifiedName)){
				Jar jar = new Jar(qualifiedName);
				jarList.add(jar);
			}
		}
	}
	
	public void findClass(String className){
		for(Jar jar:jarList){
			if(jar.containsClass(className)){
				System.out.println(jar.getQualifiedName());
			}
		}
	}
	
	public boolean containsClass(String className){
		for(Jar jar:jarList){
			if(jar.containsClass(className)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isJarFile(String name){
		if(name.toLowerCase().endsWith(".jar")){
			return true;
		}
		return false;
	}
}
