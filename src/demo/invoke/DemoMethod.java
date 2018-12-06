package demo.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * public Method[] getMethods()返回某个类的所有公用（public）方法包括其继承类的公用方法，当然也包括它所实现接口的方法。
 * public
 * Method[]getDeclaredMethods()对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
 * 当然也包括它所实现接口的方法。
 */
public class DemoMethod {
	public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<?> cls = Class.forName("demoMethod.DemoClass");
		System.out.println("cls=" + cls);
		Method printStatic = cls.getMethod("printStatic");
		printStatic.invoke(null);
		Method print = cls.getMethod("print");
		print.invoke(cls.newInstance());
		print = cls.getMethod("print", String.class);
		print.invoke(cls.newInstance(), "带参数方法输出");
	}
}
