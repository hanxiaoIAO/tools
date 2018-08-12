package demoReadFromConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DemoReadFromConsole {
	
	public static void main(String args[]){
		standard();
		buffered();
		scan();	
	}

	/**
	 * Scanner取得的输入以space, tab, enter 键为结束符，
	 * 使用BufferedReader的readLine( )方法
	 * 必须要处理java.io.IOException异常
	 * */
	private static void buffered() {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
		  String read = null;
		  System.out.print("输入数据：");
		  try {
		   read = br.readLine();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  System.out.println("输入数据："+read); 
	}

	/**
	 * 在新增一个Scanner对象时需要一个System.in对象，因为实际上还是System.in在取得用户输入。
	 * Scanner的next()方法用以取得用户输入的字符串；
	 * nextInt()将取得的输入字符串转换为整数类型；同样，nextFloat()转换成浮点型；nextBoolean()转换成布尔型。
	 * */
	private static void scan() {
		System.out.print("输入数据：");
		Scanner scanner = new Scanner(System.in);
		String read = scanner.nextLine();
		System.out.println("输入数据：" + read);
		scanner.close();
	}

	/**
	 * 使用标准输入串System.in
	 * System.in.read()一次只读入一个字节数据，而我们通常要取得一个字符串或一组数字
	 * System.in.read()返回一个整数
	 * 必须初始化
	 * */
	private static void standard() {
		System.out.println("标准输入串System.in");
		System.out.println("输入数据：");
		char read = '0';
		try {
			read = (char) System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("输入数据：" + read);
	}
}
