package mainClass;

import jarTool.JarTool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
//import java.util.HashMap;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassTool {

	public static void main(String[] args){
		if(args.length ==0){
			String searchPath = "E:\\yigo2.0\\BokeERP2.0\\webapps\\yigo";
			String className = "Parsers.SAXParser";
			JarTool jarTool = new JarTool(searchPath);
			jarTool.findClass(className);
		}
	}
}
