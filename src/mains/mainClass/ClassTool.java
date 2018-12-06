package mains.mainClass;

import tools.jarTool.JarTool;

public class ClassTool {

	public static void main(String[] args) {
		if (args.length == 0) {
			String searchPath = "E:\\project2.0\\JinJiao\\yigo";
			String className = "com.bokesoft.yes.fxwd.layout.GridPane";
			JarTool jarTool = new JarTool(searchPath);
			jarTool.findClass(className);
			// jarTool.findJar_HasRepeatedClass();
		}
	}
}
