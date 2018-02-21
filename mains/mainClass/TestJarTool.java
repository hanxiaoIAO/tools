package mainClass;

import jarTool.Jar;

public class TestJarTool {

	public static void main(String[] args) throws Throwable {
		String jarPath = "E:\\FES\\YigoCAD\\Embeded\\yigoDesign\\lib\\yigo-era-1.6.jar";
		Jar jar = new Jar(jarPath);
		jar.getClassList();
	}

}
