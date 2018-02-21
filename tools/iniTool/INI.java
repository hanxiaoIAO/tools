package iniTool;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class INI {
	public INI(String path) throws Throwable {
		if (!path.toLowerCase().endsWith(".ini")) {
			throw new Throwable("文件格式不符");
		}

		InputStreamReader isr = new InputStreamReader(
				new FileInputStream(path));
		BufferedReader bufferedReader = new BufferedReader(isr);
		init(bufferedReader);
	}
	
	public INI(BufferedReader bufferedReader) throws Throwable {
		init(bufferedReader);
	}

	List<Section> sections = new ArrayList<Section>();

	public Section getSection(String sectionName) throws Throwable {
		for (Section section : sections) {
			if (sectionName.equals(section.getSectionName())) {
				return section;
			}
		}
		return new Section("");
//		throw new Throwable("不存在Section： "+sectionName);
	}
	
	public List<Section> getSections(){
		return sections;
	}
	
	public void addSection(String SectionName){
		Section section = new Section(SectionName);
		sections.add(section);
	}
	
	public void addSection(Section section){
		sections.add(section);
	}

	private void init(BufferedReader bufferedReader) throws Throwable {
		String strLine = "";
		Section section = null;
		try {
			while ((strLine = bufferedReader.readLine()) != null) {
				strLine = strLine.trim();
				if (strLine.startsWith("[") && strLine.endsWith("]")) {
					section = new Section((String) strLine.subSequence(1,
							strLine.length() - 1));
					addSection(section);
				} else {
					if (section != null && strLine.contains("=")) {
						String[] property = strLine.split("=");
						if (property.length == 2) {
							section.addProperty(property[0].trim(), property[1].trim());
						} else {
							section.addProperty(property[0].trim(), "");
						}

					}
				}
			}
		} finally {
			bufferedReader.close();
		}

	}

}
