package demo.demoXML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DemoXML {
	/**
	 * 创建XML文件
	 */
	protected void createXML(String path) throws IOException {
		Document doc = DocumentHelper.createDocument();
		doc.addElement("root");
		// 将document文档对象直接转换成字符串输出
		System.out.println(doc.asXML());
		saveDocument(doc, path);
	}

	/**
	 * 加载XML文件
	 */
	protected Document loadXML(String fileName) throws FileNotFoundException, DocumentException {
		FileInputStream initDateFile = new FileInputStream(fileName);
		SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(initDateFile);
		return doc;
	}

	/**
	 * 保存XML文档
	 */
	public void saveDocument(Document doc, String path) throws IOException {
		OutputFormat format = OutputFormat.createCompactFormat();

		/**
		 * dom4j提供了专门写入文件的对象XMLWriter XMLWriter构造方法：
		 * XMLWriter(OutputStream,OutputFormat) XMLWriter(Writer,OutputFormat)
		 * 三个参数均可缺省
		 */
		XMLWriter xmlWriter = new XMLWriter(new FileWriter(path), format);

		// writer.setEscapeText(false);//转义
		// format.setTrimText(false); // 保留空格
		format.setIndent("	"); // 设置首行缩进
		format.setNewlines(true); // 设置是否换行

		xmlWriter.write(doc);
		xmlWriter.flush();
		xmlWriter.close();
	}

	public static void main(String[] args) throws IOException, DocumentException {
		DemoXML demoXML = new DemoXML();
		demoXML.createXML("demo.xml");
		Document doc = demoXML.loadXML("demo.xml");
		Element root = doc.getRootElement();
		root.addElement("leaf");
		demoXML.saveDocument(doc, "demo.xml");
	}
}
