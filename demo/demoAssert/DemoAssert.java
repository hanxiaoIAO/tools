package demoAssert;
/**
 * assert关键字实际上与assertTrue(String message, boolean condition)等方法并没有关系
 * 除了名字有些类似外，估计只有抛出的异常都属于AssertionError吧
 * */
public class DemoAssert {
    /**assert关键字:
     * assert boolean;
     * assert boolean:object;
     * 第一个参数为false程序报错;第二个参数可选,为报错信息
     * assert关键字可选择开启和关闭，参数为：
     * 1.-ea(-enableassertions)和-da(-disenableassertions):开启和关闭用户类的assertion功能。
     * 　可以以“：”后接参数，指定要开启或关闭的范围，参数可以是包名，类名，“...”(表示缺省值)。
     * 2. -esa(-enablesystemassertions)和-dsa(-disenablesystemassertions):开启和关闭系统类的assertion功能。
     * */
    public void demoAssert(){
	boolean a=false;
	assert !a;
	assert a:"a为false";
    }
    
    /**junit(单元测试框架)中的assert
     * 例如：assertTrue(String message, boolean condition)
     * 具体不在此详细说明
     * */
    public void demoAssertInJunit(){
	junit.framework.Assert.assertTrue("抛出AssertionError异常", false);
    }
    
    public static void main(String[] args){
	DemoAssert demoAssert = new DemoAssert();
	demoAssert.demoAssert();
	demoAssert.demoAssertInJunit();
    }
}
