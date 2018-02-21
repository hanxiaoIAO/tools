package demoSwing;

import javax.swing.JPanel;

/**
 * java提供了5种布局管理器分别是:BorderLayout,FlowLayout,GridBagLayout,GridLayout,null。
 * */

public class DemoJPanel extends JPanel{

    private static final long serialVersionUID = 1L;

    public DemoJPanel() throws Throwable{
	this.setVisible(true);
	System.out.println("JPanel的默认布局为流水布局("+this.getLayout().getClass()+")");
    }
}
