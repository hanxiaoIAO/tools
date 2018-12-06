package test.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Test1 {
	public static void ManageView() {
		JFrame jframe = new JFrame("超市购物管理");
		JMenuBar jmb = new JMenuBar();
		JMenu menu_shoping = new JMenu("查看购买商品");
		JMenu menu_user = new JMenu("会员管理");
		JMenu menu_store = new JMenu("仓库管理");
		JMenu menu_exit = new JMenu("退出");
		Object data[][] = { { 1, "张三", "男", "18", "010.82607080" }, { 2, "李四", "女", "24", "021.68727080" },
				{ 3, "王五", "男", "18", "0459.82607080" }, { 4, "赵六", "男", "18", "010.82607080" },
				{ 5, "任琦", "男", "18", "010.82607080" }, { 6, "吴八", "男", "18", "010.82607080" } };
		String columnNames[] = { "编号", "姓名", "性别", "年龄", "电话" };
		JTable table = new JTable(data, columnNames);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pane = new JScrollPane(table);
		Container contentPane = jframe.getContentPane();
		contentPane.setLayout(new FlowLayout());
		// JPanel jp=new JPanel();
		// jp.setLayout(new FlowLayout());
		JButton search = new JButton("查找");
		JButton add = new JButton("增加");
		JButton delete = new JButton("删除");
		JButton update = new JButton("修改");
		contentPane.add(search);
		contentPane.add(add);
		contentPane.add(delete);
		contentPane.add(update);

		jmb.add(menu_shoping);
		jmb.add(menu_user);
		jmb.add(menu_store);
		jmb.add(menu_exit);
		jframe.setJMenuBar(jmb);
		jframe.add(pane, BorderLayout.NORTH);
		// jframe.add(contentPane,BorderLayout.SOUTH);
		jframe.setSize(600, 500);
		jframe.setLocation(300, 200);
		jframe.setVisible(true);

	}

	public static void main(String[] args) {
		ManageView();
	}
}