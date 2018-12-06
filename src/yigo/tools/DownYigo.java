package yigo.tools;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tools.fileTool.ReadFileTools;
import tools.fileTool.WriteFileTools;


public class DownYigo {
	private static String urlPath = "http://1.1.12.11/yigo/Yigo1.6erp-Release";
	private static String yigoRealsePath;
	private static String[] fileNames = { "map-dev-src.jar", "map-dev.jar", "map-reportdesign.jar", "map-start.jar",
			"yigo-web2.jar", "yigoDesigner.jar" };
	private static String fileName = "version.txt";

	public static void main(String[] args) throws Exception {
		if (args == null || args.length < 1) {
			return;
		}
		yigoRealsePath = args[0];
		// yigoRealsePath = "F:";
		String version = "";
		if (args.length == 2) {
			version = args[1];
		}

		if (version != null && !version.isEmpty()) {
			downJars(version);
			return;
		}

		List<String> strList = ReadFileTools.readURLToStrList(urlPath);
		int maxSVNVersion = 0;
		for (String str : strList) {
			Pattern pattern = Pattern.compile("<a href=\"(.*)/\">");
			Matcher matcher = pattern.matcher(str);
			if (matcher.find()) {
				String tempVersion = matcher.group(1);
				if (tempVersion.startsWith("E_")) {
					int svnVersion = Integer.parseInt(tempVersion.substring(11, 16));
					if (svnVersion > maxSVNVersion) {
						maxSVNVersion = svnVersion;
						version = tempVersion;
					}
				}
			}
		}
		downJars(version);
	}

	private static void downJars(String version) throws Exception {
		// 把当前使用的版本生成到version.txt文件中
		WriteFileTools.WriteToFile(version, yigoRealsePath + File.separator + fileName);
		// 下载jar包
		File saveDir = new File(yigoRealsePath + File.separator + version);
		if (saveDir.exists()) {
			return;
		} else {
			saveDir.mkdir();
		}
		for (int i = 0; i < fileNames.length; i++) {
			URL url = new URL(urlPath + "/" + version + "/" + fileNames[i]);
			InputStream is = url.openStream();
			WriteFileTools.WriteToFile(is, yigoRealsePath + File.separator + version + File.separator + fileNames[i]);
		}

	}

}
