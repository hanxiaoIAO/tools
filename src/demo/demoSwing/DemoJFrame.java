package demo.demoSwing;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * java提供了5种布局管理器分别是:BorderLayout,FlowLayout,GridBagLayout,GridLayout,null。
 */

public class DemoJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public DemoJFrame(String title, int width, int height) throws Throwable {
		this.setTitle(title);
		this.setVisible(true);
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); // 增强外观
		this.setSize(width, height);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		System.out.println("JFrame的默认布局为边框布局(" + this.getLayout().getClass() + ")");
	}
}
