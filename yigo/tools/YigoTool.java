package tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class YigoTool {
	
	List<String[]> configList = new ArrayList<String[]>();
	List<String[]> configContainsJavaList = new ArrayList<String[]>();
	
	public YigoTool(String svnPath) throws Throwable{
		File files = new File(svnPath);
		if(files.isFile()){
			throw new Throwable("SVN路径不应该是文件");
		}
		String configName = "";
		String classPath ="";
		File tempFile = null;
		for (File file : files.listFiles()){
			if(file.isFile()){
				continue;
			}
			configName = file.getName();
			if(configName.toLowerCase().contains("config")){
				String[] config = new String[2];
				config[0] = configName.toLowerCase().replace("config", "");
				config[1] = file.getPath().replace("\\", "/");

				configList.add(config);
				
				classPath = config[1]+"/Module/SCM/Java/source";
				tempFile = new File(classPath);
				if(tempFile.exists()){
					String[] configContainsJava = new String[2];
					configContainsJava[0] = configName;
					configContainsJava[1] = classPath;
					configContainsJavaList.add(configContainsJava);
				}
			}
		}
	}

	public String getClassPath(){
		String str = "";
		for(String[] config:configContainsJavaList){
			str = str+"	<classpathentry kind=\"src\" path=\""+config[0]+"\"/>"+"\n";
		}
		return str;
	}
	
	public String getProject(){
		String str = "";
		for (String[] config : configContainsJavaList){
			str = str+"		<link>"+"\n"+"			<name>"+config[0]+"</name>"+"\n"+"			<type>2</type>"+"\n"+"			<location>"+config[1]+"</location>"+"\n"+"		</link>"+"\n";
		}
		return str;
	}
	
	public String  getcore(String mainConfig){
		String path = "";
		String name = "";
		String serverConfig = "";
		for (String[] config:configList) {
			if(config[0].equalsIgnoreCase(mainConfig)){
				serverConfig = "server.config="+config[1];
				continue;
			}
			name = name+config[0]+";";		
			path = path+config[1]+";";
		}
		String additionalConfig = "server.additionalConfig.path="+path+"\n"+"server.additionalConfig.name="+name;
		return serverConfig+"\n"+additionalConfig;
	}
	
	public static void main(String[] args) throws Throwable {
		String svnPath = "E:\\WXDT\\WXDTGYLSVN";
		YigoTool yigoTool = new YigoTool(svnPath);
		System.out.println(yigoTool.getcore("basis"));
//		System.out.println(yigoTool.getProject());
//		System.out.println(yigoTool.getClassPath());
	}
}
