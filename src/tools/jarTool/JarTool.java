package tools.jarTool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarTool {
	String path;
	List<JarFile> jarFileList;
	HashMap<String, List<String>> mapJarFileToClasses;// key:jar包相对路径；value:jar包中所包含类的类名

	public JarTool(String path) {
		this.path = path;
	}

	public List<JarFile> getjarFileList() {
		if (jarFileList == null) {
			jarFileList = new ArrayList<JarFile>();
			initJarFileList(path);
		}
		return jarFileList;
	}

	public void findClass(String className) {
		if (mapJarFileToClasses == null) {
			mapJarFileToClasses = new HashMap<String, List<String>>();
			initMapJarFileNameToClasses();
		}

		for (Entry<String, List<String>> entry : mapJarFileToClasses.entrySet()) {
			for (String tempClassName : entry.getValue()) {
				if (tempClassName.toLowerCase().contains(className.toLowerCase())) {
					System.out.println(entry.getKey() + "\n" + tempClassName + "\n");
				}
			}
		}
	}

	public void findJar_HasRepeatedClass() {
		if (mapJarFileToClasses == null) {
			mapJarFileToClasses = new HashMap<String, List<String>>();
			initMapJarFileNameToClasses();
		}

		HashMap<String, String> mapClassToJarfile = new HashMap<String, String>();
		HashMap<String, String> mapRepeatClassToJarfile = new HashMap<String, String>();
		for (Entry<String, List<String>> entry : mapJarFileToClasses.entrySet()) {
			List<String> classesNames = entry.getValue();
			for (String className : classesNames) {
				String jarPath = entry.getKey();
				if (mapClassToJarfile.containsKey(className)) {
					jarPath = mapClassToJarfile.get(className) + "&&" + jarPath;
					mapRepeatClassToJarfile.put(className, jarPath);
				}
				mapClassToJarfile.put(className, jarPath);
			}
		}
		Iterator<Entry<String, String>> itEntry = mapRepeatClassToJarfile.entrySet().iterator();
		while (itEntry.hasNext()) {
			Entry<String, String> entry = itEntry.next();
			System.out.println("clsaaName:" + entry.getKey() + "\n" + "jarpath:" + entry.getValue() + "\n\n");
		}
	}

	private void initMapJarFileNameToClasses() {
		List<JarFile> jarFileList = getjarFileList();
		for (JarFile jarFile : jarFileList) {
			Enumeration<JarEntry> jarEntrys = jarFile.entries();
			String jarName = jarFile.getName().replace(path, "");
			List<String> classList = new ArrayList<String>();
			while (jarEntrys.hasMoreElements()) {
				JarEntry jarEntry = jarEntrys.nextElement();
				if (jarEntry.isDirectory()) {
					continue;
				} else {
					String entryName = jarEntry.getName();
					entryName = entryName.replace("/", ".");
					if (entryName.endsWith("class")) {
						classList.add(entryName);
					}
				}
			}
			mapJarFileToClasses.put(jarName, classList);
		}
	}

	private void initJarFileList(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0, length = files.length; i < length; i++) {
				path = files[i].getAbsolutePath();
				initJarFileList(path);
			}
		} else {
			if (file.getName().toLowerCase().endsWith(".jar")) {
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
}
