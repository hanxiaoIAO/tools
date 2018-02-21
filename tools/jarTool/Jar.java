package jarTool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Jar {
	
	private String name;
	
	private String path;
	
	private String qualifiedName;
	
	private JarFile jarFile;
	
	private List<String> classList;
	
	public Jar(String qualifiedName) throws IOException {
		this.qualifiedName = qualifiedName;
		jarFile = new JarFile(qualifiedName);
	}
	
	public String getName(){
		return name;
	}
	
	public String getPath(){
		return path;
	}
	
	public String getQualifiedName(){
		return qualifiedName;
	}
	
	public JarFile getJarFile(){
		return jarFile;
	}

	public List<String> getClassList(){
		if (classList == null) {
			classList = new ArrayList<String>();
			Enumeration<JarEntry> jarEntries = jarFile.entries();
			while (jarEntries.hasMoreElements()) {
				JarEntry jarEntry = jarEntries.nextElement();
				if(!jarEntry.isDirectory()){
					String name = jarEntry.getName();
					if(name.endsWith(".class")){
						classList.add(name);
					}
				}
			}
		}
		return classList;
	}
	
	public boolean containsClass(String className){
		if(classList == null){
			getClassList();
		}
		return classList.contains(className);
	}
}
