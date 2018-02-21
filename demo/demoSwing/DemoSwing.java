package demoSwing;

import java.awt.Color;



/**
 * AWT和Swing
 * AWT:
 * 抽象窗口组件工具包，是 java 最早的用于编写图形节目应用程序的开发包
 * AWT 中的图形函数与操作系统所提供的图形函数之间有着一一对应的关系
 * 利用 AWT 来构件图形用户界面实际上是在利用操作系统所提供的图形库
 * 本地方法的C/C++程序，其运行速度比较快
 * Swing:
 *  是在AWT的基础上构建的一套新的图形界面系统
 *  用纯粹的Java代码对AWT 的功能进行了大幅度的扩充
 *  
 *  另外java的GUI库还有SWT,不包含于JDK中，需要从Eclipse单独下载
 * */

/**
 * Swing组件从功能上分可分为：
　1) 顶层容器：JFrame,JApplet,JDialog,JWindow共4个
　2) 中间容器：如：JPanel,JScrollPane,JSplitPane,JToolBar　
　3) 特殊容器：在GUI上起特殊作用的中间层，如JInternalFrame,JLayeredPane,JRootPane.
　4) 基本控件：实现人际交互的组件，如JButton, JComboBox, JList, JMenu, JSlider, JtextField。
　5) 不可编辑信息的显示：向用户显示不可编辑信息的组件，例如JLabel, JProgressBar, ToolTip。
　6) 可编辑信息的显示：向用户显示能被编辑的格式化信息的组件，如JColorChooser, JFileChoose, JFileChooser, Jtable, JtextArea 
 * */

public class DemoSwing {
    public static void main(String[] args) throws Throwable{  
	DemoJFrame frame = new DemoJFrame("Demo",800,800);
	DemoJPanel panel = new DemoJPanel();
	panel.setBackground(Color.cyan);
	for(int i=0;i<100;i++){
		DemoJButton button = new DemoJButton();
		panel.add(button);
	}
	frame.add(panel);
    }  
}
